import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Student> students = inputInformation();
        System.out.println("------------- Danh sách học sinh ------------");
        showList(students);
        System.out.println("---------------------------------------------");

        System.out.print("Nhập tuổi để kiểm tra học sinh cùng tuổi: ");
        int inputAge = Integer.parseInt(checkIntInPut("^(?:[1-9]|[1-2][0-9]|30)$","-Chỉ được nhập số và nhỏ hơn 30, xin vui lòng nhập lại: "));
        List<Student> sameAgeStudents = checkStudentsSameAge(students, inputAge);
        if (!checkStudentsSameAge(students, inputAge).isEmpty()) {
            System.out.println("\n-------------------------------------\n" + "Học sinh có cùng tuổi: " + inputAge );
            for (Student student : sameAgeStudents) {
                student.printInformation();
                System.out.println();
            }
        } else {
            System.out.println("Không tìm thấy học sinh với độ tuổi đã nhập.");
        }
    }
    public static List<Student> inputInformation(){
        List<Student> students = new ArrayList<>();
        students.add(new CNTT("trần tiến", "12 đạo hàm", 11, 1,2));
        students.add(new Biz("Tiến Trần","12 tích phân", 12, 1,2));
        students.add(new Biz("Văn nam","12 tài xỉu", 13, 1,2));
        // Input and print information for 3 students
        for (int i = 0; i < 1; i++) {
            System.out.println("Nhập thông tin của học sinh thứ " + (i + 1));
            System.out.print("Họ và tên: ");
            String fullName = checkIntInPut("^[\\p{L}\\s]+$", "-Chỉ nhập chữ không nhập số, vui lòng nhập lại: ");
            System.out.print("Địa chỉ: ");
            String address = scanner.nextLine();
            System.out.print("Tuổi: ");
            int age = Integer.parseInt(checkIntInPut("^(?:[1-9]|[1-2][0-9]|30)$","-Chỉ được nhập số và nhỏ hơn 30, xin vui lòng nhập lại: "));

            System.out.print("Nhập khoa của sinh viên này (IT hay Biz): ");
            String faculty = checkIntInPut("^(?i)(it|biz)$", "-Chỉ được nhập ngành IT hoặc Biz, xin nhập lại: ");
            if (faculty.toLowerCase().equals("it")) {
                System.out.print("Điểm Java: ");
                double javaScore = Double.parseDouble(checkIntInPut("^-?\\d+(\\.\\d+)?$", "-Chỉ được nhập số, xin vui lòng nhập lại: "));
                System.out.print("Điểm CSS: ");
                double cssScore = Double.parseDouble(checkIntInPut("^-?\\d+(\\.\\d+)?$", "-Chỉ được nhập số, xin vui lòng nhập lại: "));
                Student student = new CNTT(fullName, address, age, javaScore, cssScore);
                student.calculateAverage();
                students.add(student);
            } else if (faculty.toLowerCase().equals("biz")) {
                System.out.print("Điểm Kế Toán: ");
                double accountingScore = Double.parseDouble(checkIntInPut("^-?\\d+(\\.\\d+)?$", "-Chỉ được nhập số, xin vui lòng nhập lại: "));
                System.out.print("Điểm Marketing: ");
                double marketingScore = Double.parseDouble(checkIntInPut("^-?\\d+(\\.\\d+)?$", "-Chỉ được nhập số, xin vui lòng nhập lại: "));
                Student student = new Biz(fullName, address, age, accountingScore, marketingScore);
                student.calculateAverage();
                students.add(student);
            }
        }
        return students;

    }
    public static void showList(List<Student> students){
        for (Student student: students) {
            student.printInformation();
            System.out.println();
        }
    }
    public static List<Student> checkStudentsSameAge(List<Student> students, int age) {
        List<Student> sameAgeStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.age == age) {
                sameAgeStudents.add(student);
            }
        }
        return sameAgeStudents;
    }

    public static String checkIntInPut(String regex, String mess) { // kiểm tra dữ liệu nhập vào có bị lỗi về cố tình nhập chữ hay vượt phạm vi int không { theo regex }
        Scanner scanner = new Scanner(System.in);
        String input = null;
        boolean check = true;
        do {
            input = scanner.nextLine();
            if (input.matches(regex)){
                check = false;
            }else {
                System.out.print(mess);
            }
        }while (check);

        return input;
    }
}
