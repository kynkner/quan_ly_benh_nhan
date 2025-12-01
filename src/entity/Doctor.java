package entity;

import logic.DoctorLogic;
import statics.TypeDoctor;
import utilities.CSVEntity;

import java.util.Scanner;

public class Doctor extends Person implements CSVEntity {
    public static int auto_id;
    int id;
    TypeDoctor typeDoctor;

    public Doctor() {
        if (!DoctorLogic.getInstance().getDoctorsList().isEmpty()){
            auto_id = DoctorLogic.getInstance().getLastPatientId() + 1;
        }else{
            auto_id = 1000;
        }
        this.id = auto_id;
        auto_id++;
    }

    public Doctor(String line) {
        String[] tokens = line.split(",");
        this.id = Integer.parseInt(tokens[0].trim());
        this.name = tokens[1].trim();
        this.age = Integer.parseInt(tokens[2].trim());
        this.gender = tokens[3].trim();
        this.birthday = tokens[4].trim();
        this.address = tokens[5].trim();
        this.phone = tokens[6].trim();
        this.email = tokens[7].trim();
        this.typeDoctor = TypeDoctor.valueOf(tokens[8].trim());
    }



    @Override
    public void displayInfo() {
        System.out.printf("%-5s | %-12s | %-19s | %-5s | %-9s | %-12s | %-21s | %-12s | %-21s | \n", this.id, this.typeDoctor, this.name, this.age, this.gender, this.birthday, this.address, this.phone, this.email);
    }

    @Override
    public void inputInfo(){
        super.inputInfo();
        System.out.println("Chọn chức vụ của bác sĩ");
        System.out.println("1. Bác sĩ");
        System.out.println("2. Y tá");
        System.out.println("3. Điều dưỡng");
        int num;
        do {
            num = new Scanner(System.in).nextInt();
            switch (num) {
                case 1 -> this.setTypeDoctor(TypeDoctor.BAC_SI);
                case 2 -> this.setTypeDoctor(TypeDoctor.Y_TA);
                case 3 -> this.setTypeDoctor(TypeDoctor.DIEU_DUONG);
            }
        }while (num < 1 || num > 3);
    }

    public static int getAuto_id() {
        return auto_id;
    }

    public static void setAuto_id(int auto_id) {
        Doctor.auto_id = auto_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeDoctor getTypeDoctor() {
        return typeDoctor;
    }

    public void setTypeDoctor(TypeDoctor typeDoctor) {
        this.typeDoctor = typeDoctor;
    }

    @Override
    public String toCSV() {
        return id + "," + name + "," + age + ","  + gender + ","  + birthday + ","  + address + ","  + phone + ","  + email + "," + typeDoctor;
    }

    @Override
    public String getCSVHeader() {
        return "id,name,gender,birthday,address,phone,email,typeDoctor";
    }
}
