package test_retake_module_2.controller;

import test_retake_module_2.service.StudentService;
import test_retake_module_2.util.Check;

public class Controller {
    public static void menu() {
        StudentService.readStudentList();
        while (true) {
            System.out.println("--- Chương trình quản lý sinh viên ---" +
                    "\n1. Thêm mới sinh viên" +
                    "\n2. Xoá sinh viên" +
                    "\n3. Xem dánh sách sinh viên" +
                    "\n4. Xem thông tin giáo viên" +
                    "\n5. Tìm kiếm sinh viên" +
                    "\n6. Thoát");
            System.out.print("Nhập vào đây lựa chọn của bạn: ");
            int choose = Check.checkChoose(6);
            StudentService.writeStudentList();
            switch (choose) {
                case 1:
                    StudentService.add();
                    break;
                case 2:
                    StudentService.delete();
                    break;
                case 3:
                    StudentService.display();
                    break;
                case 4:

                    break;
                case 5:
                    StudentService.find();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
}
