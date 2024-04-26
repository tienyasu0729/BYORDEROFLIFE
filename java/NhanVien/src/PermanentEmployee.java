// Lớp con PermanentEmployee kế thừa từ lớp Employee
class PermanentEmployee extends Employee {
    private int overtimeHours;

    // Phương thức khởi tạo
    public PermanentEmployee(int id, String firstName, String lastName, int age, String dateOfBirth, int workingDays, int overtimeHours) {
        super(id, firstName, lastName, age, dateOfBirth, workingDays);
        this.overtimeHours = overtimeHours;
    }

    // Ghi đè phương thức tính lương
    @Override
    public double calculateSalary() {
        return workingDays * 1000000 + overtimeHours * 100000;
    }

    // Ghi đè phương thức hiển thị thông tin nhân viên
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Permanent Employee");
        System.out.println("Salary: " + calculateSalary());
    }
}