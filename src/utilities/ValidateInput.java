package utilities;

public class ValidateInput {

    public static boolean checkName(String name) {
        return name.matches("^[a-zA-Z0-9!@#$%^&*\\s]{6,35}$");
    }

    public static boolean checkAddress(String address) {
        return address.matches("^[a-zA-Z0-9!@#$%^&*\\s]{6,50}$");
    }

    public static boolean checkPhone(String phoneStr) {
        return phoneStr.matches("(^0[9|8|1|7|3|5](\\d){8}$)|(^0[9|8|1|7|3|5](\\d){10}$)");
    }

    public static boolean checkEmail(String email) {
        return email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$\n");
    }
}
