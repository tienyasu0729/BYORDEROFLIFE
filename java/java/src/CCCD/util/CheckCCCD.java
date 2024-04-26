package CCCD.util;

import java.util.Scanner;

public class CheckCCCD {
    private static final Scanner scanner = new Scanner(System.in);
//    private static Scanner scanner = new Scanner(System.in);
    public static int checkChoose(int numberInput){
        int choose = 0;
        boolean check = true;
        do {
            try {
                scanner.next();
                choose = Integer.parseInt(scanner.nextLine());
                if (choose <= numberInput && choose >= 0){
                    check = false;
                }else {
                    System.out.print("Nập quá số lựa chọn, xin mời nhập lại: ");
                }
            }catch (Exception e){
                System.out.print("Nhập lỗi rồi, xin mời nhập lại: ");
            }
        }while (check);
        return choose;
    }
    public static String checkRegex(String regex, String message){
        String input = null;
        do {
            input = scanner.nextLine();
            if (!input.matches(regex)){
                System.out.print(message);
            }
        }while (!input.matches(regex));
        return input;
    }
    public static int checkPrice(){
        int price = 0;
        boolean check = true;
        do {
            try {
                price = Integer.parseInt(scanner.nextLine());
                check = false;
            }catch (Exception e){
                System.out.print("Nhập sai giá tiền cầm rồi, xin mời nhập lại: ");
            }
        }while (check);
        return price;
    }
    public static void readPrice(int price){

    }
}
