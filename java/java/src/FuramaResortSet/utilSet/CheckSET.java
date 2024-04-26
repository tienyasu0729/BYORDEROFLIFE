package FuramaResortSet.utilSet;

import java.util.Scanner;

public class CheckSET {
    private static Scanner scanner = new Scanner(System.in);

    // kiểm tra tuổi
    public static int checkAge(){
        int age = 0;
        boolean check = true; // kiểm tra tuổi có hợp lệ không nếu có thì cho dừng vòng lặp
        do { // vòng lặp
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age <= 130 && age > 0){ // tuổi cao nhất từng được ghi nhận là 122 tuổi
                    check = false;
                }else {
                    System.out.print("Invalid data, please re-enter: ");
                }
            }catch (NumberFormatException e){
                System.out.print("Invalid data, please re-enter: ");
            }
        }while (check);
        return age;
    }




    // kiểm tra input theo regex
    // cần có chữ thông báo nhập lần đầu tiên
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


//    ^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$



    // kiểm tra input không dùng regex
//    public static String checkIntInPut(int inputLength) { // kiểm tra int nhập vào có bị lỗi về cố tình nhập chữ hay vượt phạm vi int không và trả về String
//        boolean check = true; // công tắc kích hoạt ( vòng lặp )
//        String input = null;
//        int firstTime = 1;
//
//        do { // ( vòng lặp )
//             // mảng kiểm tra nhập vào có chữ không
//            try {
//                if (firstTime == 1) { // if phân luồng kiểm ra tuổi hoặc số cccd
//                    input = scanner.nextLine();
//                } else {
//                    System.out.print("Invalid data, please re-enter: ");
//                    input = scanner.nextLine();
//                }
//                if (inputLength <= 3 && inputLength > 0) { // kiểm tra tuổi
//                    int checkAge = Integer.parseInt(input); // kiểm tra xem trong input nhập tuổi có chữ không, nếu có thì cho nó lỗi để nhảy sang catch
//                    if (input.length() <= inputLength){
//                        check = false;
//                    }
//                } else if (input.length() == inputLength) {
//                    char [] checkForLettersInput = input.toCharArray();
//                    for (int i = 0; i < input.length(); i++) {
//                        if (Character.isLetter(checkForLettersInput[i])){ // kiểm tra trong mảng ký tự char ( Character.isLetter() : kiểm tra bên trong có phải ký tự không, nếu có thì trả về true )
//                            check = true;
//                            break;
//                        }else {
//                            check = false;
//                        }
//                    }
//                }
//                firstTime = 2; // công tắc bật if phân luồng kiểm ra tuổi hoặc số cccd
//            } catch (Exception e) {
//                firstTime = 2;// công tắc bật if phân luồng kiểm ra tuổi hoặc số cccd
//            }
//        } while (check);
//        return input;
//    }

    public static int checkChoose(int numbersOfChoose) { // kiểm tra nhập vào có vượt ra khỏi số lựa chọn hay nhập chữ không
        // không dùng regex

                System.out.print("Enter your choose : ");
        int choose = 0;
        boolean check = false;
        try {
            choose = Integer.parseInt(scanner.nextLine());
            if (choose > numbersOfChoose || choose <= 0) { // kiểm tra xem số nhập vào lần đầu tiên có phù hợp không nếu không thì cho chạy vào ( vòng lặp ) điểm bắt nhập lại
                check = true;
            }
        } catch (NumberFormatException e) {
            System.out.println("-----Just only number of the menu-----");
            check = true;
        }
        if (check) { // ( vòng lặp ) kiểm tra dữ liệu nhập vào
            do {
                try {
                    System.out.print("You chose wrong, Please choose again : ");
                    choose = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("-----Just only number of the menu-----");
                }
            } while (choose > numbersOfChoose || choose <= 0);
        }
        return choose;


        // dùng regex

//        int choose = 0;
//        String firstRegex =
//        return choose;
    }
}
