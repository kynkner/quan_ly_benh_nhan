package logic;

import entity.Doctor;
import utilities.CSVUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorLogic {
    private static DoctorLogic doctorLogic;
    private List<Doctor> doctorsList;
    public static final String DOCTORS_FILE = "doctors.csv";

    public DoctorLogic() {
    }
    public static DoctorLogic getInstance() {
        if (doctorLogic == null) {
            doctorLogic = new DoctorLogic();
        }
        return doctorLogic;
    }
    private DoctorLogic(List<Doctor> doctors) {
        super();
        doctorsList = new ArrayList<>(doctors);
    }

    public static DoctorLogic getDoctorLogic() {
        return doctorLogic;
    }

    public static void setDoctorLogic(DoctorLogic doctorLogic) {
        DoctorLogic.doctorLogic = doctorLogic;
    }

    public static DoctorLogic getInstance(List<Doctor> doctors) {
        if (doctorLogic == null) {
            doctorLogic = new DoctorLogic(doctors);
        }
        return doctorLogic;
    }

    public List<Doctor> getDoctorsList() {
        return doctorsList;
    }

    public void setDoctorsList(List<Doctor> doctorsList) {
        this.doctorsList = doctorsList;
    }

    public void inputDoctor() {
        System.out.println("Nhập số bác sĩ mới: ");
        int numberOfPatient = new Scanner(System.in).nextInt();
        for (int i = 0; i < numberOfPatient; i++) {
            System.out.println("Thông tin bác sĩ thứ " + (i + 1));
        }
        Doctor doctor = new Doctor();
        doctor.inputInfo();
        saveDoctor(doctor);
    }

    private void saveDoctor(Doctor doctor) {
        this.doctorsList.add(doctor);
        CSVUtils.getInstance().witeDataToFile(this.doctorsList, DOCTORS_FILE);
    }


    public void showDoctor() {
        if (this.doctorsList.isEmpty()) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.printf("%-5s | %-12s | %-19s | %-5s | %-9s | %-12s | %-21s | %-12s | %-21s | \n","id","Chuc vu", "ho va ten", "tuoi", "gioi tinh", "ngay sinh", "Dia chi", "phone", "email");
        for (Doctor doctor : this.doctorsList) {
            doctor.displayInfo();
        }
    }

    public int getLastPatientId() {
        return this.doctorsList.get(this.doctorsList.size() - 1).getId();
    }
}
