package test_retake_module_2.util;

import java.util.Scanner;

public class Check {
    static Scanner scanner = new Scanner(System.in);

    public static int checkChoose(int numbersOfChoose) {
        int choose = 0;
        boolean check = true;
        do {
            try {
                choose = Integer.parseInt(scanner.nextLine());
                if (choose <= numbersOfChoose && choose > 0) {
                    check = false;
                } else {
                    System.out.print("Lỗi, xin mời nhập lại :");
                }
            } catch (NumberFormatException e) {
                System.out.print("Lỗi, xin mời nhập lại :");
            }
        } while (check);

        return choose;
    }
    public static String checkIntInPut(String regex) { // kiểm tra dữ liệu nhập vào có bị lỗi về cố tình nhập chữ hay vượt phạm vi int không { theo regex }
        String input = null;
        boolean check = true;
        do {
            input = scanner.nextLine();
            if (input.matches(regex)){
                check = false;
            }else {
                System.out.print("Invalid data, please re-enter: ");
            }
        }while (check);

        return input;
    }

}
