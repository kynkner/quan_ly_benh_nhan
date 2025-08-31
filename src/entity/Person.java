package entity;

import utilities.ScannerUtility;
import utilities.ValidateInput;


public class Person implements InputInfo{
    private String name;
    private int age;
    private String gender;
    private String birthday;
    private String address;
    private String phone;
    private String email;


    @Override
    public void inputInfo(){
        System.out.println("Nhập họ và tên: ");
        this.setName(inputName());
        System.out.println("Nhập tuổi: ");
        this.setAge(inputAge());
        System.out.println("Nhập giới tính: ");
        this.setGender(inputGender());
        System.out.println("Nhập ngày/tháng/năm sinh: ");
        this.setBirthday(inputBirthday());
        System.out.println("Nhập địa chỉ: ");
        this.setAddress(inputAddress());
        System.out.println("Nhập số điện thoại: ");
        this.setPhone(intputPhone());
        System.out.println("Nhập email: ");
        this.setEmail(inputEmail());
    }

    private String inputEmail() {
        String email;
        do {
            email = ScannerUtility.inputString();
            if (ValidateInput.checkEmail(email)){
                break;
            }
            System.out.println("Email nhập không đúng định dạng. Vui lòng nhập lại: ");
        }while (true);
        return email;
    }

    private String intputPhone() {
        long phone;
        String phoneStr;
        do {
            phone = ScannerUtility.inputLong();
            phoneStr = "0" + phone;

            if(ValidateInput.checkPhone(phoneStr)){
                break;
            }
            System.out.println("Số điện thoại định dạng không dúng vui lòng nhập lại: ");
        }while (true);
        return phoneStr;
    }

    private String inputAddress() {
        String address;
        do {
            address = ScannerUtility.inputStringInRange(6, 50);
            if(ValidateInput.checkAddress(address)){
                break;
            }
            System.out.println("Quá độ dài vui lòng nhập lại: ");
        }while (true);
        return address;
    }

    private String inputBirthday() {
        String str;
        str = ScannerUtility.inputString();
        return str;
    }

    private String inputGender() {
        String gender;
        do {
            gender = ScannerUtility.inputString();
        }while(gender.equals("n"));
        return gender;
    }

    private int inputAge() {
        int age;
        do {
            age = ScannerUtility.inputInterger();
        }while(age < 0 || age > 120);
        return age;
    }

    private String inputName() {
        String name;
        do{
            name = ScannerUtility.inputStringInRange(6, 35);
            if(ValidateInput.checkName(name)){
                break;
            }

            System.out.println("Tên nhân viên phải có độ dài 6 - 35 ký tự. Vui lòng nhập lại: ");
        }while (true);
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
