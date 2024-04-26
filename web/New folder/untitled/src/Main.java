import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đáy của tam giác: ");
        int d = Integer.parseInt(checkInPut("^[0-9]$"));
        System.out.print("Nhập chiều cao của tam giác: ");
        int h = Integer.parseInt(checkInPut("^[0-9]$"));
        System.out.print("- Diện tích của tam giác là: ");
        System.out.println(0.5 * d * h);
    }
    public static String checkInPut(String regex) { // kiểm tra dữ liệu nhập vào có bị lỗi về cố tình nhập chữ hay vượt phạm vi int không { theo regex }
        String input = null;
        boolean check = true;
        do {
            input = scanner.nextLine();
            if (input.matches(regex)){
                check = false;
            }else {
                System.out.print("- Chỉ nhập số, vui lòng không nhập chữ: ");
            }
        }while (check);
        return input;
    }
}