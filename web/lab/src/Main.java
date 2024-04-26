import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean check = true;
//        int soSach;
//        System.out.print("Nhập số lượng sách: ");
//        soSach = Integer.parseInt(kiemTra("^[0-9]+$", "- Số sách không hợp lệ: "));
        String[] tenSach = new String[6];
        tenSach[0] = "toan";
        tenSach[1] = "ly";
        tenSach[2] = "su";
        tenSach[3] = "hoa";
        tenSach[4] = "";
        tenSach[5] = "";
//        int[] namXuatBan = new int[soSach];
        int[] namXuatBan = new int[6];
        namXuatBan[0] = 2004;
        namXuatBan[1] = 2014;
        namXuatBan[2] = 2019;
        namXuatBan[3] = 2021;
        namXuatBan[4] = 0;
        namXuatBan[5] = 0;

        for (int i = 0; i < 6; i++) {
            if (i<4){
                System.out.println("-Sách thứ " + (i + 1) + " là: " + tenSach[i] + "\n- Năm xuất bản là: " + namXuatBan[i]);
            }
            while (i >= 4) {
                System.out.printf("Nhập thông tin cho sách thứ: %d\n", i + 1);
                System.out.print("Tên sách: ");
                tenSach[i] = kiemTra("^[a-zA-z]+$", "-Tên sách không hợp lệ, xin nhập lại: ");
                System.out.print("Năm xuất bản: ");
                namXuatBan[i] = Integer.parseInt(kiemTra("^[0-9]+$", "-Năm xuất bản sách không hợp lệ, xin nhập lại: "));
                if (namXuatBan[i] > 2000 && namXuatBan[i] < 2023) {
                    break;
                }else {
                    System.out.println("-Năm xuất bản sách không hợp lệ, xin nhập lại");
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            double giaSach;
            if (namXuatBan[i] < 2005) {
                giaSach = 0.8;
            } else if (namXuatBan[i] < 2015) {
                giaSach = 0.5;
            } else if (namXuatBan[i] < 2020) {
                giaSach = 0.3;
            } else if (namXuatBan[i] < 2022) {
                giaSach = 0.1;
            } else {
                giaSach = 0;
            }
            double giaBan = giaSach * 100;
            System.out.printf("Tên sách: %s\nNăm xuất bản: %d\nGiảm giá:  %.0f%% \n", tenSach[i], namXuatBan[i], giaBan);


        }
    }

    public static String kiemTra(String regex, String print) { // kiểm tra dữ liệu nhập vào có bị lỗi về cố tình nhập chữ hay vượt phạm vi int không { theo regex }
        String input = null;
        boolean check = true;
        do {
            input = scanner.nextLine();
            if (input.matches(regex)){
                check = false;
            }else {
                System.out.print(print);
            }
        }while (check);

        return input;
    }
}
