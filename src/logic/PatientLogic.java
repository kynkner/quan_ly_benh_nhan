package logic;

import entity.Patient;
import utilities.CSVUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientLogic {
    private static PatientLogic patientLogic;
    private List<Patient> patientsList;
    public static final String PATIENTS_FILE = "patients.csv";

    public PatientLogic() {
    }

    public static PatientLogic getPatientLogic() {
        return patientLogic;
    }

    public static void setPatientLogic(PatientLogic patientLogic) {
        PatientLogic.patientLogic = patientLogic;
    }

    public List<Patient> getPatientsList() {
        return patientsList;
    }

    public void setPatientsList(List<Patient> patientsList) {
        this.patientsList = patientsList;
    }
    public static PatientLogic getInstance() {
        if (patientLogic == null) {
            patientLogic = new PatientLogic();
        }
        return patientLogic;
    }

    private PatientLogic(List<Patient> patients) {
        super();
        patientsList = new ArrayList<>(patients);
    }
    public static PatientLogic getInstance(List<Patient> patients) {
        if (patientLogic == null) {
            patientLogic = new PatientLogic(patients);
        }
        return patientLogic;
    }
    //Nhap benh nhan
    public void inputPatinet() {
        System.out.println("Nhập số bệnh nhân mới: ");
        int numberOfPatient = new Scanner(System.in).nextInt();
        for (int i = 0; i < numberOfPatient; i++) {
            System.out.println("Thông tin bệnh nhân thứ " + (i + 1));
            Patient patient = new Patient();
            patient.inputInfo();
            savePatient(patient);
        }
    }

    private void savePatient(Patient patient) {
        this.patientsList.add(patient);
        CSVUtils.getInstance().witeDataToFile(this.patientsList, PATIENTS_FILE);
    }

    private boolean checkExistPatient(Patient patient) {
        if (this.patientsList.isEmpty()){
            return false;
        }
        for(Patient p : this.patientsList){
            if(p.getId() == patient.getId()){
                return true;
            }
        }
        return false;
    }

    public void showPatinet() {
        if (this.patientsList.isEmpty()){
            System.out.println("Danh sach rong");
            return;
        }
        System.out.printf("%-5s | %-19s | %-5s | %-9s | %-12s | %-21s | %-12s | %-21s | \n","id", "ho va ten", "tuoi", "gioi tinh", "ngay sinh", "Dia chi", "phone", "email");
        for (Patient patient : this.patientsList) {
            patient.displayInfo();
        }
    }


    public int getLastPatientId() {
        return this.patientsList.get(this.patientsList.size() - 1).getId();
    }
}
