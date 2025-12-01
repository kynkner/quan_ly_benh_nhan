package logic;

import entity.Patient;
import entity.Sick;
import utilities.CSVUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SickLogic {
    private static SickLogic sickLogic;
    private List<Sick> sickList;
    public static final String SICK_FILE = "sicks.csv";

    public SickLogic() {
    }

    public SickLogic(List<Sick> sicks) {
        super();
        sickList = new ArrayList<>(sicks);
    }

    public static SickLogic getSickLogic() {
        return sickLogic;
    }

    public static void setSickLogic(SickLogic sickLogic) {
        SickLogic.sickLogic = sickLogic;
    }
    public static SickLogic getInstance(){
        if (sickLogic == null){
            sickLogic = new SickLogic();
        }
        return sickLogic;
    }
    public static SickLogic getInstance(List<Sick> sicks) {
        if (sickLogic == null){
            sickLogic = new SickLogic(sicks);
        }
        return sickLogic;
    }

    public List<Sick> getSickList() {
        return sickList;
    }

    public void setSickList(List<Sick> sickList) {
        this.sickList = sickList;
    }

    public void inptutSick() {
        System.out.println("Nhập số bệnh moi: ");
        int numberOfPatient = new Scanner(System.in).nextInt();
        for (int i = 0; i < numberOfPatient; i++) {
            System.out.println("Thông tin bệnh: " + (i + 1));
            Sick sick = new Sick();
            sick.inputInfo();
            savePatient(sick);
        }
    }

    private void savePatient(Sick sick) {
        this.sickList.add(sick);
        CSVUtils.getInstance().witeDataToFile(this.sickList, SICK_FILE);
    }

    public void showSick() {
        System.out.printf("| %-5s | %-18s | \n", "id", "ten benh");
        for (Sick sick : sickList){
            sick.displayInfo();
        }
    }

    public int getLastPatientId() {
        return this.sickList.get(this.sickList.size() -1).getId();
    }
}
