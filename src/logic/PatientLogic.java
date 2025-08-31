package logic;

import entity.Patient;
import utilities.FileUtil;
import utilities.ScannerUtility;

import java.util.ArrayList;
import java.util.List;

public class PatientLogic {
    private static PatientLogic patientLogic;
    private List<Patient> patients;
    public static String PATIENT_DATA_FILE = "patients.dat";
    private PatientLogic(){

    }
    private PatientLogic(List<Patient> patients) {
        super();
        this.patients = patients;
    }

    public static PatientLogic getInstance(){
        if(patientLogic == null){
            patientLogic = new PatientLogic();
        }
        return patientLogic;
    }
    public static PatientLogic getInstance(List<Patient> patients){
        if(patientLogic == null){
            patientLogic = new PatientLogic(patients);
        }
        return patientLogic;
    }
    public List<Patient> getPatients() {
        return patients;
    }
    public void setPatients(List<Patient> patients) {
        this.patients = new ArrayList<>(patients);
    }


    //Nhap benh nhan
    public void inputPatinet() {
        System.out.println("Nhập số bệnh nhân mới: ");
        int numberOfPatient = ScannerUtility.inputInterger();
        for (int i = 0; i < numberOfPatient; i++) {
            System.out.println("Thông tin bệnh nhân thứ " + (i + 1));
            Patient patient = new Patient();
            if(checkExistPatient(patient)){
                continue;
            }
            System.out.println("test");
            patient.inputInfo();
            System.out.println("test_1");
            savePatient(patient);
        }
    }

    private void savePatient(Patient patient) {
        this.patients.add(patient);
        FileUtil.getInstance().writeDataFile(this.patients, PATIENT_DATA_FILE);
    }

    private boolean checkExistPatient(Patient patient) {
        if (this.patients.isEmpty()){
            return false;
        }
        for(Patient p : this.patients){
            if(p.getId() == patient.getId()){
                return true;
            }
        }
        return false;
    }

    public void showPatinet() {
        if (this.patients.isEmpty()){
            System.out.println("Danh sach rong");
            return;
        }
        System.out.printf("Ma khach hang", "ho va ten", "tuoi", "ngay sinh");
        for (Patient patient : this.patients) {
            patient.displayInfo();
        }
    }

    public int getLasPatientId() {
        return this.patients.get(this.patients.size() - 1).getId();
    }
}
