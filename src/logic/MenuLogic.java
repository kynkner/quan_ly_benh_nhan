package logic;

import entity.Patient;
import utilities.CSVUtils;
import utilities.DataUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuLogic {
    private  PatientLogic patientLogic;
    private final DoctorLogic doctorLogic = new DoctorLogic();

    public void runData() {
        List<Patient> patients = CSVUtils.getInstance().readDataFromFile(PatientLogic.PATIENTS_FILE, line -> new Patient((String) line));
        this.patientLogic = PatientLogic.getInstance(patients);
    }

    public void run() {
        while (true) {
            showMenu();
            int choofunstion = inputChofuntion();
            switch (choofunstion) {
                case 1 -> patientLogic.inputPatinet();
                case 2 -> patientLogic.showPatinet();
                case 3 -> doctorLogic.inputDoctor();
                case 4 -> doctorLogic.showDoctor();
            }
        }
    }

    private int inputChofuntion() {
        System.out.println("Xin mời chọn chức năng: ");
        int choofuntion;
        do {
            choofuntion = new Scanner(System.in).nextInt();
            if (choofuntion > 0 && choofuntion < 3) {
                break;
            }
            System.out.println("Không có chức năng, vui lòng chọn lại: ");
        }while(true);

        return choofuntion;
    }

    private void showMenu() {
        System.out.println("---------------------Quản lý bệnh nhân--------------------");
        System.out.println("1. Nhập bệnh nhân mới");
        System.out.println("2. In danh sách bệnh nhân");
        System.out.println("3. Nhập bác sĩ mới"); // chua lam
        System.out.println("4. In danh sách các bác sĩ"); // chua lam
        System.out.println("5. Thêm loại bệnh mới"); // chua lam
        System.out.println("6. In danh sách các loại bệnh"); // chua lam
        System.out.println("7. Tạo hồ sơ bệnh án"); // chua lam, LUU Y: ho so benh an lay id di theo benh nhan
    }



}
