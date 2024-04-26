package test_retake_module_2.service;

import test_retake_module_2.model.Student;
import test_retake_module_2.util.Check;
import test_retake_module_2.util.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    private static List<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void writeStudentList(){
        ReadAndWrite.writeAll(studentList);
    }
    public static void readStudentList(){
        studentList = ReadAndWrite.ReadAll();
    }
    public static void add(){
        System.out.print("Nhập vào đây tên sinh viên");
        String name = Check.checkIntInPut("^[\\p{L}\\s]+$"); // regex bị sai không dùng được của chat GPT
//        String name = scanner.nextLine();
        System.out.print("Nhập vào đây ngày sinh");
        String day = Check.checkIntInPut("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}$");
        System.out.print("Nhập vào đây giới tính của sinh viên");
        String sex = Check.checkIntInPut("^(Nam|Nữ|nam|nữ)$");
        System.out.print("Nhập vào đây số điện thoại của sinh viên");
//        String phoneNumber = Check.checkIntInPut("^[0-9]{10}$");
        String phoneNumber = Check.checkIntInPut("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        System.out.print("Nhập vào đây mã lớp học của sinh viên:");
        int idClass = Check.checkChoose(1000000);
        System.out.println("------------------------------ \n" + new Student(studentList.size() + 1 ,name,day,sex,phoneNumber,idClass));
        System.out.print("Are you sure ?\n" + "1. YES\n" + "2. NO\n");
        int chooseYNAdd = Check.checkChoose(2);
        if (chooseYNAdd == 1){
            studentList.add(new Student(studentList.size() + 1,name,day,sex,phoneNumber,idClass));
        }
    }
    public static void delete(){
        boolean check = false;
        System.out.print("Nhạp id sinh viên muốn xoá: ");
        int idDelete = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < studentList.size(); i++) {
            if (idDelete == studentList.get(i).getIdStudent()){
                studentList.remove(i);
                check = true;
            }
        }
        if (check){
            System.out.print("Xoá thành công");
        }else {
            System.out.print("Không tìm thấy học xinh cần xoá");
        }
    }
    public static void display(){
        System.out.println("--- Danh sách học sinh ---");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
    }
    public static void find(){
        boolean check = false;
        System.out.print("Nhập tên sinh viên muốn tìm kiếm: ");
        String findName = scanner.nextLine();
        for (int i = 0; i < studentList.size(); i++) {
            if (findName.equals(studentList.get(i).getName())){
                System.out.println(studentList.get(i));
                check = true;
            }
        }
        if (check){
            System.out.println("Không tìm thấy tên học sinh đó");
        }
    }
}
