package entity;

import logic.SickLogic;
import utilities.CSVEntity;

import java.util.Scanner;

public class Sick implements InputInfo, Displayable, CSVEntity {
    private int auto_id;
    private int Id;
    private String Name;


    public Sick() {
        if (!SickLogic.getInstance().getSickList().isEmpty()){
            auto_id = SickLogic.getInstance().getLastPatientId() + 1;
        }else{
            auto_id = 1000;
        }
        this.Id = auto_id;
        auto_id++;
    }

    public Sick(int auto_id, int id, String name, String sickName) {
        this.auto_id = auto_id;
        Id = id;
        Name = name;
    }

    public Sick(String line) {
        String[] tokens = line.split(",");
        this.Id = Integer.parseInt(tokens[0]);
        this.Name = tokens[1];
    }

    public int getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(int auto_id) {
        this.auto_id = auto_id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    @Override
    public void inputInfo() {
        System.out.println("Nhap ten benh: ");
        this.Name = new Scanner(System.in).next();
    }

    @Override
    public void displayInfo() {
        System.out.printf("| %-5s | %-18s | \n", Id, Name);
    }

    @Override
    public String toCSV() {
        return Id + "," + Name;
    }

    @Override
    public String getCSVHeader() {
        return "id,name";
    }
}
