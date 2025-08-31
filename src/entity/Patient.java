package entity;

import logic.PatientLogic;

public class Patient extends Person{
    public static int auto_id;
    private int Id;

    public Patient(){
        if(!PatientLogic.getInstance().getPatients().isEmpty()){
            auto_id = PatientLogic.getInstance().getLasPatientId() + 1;
        }else{
            auto_id = 10000;
        }
        this.Id = auto_id;
        auto_id++;
    }


    @Override
    public String toString() {
        return "....";
    }

    @Override
    public void inputInfo(){

    }

    public static void setAuto_id(int auto_id) {
        Patient.auto_id = auto_id;
    }

    public void setId(int id) {
        Id = id;
    }

    public static int getAuto_id() {
        return auto_id;
    }

    public int getId() {
        return Id;
    }
}
