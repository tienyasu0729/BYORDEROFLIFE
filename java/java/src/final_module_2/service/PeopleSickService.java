package final_module_2.service;

import final_module_2.model.People;
import final_module_2.util.Check;
import final_module_2.util.ReadAndWriteHospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeopleSickService {
    private static Scanner scanner = new Scanner(System.in);

    private static List<People> peopleList = new ArrayList<>();

    public static void writeAll(){
        ReadAndWriteHospital.writeAll(peopleList);
    }


    public static void add() {
        System.out.print("Mã bệnh án: ");
        String id = Check.checkIntInPut("^(BA)-[0-9]{4}$", "lỗi, xin nhập lại: ");
        System.out.print("Nhập Mã bệnh nhân: ");
        String idPeople = Check.checkIntInPut("^(BN)-[0-9]{3}$", "lỗi, xin nhập lại: ");
        System.out.print("Tên bệnh nhân: ");
        String name = Check.checkIntInPut("^[\\p{L}\\s]+$", "lỗi, xin nhập lại: ");
        System.out.print("Ngày nhập viện: ");
        String dayIn = Check.checkIntInPut("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}$", "lỗi, xin nhập lại: ");
        System.out.print("Ngày ra viện: ");
        String dayOut = Check.checkIntInPut("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}$", "lỗi, xin nhập lại: ");
        System.out.print("Lý do nhập viện: ");
        String reason = scanner.nextLine();
        System.out.print("Phí nhập viện: ");
        String price = Check.checkIntInPut("[0-9]{0,}", "lỗi, xin nhập lại: ");
        if (price == ""){
            System.out.print("Loại VIP ( VIP1 | VIP2 | VIP3 ): ");
            String vip = Check.checkIntInPut("^(VIP1|vip1|VIP2|vip2|VIP3|vip3)$", "lỗi, xin nhập lại: ");
            System.out.print("Thời hạn VIP: ");
            String timeVip = Check.checkIntInPut("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}$", "lỗi, xin nhập lại: ");
            peopleList.add(new People(peopleList.size() + 1, id,idPeople,name,dayIn,dayOut,reason,vip,timeVip));
        }else {
            peopleList.add(new People(peopleList.size() + 1, id,idPeople,name,dayIn,dayOut,reason,price));

        }

    }

    public static void delete() {
        boolean check = false;
        System.out.print("Mã bệnh án muốn xoá: ");
        String idDelete = Check.checkIntInPut("^(BA)-[0-9]{4}$", "NotFoundMedicalRecordException");
        for (int i = 0; i < peopleList.size(); i++) {
            if (idDelete.equals(peopleList.get(i).getId())){
                System.out.print("Are you sure ?\n" + "1. YES\n" + "2. NO\n");
                int chooseYNAdd = test_retake_module_2.util.Check.checkChoose(2);
                if (chooseYNAdd == 1){
                    peopleList.remove(i);
                    check = true;
                }
            }
        }
        if (check){
            for (int i = 0; i < peopleList.size(); i++) {
                System.out.println(peopleList.get(i));
            }
        }else {
            System.out.println("bệnh án không tồn tại");
        }
    }

    public static void display() {
        for (int i = 0; i < peopleList.size(); i++) {
            System.out.println(peopleList.get(i).getNumber() + " | " + peopleList.get(i).getId() + " | " + peopleList.get(i).getIdPeopple() + " | " + peopleList.get(i).getName() + " | " + peopleList.get(i).getDayIn() + " | " + peopleList.get(i).getDayOut() + " | " + peopleList.get(i).getReason());
        }
    }
}
