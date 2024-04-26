package finish_module_2.util;

import java.util.Scanner;

public class CheckInput {
    static Scanner scanner =new Scanner(System.in);
    public static int checkChoose(int numbersOfChoose) { // kiểm tra nhập vào có vượt ra khỏi số lựa chọn hay nhập chữ không
        System.out.print("Nhập lựa chọn của bạn : ");
        int choose = 0;
        boolean check = false;
        try {
            choose = Integer.parseInt(scanner.nextLine());
            if (choose > numbersOfChoose || choose <= 0) { // kiểm tra xem số nhập vào lần đầu tiên có phù hợp không nếu không thì cho chạy vào ( vòng lặp ) điểm bắt nhập lại
                check = true;
            }
        } catch (NumberFormatException e) {
            System.out.println("-----Chỉ nhập số-----");
            check = true;
        }
        if (check) { // ( vòng lặp ) kiểm tra dữ liệu nhập vào
            do {
                try {
                    System.out.print("Bạn đã nhập sai, xin nhập lại : ");
                    choose = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("-----Chỉ nhập số-----");
                }
            } while (choose > numbersOfChoose || choose <= 0);
        }
        return choose;
    }
    public static String checkInPut(String regex) { // kiểm tra dữ liệu nhập vào có bị lỗi về cố tình nhập chữ hay vượt phạm vi int không { theo regex }
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
    public static int checkBirthday(){
        int birthday = 0;
        boolean check = true; // kiểm tra tuổi có hợp lệ không nếu có thì cho dừng vòng lặp
        do { // vòng lặp
            try {
                birthday = Integer.parseInt(scanner.nextLine());
                if (birthday <= 31 && birthday > 0){ // tuổi cao nhất từng được ghi nhận là 122 tuổi
                    check = false;
                }else {
                    System.out.print("Bạn nhập sai ngày rồi: ");
                }
            }catch (NumberFormatException e){
                System.out.print("Chỉ được nhập số, vui lòng nhập lại: ");
            }
        }while (check);
        return birthday;
    }
}
