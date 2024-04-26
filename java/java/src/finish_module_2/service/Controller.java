package finish_module_2.service;

import finish_module_2.model.DanhBa;
import finish_module_2.util.CheckInput;
import finish_module_2.util.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    static List<DanhBa> danhBaList = new ArrayList<>();
    static Scanner scanner =new Scanner(System.in);
     public static void menu(){
danhBaList.add(new DanhBa("0000000000","ứdvsd","ádasd","sdfs","ádas",23,"sadasd"));
        while (true){
            System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ---" +
                    "\n1. Xem danh sách" +
                    "\n2. Thêm mới" +
                    "\n3. Cập nhật" +
                    "\n4. Xoá" +
                    "\n5. Tìm kiếm" +
                    "\n6. Đọc từ file" +
                    "\n7. Ghi vào file" +
                    "\n8. Thoát");
            int choose = CheckInput.checkChoose(8);
            switch (choose){
                case 1:
                    disply();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    find();
                    break;
                case 6:
                    readFromFile();
                    break;
                case 7:
                    writeToFile();
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }
    private static void disply(){
        if (danhBaList.isEmpty()){
            System.out.println("--- Danh bạ Rỗng ---");
        }else {
            for (int i = 0; i < danhBaList.size(); i++) {
                System.out.print(danhBaList.get(i) + "\n");
            }
        }
    }
    private static void add(){
        System.out.print("Nhập vào đây số điện thoại: ");
        String phoneNumber = CheckInput.checkInPut("^[0-9]{10}$");
        System.out.print("Nhập vào đây nhóm của số điện thoại: ");
        String group = scanner.nextLine();
        System.out.print("Nhập vào đây họ và tên: ");
        String fullName = scanner.nextLine();
        System.out.print("Nhập vào đây ngày sinh: ");
        int birthday = CheckInput.checkBirthday();
        System.out.print("Nhập vào đây giới tính: ");
        String sex = scanner.nextLine(); // cần làm rõ nam hay nữ
        System.out.print("Nhập vào đây địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Nhập vào email: ");
//        String email = CheckInput.checkInPut("chưa có regex"); // cần làm rõ nam hay nữ
        String email = scanner.nextLine();
        System.out.println("------------------------------\n" + new DanhBa(phoneNumber,group,fullName,sex,address,birthday,email));
        System.out.print("Bạn có muốn thêm người này không ?\n" + "1. YES\n" + "2. NO\n");
        int chooseYNAdd = CheckInput.checkChoose(2);
        if (chooseYNAdd == 1){
            danhBaList.add(new DanhBa(phoneNumber,group,fullName,sex,address,birthday,email));
            ReadAndWrite.writeDanhBa(new DanhBa(phoneNumber,group,fullName,sex,address,birthday,email));
        }

    }
    private static void update(){
         boolean check = true;
             System.out.print("Nhập vào đây số điện thoại Muốn sửa: ");
             String findNumberUpdate = CheckInput.checkInPut("^[0-9]{10}$");
             for (int i = 0; i < danhBaList.size(); i++) {
                 if (findNumberUpdate.equals(danhBaList.get(i).getPhoneNumber())){
                     System.out.print("Nhập vào đây nhóm của số điện thoại: ");
                     String group = scanner.nextLine();
                     System.out.print("Nhập vào đây họ và tên: ");
                     String fullName = scanner.nextLine();
                     System.out.print("Nhập vào đây ngày sinh: ");
                     int birthday = CheckInput.checkBirthday();
                     System.out.print("Nhập vào đây giới tính: ");
                     String sex = scanner.nextLine(); // cần làm rõ nam hay nữ
                     System.out.print("Nhập vào đây địa chỉ: ");
                     String address = scanner.nextLine();
                     System.out.print("Nhập vào email: ");
//                     String email = CheckInput.checkInPut("chưa có regex");
                     String email = scanner.nextLine();
                     System.out.println("------------------------------\n" + new DanhBa(findNumberUpdate,group,fullName,sex,address,birthday,email));
                     System.out.print("Bạn có muốn thêm người này không ?\n" + "1. YES\n" + "2. NO\n");
                     int chooseYNAdd = CheckInput.checkChoose(2);
                     if (chooseYNAdd == 1){
                         danhBaList.add(new DanhBa(findNumberUpdate,group,fullName,sex,address,birthday,email));
                         ReadAndWrite.writeAllDanhBa(danhBaList);
                     }
                 }

             }

    }
    private static void delete(){
        boolean check = true;
        do {
            System.out.print("Nhập vào đây số điện thoại Muốn sửa: ");
            String findNumberDelete = CheckInput.checkInPut("^[0-9]{10}$");
            if (findNumberDelete == "") break;
            for (int i = 0; i < danhBaList.size(); i++) {
                if (findNumberDelete.equals(danhBaList.get(i).getPhoneNumber())){
                    danhBaList.remove(i);
//                    ReadAndWrite.writeAllDanhBa(danhBaList);
                }
            }
        }while (check);
    }
    private static void find(){
         boolean checkFind = true;
        System.out.println("Nhập số điện thoại muốn tìm: ");
        String findNumber = CheckInput.checkInPut("^[0-9]{10}$");
        for (int i = 0; i < danhBaList.size(); i++) {
            if (findNumber.equals(danhBaList.get(i).getPhoneNumber())){
                System.out.println(danhBaList.get(i));
                checkFind = false;
            }
        }
        if (checkFind){
            System.out.println("Không có số này trong danh bạ.");
        }
    }
    private static void readFromFile(){
         ReadAndWrite.Read();

    }
    private static void writeToFile(){
        ReadAndWrite.writeAllDanhBa(danhBaList);
        System.out.println("--- Thành công ---");

    }
}
