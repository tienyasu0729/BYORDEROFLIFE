package tiem_cam_do_tien_thanh.service;

import tiem_cam_do_tien_thanh.controller.Controller;
import tiem_cam_do_tien_thanh.model.CCCD;
import tiem_cam_do_tien_thanh.util.CheckTienThanh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CCCD_Service {
    static Scanner scanner = new Scanner(System.in);
    static List<CCCD> cccdList = new ArrayList<>();
    public static void mneuCCCD(){
        while (true) {
            System.out.println("" +
                    "---------------------------" +
                    "**** Căn cước công dân ****" +
                    "\n\n1. Hiển thị danh sách CCCD" +
                    "\n2. Thêm CCCD cầm" +
                    "\n3. Xoá CCCD cầm" +
                    "\n4. Tìm căn cước công dân" +
                    "\n5. Sủa CCCD" +
                    "\n6. Quay lại");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choose = CheckTienThanh.checkChooseTienThanh(4);
            switch (choose) {
                case 1:
                    displayCCCDList();
                    break;
                case 2:
                    addCCCD();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    Controller.mainMenu();
                    break;
            }
        }
    }
    private static void displayCCCDList(){
        System.out.println("--- Danh sách CCCD ---");
        for (CCCD list: cccdList) {
            System.out.println("CCCD: " + list.getCccd() + " | Tên: " + list.getName() + " | SĐT: " + list.getPhoneNumber() + " | Ngày cầm: " + list.getDayIn() + " | Ghi chú: " + list.getNote());
        }
    }
    private static void addCCCD(){
        System.out.println("--- Thêm Căn cước công dân ---");
        System.out.print("Nhập mã cccd: ");
        String cccd = CheckTienThanh.checkRegex("^[0-9]{12?}$", "Nhập sai mã cccd, xin nhập lại: ");
        System.out.print("Nhập tên của khách: ");
        String name = CheckTienThanh.checkRegex("^[\\p{L}\\s]+$", "Tên không chứa kí tự đặc biệt hoặc số, xin nhập lại: ");
        System.out.print("Nhập số điện thoại của khách hàng: ");
        String phoneNumber = CheckTienThanh.checkRegex("^[0-9]{10}$", "Nhập sai số điện thoại, xin nhập lại: ");
        System.out.print("Nhập ngày cầm : ");
        String dayIn = CheckTienThanh.checkRegex("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}$", "Nhập sai ngày cầm rồi, xin nhập lại: ");
        System.out.print("Nhập ghi chú : ");
        String note = scanner.nextLine();
        System.out.print("Bạn có chắn chắn thêm người này không.\n1. Có\n2. Không\nNhập lựa chọn của bạn: ");
        int choose = CheckTienThanh.checkChooseTienThanh(2);
        if (choose == 1){
            cccdList.add(new CCCD(cccd,name,phoneNumber,dayIn,note));
        }
    }
    private static void deleteCCCD(){
        boolean check = true;
        System.out.println("--- Xoá căn cước công dân ---");
        do {
            System.out.print("Nhập mã cccd cần xoá: ");
            String deleteCCCD = CheckTienThanh.checkRegex("^[0-9]{0,12}$", "Nhập sai định dạng CCCD, xin nhập lại: ");
            for (CCCD list: cccdList) {
                if (list.getCccd().equals(deleteCCCD)){
                    check = false;
                    System.out.println("--- Thêm Căn cước công dân ---");
                    System.out.print("Nhập mã cccd: ");
                    String cccd = CheckTienThanh.checkRegex("^[0-9]{12}$", "Nhập sai mã cccd, xin nhập lại: ");
                    System.out.print("Nhập tên của khách: ");
                    String name = CheckTienThanh.checkRegex("^[\\p{L}\\s]+$", "Tên không chứa kí tự đặc biệt hoặc số, xin nhập lại: ");
                    System.out.print("Nhập số điện thoại của khách hàng: ");
                    String phoneNumber = CheckTienThanh.checkRegex("^[0-9]{10}$", "Nhập sai số điện thoại, xin nhập lại: ");
                    System.out.print("Nhập ngày cầm : ");
                    String dayIn = CheckTienThanh.checkRegex("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}$", "Nhập sai ngày cầm rồi, xin nhập lại: ");
                    System.out.print("Nhập ghi chú : ");
                    String note = scanner.nextLine();
                    System.out.print("Bạn có chắn chắn thêm người này không.\n1. Có\n2. Không\nNhập lựa chọn của bạn: ");
                    int choose = CheckTienThanh.checkChooseTienThanh(2);
                    if (choose == 1){
                        cccdList.add(new CCCD(cccd,name,phoneNumber,dayIn,note));
                    }
                }
            }
            if(check){
                System.out.println("Không tìm thấy CCCD.");
            }
        }while (check);

    }
    private static void findCCCD(){

    }
    private static void edditCCCD(){

    }

}
