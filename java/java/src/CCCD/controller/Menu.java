package CCCD.controller;

import CCCD.util.CheckCCCD;

public class Menu {
    public static void menuCCCD(){
        System.out.println("--- CẦM CCCD TIẾN THANH ---" +
                "\n1. Xem danh sách CCCD cầm" +
                "\n2. Thêm CCCD cầm" +
                "\n3. Xoá CCCD cầm" +
                "\n4. Sửa CCCD cầm" +
                "\n5. Tìm CCCD cầm" +
                "\n0. Thoát.");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choose = CheckCCCD.checkChoose(5);
        switch (choose){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 0:
                System.exit(0);
                break;
        }
    }
}
