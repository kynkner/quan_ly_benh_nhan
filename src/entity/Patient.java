package entity;

import logic.PatientLogic;
import utilities.CSVEntity;

public class Patient extends Person implements CSVEntity {
    public static int auto_id;
    private int Id;

    public Patient() {
        if (PatientLogic.getInstance().getPatientsList().size() > 0){
            auto_id = PatientLogic.getInstance().getLastPatientId() + 1;
        }else {
            auto_id = 1000;
        }
        this.Id = auto_id;
        auto_id++;
    }

    public Patient(String name, int age, String gender, String birthday, String address, String phone, String email, int id) {
        super(name, age, gender, birthday, address, phone, email);
        this.Id = id;
    }


    public  Patient(String csvLine) {
        String[] tokens = csvLine.split(",");
        this.Id = Integer.parseInt(tokens[0].trim());
        this.name = tokens[1].trim();
        this.age = Integer.parseInt(tokens[2].trim());
        this.gender = tokens[3].trim();
        this.birthday = tokens[4].trim();
        this.address = tokens[5].trim();
        this.phone = tokens[6].trim();
        this.email = tokens[7].trim();
    }





    @Override
    public void inputInfo(){
        super.inputInfo();

    }


    public void setId(int id) {
        Id = id;
    }


    public int getId() {
        return Id;
    }
    @Override
    public void displayInfo(){

        System.out.printf("%-5s | %-19s | %-5s | %-9s | %-10s | %-21s | %-10s | %-21s | \n", this.Id, this.name, this.age, this.gender, this.birthday, this.address, this.phone, this.email);
    }

    @Override
    public String toCSV() {
        return Id + "," + this.name + "," + this.age + "," + this.gender + "," + this.birthday + "," + this.address + "," + this.phone + "," + this.email;
    }

    @Override
    public String getCSVHeader() {
        return "id,name,age,gender,birthday,address,phone,email";
    }
}
