package tiem_cam_do_tien_thanh.service;

import tiem_cam_do_tien_thanh.controller.Controller;
import tiem_cam_do_tien_thanh.util.CheckTienThanh;

public class MobilePhone_Service {
    public static void menuTelephone(){
        while (true){
            System.out.println("--- CẦM ĐỒ TIẾN THANH ---" +
                    "\n1. Hiển thị danh sách cầm đồ" +
                    "\n2. Thêm điện thoại cầm" +
                    "\n3. Xoá người cầm đồ" +
                    "\n4. Chỉnh sửa người cầm" +
                    "\n5. Giá hạn điện thoại" +
                    "\n6. Tìm kiếm người cầm" +
                    "\n7. Quay lại.");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choose = CheckTienThanh.checkChooseTienThanh(7);
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
                case 6:
                    break;
                case 7:
                    Controller.mainMenu();
                    break;
            }
        }

    }
}
