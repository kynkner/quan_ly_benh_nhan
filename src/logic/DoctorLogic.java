package logic;

import entity.Doctor;
import entity.Patient;

import java.util.List;
import java.util.Scanner;

public class DoctorLogic {
    private List<Doctor> doctorsList;

    public DoctorLogic() {
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
    }


    public void showDoctor() {
    }
}
