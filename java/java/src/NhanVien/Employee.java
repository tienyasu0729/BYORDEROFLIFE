package NhanVien;

public class Employee {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected int age;
    protected String dateOfBirth;
    protected int workingDays;

    // Phương thức khởi tạo
    public Employee(int id, String firstName, String lastName, int age, String dateOfBirth, int workingDays) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.workingDays = workingDays;
    }

    // Phương thức tính lương (sẽ được ghi đè bởi các lớp con)
    public double calculateSalary() {
        return 0;
    }

    // Phương thức hiển thị thông tin nhân viên
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Age: " + age);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Working Days: " + workingDays);
    }
}
