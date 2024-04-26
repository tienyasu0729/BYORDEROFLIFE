package tiem_cam_do_tien_thanh.controller;

import tiem_cam_do_tien_thanh.service.CCCD_Service;
import tiem_cam_do_tien_thanh.service.MobilePhone_Service;
import tiem_cam_do_tien_thanh.util.CheckTienThanh;

import java.util.Scanner;

public class Controller {
    private static Scanner scanner =new Scanner(System.in);
    public static void mainMenu(){
        System.out.println("--- TIỆM CẦM ĐỒ TIẾN THANH ---" +
                "\n1. Điện thoại" +
                "\n2. Xe máy" +
                "\n3. Căn cước công dân" +
                "\n4. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choose = CheckTienThanh.checkChooseTienThanh(4);
        switch (choose){
            case 1:
                MobilePhone_Service.menuTelephone();
                break;
            case 2:
                break;
            case 3:
                CCCD_Service.mneuCCCD();
                break;
            case 4:
                System.exit(0);
                break;
        }
    }


}
