package NhanVien;

class TemporaryEmployee extends Employee {
    private double discountRate;

    // Phương thức khởi tạo
    public TemporaryEmployee(int id, String firstName, String lastName, int age, String dateOfBirth, int workingDays, double discountRate) {
        super(id, firstName, lastName, age, dateOfBirth, workingDays);
        this.discountRate = discountRate;
    }

    // Ghi đè phương thức tính lương
    @Override
    public double calculateSalary() {
        return workingDays * 1000000 * 0.5 * (1 - discountRate);
    }

    // Ghi đè phương thức hiển thị thông tin nhân viên
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Temporary Employee");
        System.out.println("Salary: " + calculateSalary());
    }
}