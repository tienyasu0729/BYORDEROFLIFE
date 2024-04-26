package inheritance;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Person person = new Person();
//        // đa hình tại biên dịch
//        person.howToGo();
//        person.howToGo("xe đạp ");
////        person.toString();
//        Student student = new Student();
//        // sử dụng method của cha
//        student.howToGo();
//        System.out.println(student.toString());
        // method private không cho kế thừa
//        student.howToGo1();
        // đa hình tại runtime
        Person person1 = new Student();
        person1.howToGo();
//        person1.study();
        Student student = (Student) person1;
        student.study();
        ((Student) person1).study();

        // muốn chỉ tạo một mảng mà có thể lưu được cả sinh vầ employee;
        Student[] students = new Student[10];
        students[0] = new Student();
        students[1] = new Student();
        Person[] people = new Person[20];
        people[0] = new Student();
        people[1] = new Employee();
        for (Person p: people) {
            if (p instanceof Student){
                ((Student)p).study();
            }else {
                ((Employee)p).countMoney();
            }
        }

    }

    public static  void displayMenu(){
//        StudentManager studentManager = new StudentManager();
        boolean flag =true;
        do {
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Display" +
                    "\n 2. Add" +
                    "\n 3.Delete" +
                    "\n 4. Edit" +
                    "\n 5. Search" +
                    "\n 6. Exit");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    // code display
                    System.out.println("chức năng hiện thị");
//                    studentManager.display();
                    break;
                case 2:
                    // code thêm mới
                    System.out.println("Chức năng thêm ới");
//                    studentManager.add();
                    break;
                case 3:
                    // code xóa
                    System.out.println("chức năng xóa");
                    break;
                case 4:
                    // code sửa
                    System.out.println("chức năng sửa");
                    break;
                case 5:
                    // code tìm kiếm
                    System.out.println("chức năng tìm kiếm");
                    break;
                default:
                    flag=false;
            }
        }while (flag);
    }
}
