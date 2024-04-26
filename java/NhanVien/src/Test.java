// Lớp Test
public class Test {
    public static void main(String[] args) {
        // Tạo đối tượng TemporaryEmployee
        TemporaryEmployee tempEmployee = new TemporaryEmployee(1, "John", "Doe", 25, "01/01/1998", 20, 0.5);
        System.out.println("Temporary Employee Information:");
        tempEmployee.displayInfo();

        System.out.println("----------------------------------------");

        // Tạo đối tượng PermanentEmployee
        PermanentEmployee permEmployee = new PermanentEmployee(2, "Jane", "Smith", 30, "01/01/1993", 25, 10);
        System.out.println("Permanent Employee Information:");
        permEmployee.displayInfo();
    }
}