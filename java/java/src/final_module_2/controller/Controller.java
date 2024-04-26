package final_module_2.controller;

import final_module_2.service.PeopleSickService;
import final_module_2.util.Check;

public class Controller {
    public static void menu(){
        while (true){
            System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN ---" +
                    "\n1. Thêm mới" +
                    "\n2. Xoá" +
                    "\n3. Xem danh sách các bệnh án" +
                    "\n4. Thoát");
            System.out.print("Chọn chức năng: ");
            int choose = Check.checkChoose(4);
            switch (choose){
                case 1:
                    PeopleSickService.add();
                    break;
                case 2:
                    PeopleSickService.delete();
                    break;
                case 3:
                    PeopleSickService.display();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
            PeopleSickService.writeAll();
        }
    }
}
