import java.util.Scanner;

public class lab2 {
    //menthod Nhập dữ liệu
    public static void nhapDulieu(int n, String[] ten, int[] nam) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập thông tin cho sách thứ: %d\n", i + 1);
            System.out.print("Tên sách: ");
            ten[i] = input.nextLine();
            System.out.print("Năm xuất bản: ");
            nam[i] = input.nextInt();
            input.nextLine();
        }
    }
    //menthod Kiểm Tra Khuyễn Mãi
    public static double khuyenMai(int nam) {
        if (nam < 2005) {
            return 0.8;
        } else if (nam < 2015) {
            return 0.5;
        } else if (nam < 2020) {
            return 0.3;
        } else if (nam < 2022) {
            return 0.1;
        } else {
            return 0;
        }
    }
    // Menthod kiểm tra năm xuất bản
    public static boolean checkNamXuatBan(int nam) {
        return nam > 2000 && nam < 2023;
    }
    //Menthod in dữ liệu
    public static void inDuLieu(String[] ten, int[] nam) {
        for (int i = 0; i < ten.length; i++) {
            System.out.printf("Tên sách: %s\nNăm xuất bản: %d\n", ten[i], nam[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soSach = 5;
        String[] tenSach = new String[soSach];
        int[] namXuatBan = new int[soSach];

        nhapDulieu(soSach, tenSach, namXuatBan);

        for (int i = 0; i < soSach; i++) {
            while (!checkNamXuatBan(namXuatBan[i])) {
                System.out.println("Năm xuất bản không hợp lệ. Vui lòng nhập lại.");
                System.out.print("Nhập năm xuất bản: ");
                namXuatBan[i] = scanner.nextInt();
                scanner.nextLine();
            }
        }

        inDuLieu(tenSach, namXuatBan);

        for (int i = 0; i < soSach; i++) {
            double giaSach = khuyenMai(namXuatBan[i]);
            double giaBan = giaSach * 100;
            System.out.printf("Giảm giá:  %.0f%% \n", giaBan);
        }
    }
}
