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
    public void displayInfo() {
        System.out.printf("",this.Id, this.getName(), this.getAge(), this.getGender(), this.getBirthday(), this.getAddress(), this.getPhone(), this.getEmail()    );
    }
}
