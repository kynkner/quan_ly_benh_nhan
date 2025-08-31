package utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtility {

    public static int inputInterger() {
        int number;
        do{
            try{
                number = new Scanner(System.in).nextInt();
                break;
            }catch (InputMismatchException e){
                PrintMessage.printErrorMessageInterger();
            }
        }while (true);
        return number;
    }

    public static String inputString() {
        String str;
        do {
                str = new Scanner(System.in).nextLine();
                if(!str.equals("")){
                    break;
                }
                PrintMessage.printErrorMessageString();
        }while (true);
        return str;
    }

    public static String inputStringInRange(int i, int i1) {
        String str;
        do {
            str = inputString();
            if(str.length() >= i && str.length() <= i1){
                break;
            }
            System.out.printf("Độ dài tối thiếu trong khoảng [%d - %d]. Vui lòng nhập lại. \n", i, i1);
        }while (true);
        return str;
    }

    public static long inputLong() {
        long number;
        do {
            try {
                number = new Scanner(System.in).nextLong();
                break;
            }catch (InputMismatchException e){
                PrintMessage.printErrorMessageInterger();
            }
        }while (true);
        return number;
    }
}
