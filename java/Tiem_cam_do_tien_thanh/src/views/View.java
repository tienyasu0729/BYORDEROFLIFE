package views;

import validate.Validate;

import java.util.List;
import java.util.Scanner;

public class View<T> {
    private static Scanner scanner = new Scanner(System.in);

    public static void printTypeMenu(String type) {
        System.out.println("----- " + type.toUpperCase() + " MENU -----\n" +
                "1. Hiển thị danh sách " + type + " cầm\n" +
                "2. Thêm " + type + " cầm\n" +
                "3. Sửa thông tin " + type + " cầm\n" +
                "4. Xoá " + type + " cầm\n" +
                "5. Gia hạn " + type + " cầm\n" +
                "6. Lấy " + type + " cầm\n" +
                "7. Tìm " + type + " cầm theo ID\n" +
                "8. Tìm " + type + " cầm theo tên\n" +
                "9. Quay lại menu chính\n" +
                "10. Thoát."
        );
    }

    public static void printMainMenu() {
        System.out.println("----- MAIN MENU -----\n" +
                "1. Phone\n" +
                "2. Laptop\n" +
                "3. Vehicle\n" +
                "4. Thoát"
        );
    }

    private static void viewOptionCommon() {
        System.out.println("----- Lựa chọn thông tin muốn chỉnh sửa -----\n" +
                "1. Chỉnh sửa tên\n" +
                "2. Chỉnh sửa CCCD\n" +
                "3. Chỉnh sửa số tiền cầm\n" +
                "4. Chỉnh sửa số điện thoại\n" +
                "5. Chỉnh sửa ngày cầm\n" +
                "6. Chỉnh sửa ghi chú"
        );
    }

    public void viewOptionPhone() {
        viewOptionCommon();
        System.out.println(
                "7. Chỉnh sửa hãng điện thoại\n" +
                        "8. Chỉnh sửa tên điện thoại cầm\n" +
                        "9. Chỉnh sửa mật khẩu điện thoại cầm\n" +
                        "10. Chỉnh sửa tình trạng điện thoại\n" +
                        "11. Thoát ra menu điện thoại"
        );
    }

    public void viewOptionLaptop() {
        viewOptionCommon();
        System.out.println(
                "7. Chỉnh sửa hãng Laptop\n" +
                        "8. Chỉnh sửa tên Laptop cầm\n" +
                        "9. Chỉnh sửa mật khẩu laptop cầm\n" +
                        "10. Chỉnh sửa tình trạng Laptop\n" +
                        "11. Thoát ra menu laptop"
        );
    }

    public void viewOptionVehicle() {
        viewOptionCommon();
        System.out.println(
                "7. Chỉnh sửa hãng xe cầm\n" +
                        "8. Chỉnh sửa tên xe cầm\n" +
                        "9. Chỉnh sửa biển số xe cầm\n" +
                        "10. Chỉnh sửa tình trạng xe cầm\n" +
                        "11. Thoát ra menu xe"
        );
    }

    public static Boolean confirm(String title) {
        System.out.println(title + "\n1. Có\n2. Không");
        String choose = Validate.checkIntInPut("^[12]$", "- Nhập lựa chọn của bạn: ", "- Chỉ được lựa chọn 1 hoặc 2 và không được chứa ký tự: ");
        if (choose.equals("1")) {
            return true;
        } else {
            return false;
        }
    }

    public void printList(List<T> lists, String type) {
        System.out.println("---------- " + type + " ----------");
        if (lists.isEmpty()) {
            System.out.println(type + " rỗng");
        } else {
            for (T list : lists) {
                System.out.println(list.toString());
            }
        }
        System.out.println("----------------------------------------");
    }

    public static String manufacturerPhone() {
        System.out.println("Lựa chọn hãng điện thoại\n" +
                "1. Samsung\n" +
                "2. Iphone\n" +
                "3. Redmi\n" +
                "4. Oppo\n" +
                "5. Khác");
        int choose = Integer.parseInt(Validate.checkIntInPut("^[1-5]$", "- Nhập lựa chọn của bạn: ", "- Chỉ nhập số từ 1 - 5, xin mời nhập lại: "));
        String result = null;
        switch (choose) {
            case 1:
                result = "Samsung";
                break;
            case 2:
                result = "Iphone";
                break;
            case 3:
                result = "Redmi";
                break;
            case 4:
                result = "Oppo";
                break;
            case 5:
                System.out.print("- Nhập lựa chọn khác của bạn: ");
                result = scanner.nextLine();
                break;
        }
        return result;
    }

    public static String manufacturerLaptop() {
        System.out.println("Lựa chọn hãng máy tính\n" +
                "1. Asus\n" +
                "2. Dell\n" +
                "3. Hp\n" +
                "4. Macbook\n" +
                "5. Khác");
        int choose = Integer.parseInt(Validate.checkIntInPut("^[1-5]$", "- Nhập lựa chọn của bạn: ", "- Chỉ nhập số từ 1 - 5, xin mời nhập lại: "));
        String result = null;
        switch (choose) {
            case 1:
                result = "Asus";
                break;
            case 2:
                result = "Dell";
                break;
            case 3:
                result = "Hp";
                break;
            case 4:
                result = "Macbook";
                break;
            case 5:
                System.out.print("- Nhập lựa chọn khác của bạn: ");
                result = scanner.nextLine();
                break;
        }
        return result;
    }

    public static String manufacturerVehicle() {
        System.out.println("Lựa chọn Loại xe\n" +
                "1. Sirius\n" +
                "2. SH\n" +
                "3. Exciter\n" +
                "4. Winner\n" +
                "5. Khác");
        int choose = Integer.parseInt(Validate.checkIntInPut("^[1-5]$", "- Nhập lựa chọn của bạn: ", "- Chỉ nhập số từ 1 - 5, xin mời nhập lại: "));
        String result = null;
        switch (choose) {
            case 1:
                result = "Sirius";
                break;
            case 2:
                result = "SH";
                break;
            case 3:
                result = "Exciter";
                break;
            case 4:
                result = "Winner";
                break;
            case 5:
                System.out.print("- Nhập lựa chọn khác của bạn: ");
                result = scanner.nextLine();
                break;
        }
        return result;
    }
}
