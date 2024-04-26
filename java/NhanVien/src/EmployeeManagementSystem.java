import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private static ArrayList<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Employee Management System Menu:");
            System.out.println("1. Enter employee information");
            System.out.println("2. Display employee list by type");
            System.out.println("3. Sort employee list by salary (descending)");
            System.out.println("4. Find and delete employee by name");
            System.out.println("5. Calculate average salary by employee type");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    enterEmployeeInformation(scanner);
                    break;
                case 2:
                    displayEmployeeListByType();
                    break;
                case 3:
                    sortEmployeeListBySalary();
                    break;
                case 4:
                    findAndDeleteEmployeeByName(scanner);
                    break;
                case 5:
                    calculateAverageSalaryByType();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        } while (choice != 6);

        scanner.close();
    }

    private static void enterEmployeeInformation(Scanner scanner) {
        System.out.println("Enter employee information:");

        System.out.print("Employee type (1 = Temporary, 2 = Permanent): ");
        int type = scanner.nextInt();

        System.out.print("ID: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid ID.");
            System.out.print("ID: ");
            scanner.next(); // Đọc và bỏ qua giá trị không phải số
        }
        int id = scanner.nextInt();


        System.out.print("First Name: ");
        String firstName = scanner.next();

// Kiểm tra hợp lệ của First Name (chỉ chấp nhận chữ cái)
        while (!firstName.matches("[a-zA-Z]+")) {
            System.out.println("Invalid input! Please enter a valid First Name.");
            System.out.print("First Name: ");
            firstName = scanner.next();
        }

        System.out.print("Last Name: ");
        String lastName = scanner.next();

// Kiểm tra hợp lệ của Last Name (chỉ chấp nhận chữ cái)
        while (!lastName.matches("[a-zA-Z]+")) {
            System.out.println("Invalid input! Please enter a valid Last Name.");
            System.out.print("Last Name: ");
            lastName = scanner.next();
        }

        System.out.print("Age: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid Age.");
            System.out.print("Age: ");
            scanner.next();
        }
        int age = scanner.nextInt();

        System.out.print("Date of Birth: ");
        String dateOfBirth = scanner.next();

// Kiểm tra hợp lệ của Date of Birth (sử dụng một biểu thức chính quy phù hợp với định dạng ngày tháng)
        while (!dateOfBirth.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Invalid input! Please enter a valid Date of Birth (dd/mm/yyyy).");
            System.out.print("Date of Birth: ");
            dateOfBirth = scanner.next();
        }

        System.out.print("Working Days: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid number of Working Days.");
            System.out.print("Working Days: ");
            scanner.next();
        }
        int workingDays = scanner.nextInt();

        if (type == 1) {
            System.out.print("Discount Rate: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input! Please enter a valid Discount Rate.");
                System.out.print("Discount Rate: ");
                scanner.next();
            }
            double discountRate = scanner.nextDouble();

            TemporaryEmployee tempEmployee = new TemporaryEmployee(id, firstName, lastName, age, dateOfBirth, workingDays, discountRate);
            employeeList.add(tempEmployee);
        } else if (type == 2) {
            System.out.print("Overtime Hours: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid Overtime Hours.");
                System.out.print("Overtime Hours: ");
                scanner.next();
            }
            int overtimeHours = scanner.nextInt();

            PermanentEmployee permEmployee = new PermanentEmployee(id, firstName, lastName, age, dateOfBirth, workingDays, overtimeHours);
            employeeList.add(permEmployee);
        }

        System.out.println("Employee information entered successfully.");
    }

    private static void displayEmployeeListByType() {
        System.out.println("Employee List:");
        System.out.println("---------------");

        if (employeeList.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employeeList) {
                employee.displayInfo();
                System.out.println();
            }
        }
    }


    private static void sortEmployeeListBySalary() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees found. Cannot sort.");
        } else {
            Collections.sort(employeeList, new Comparator<Employee>() {
                @Override
                public int compare(Employee emp1, Employee emp2) {
                    double salary1 = emp1.calculateSalary();
                    double salary2 = emp2.calculateSalary();

                    if (salary1 < salary2) {
                        return 1;
                    } else if (salary1 > salary2) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });

            System.out.println("Employee List (Sorted by Salary - Descending):");
            System.out.println("----------------------------------------------");

            for (Employee employee : employeeList) {
                employee.displayInfo();
                System.out.println();
            }
        }
    }


    private static void findAndDeleteEmployeeByName(Scanner scanner) {
        System.out.print("Enter the name of the employee to delete: ");
        String name = scanner.next();

        boolean found = false;

        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if (employee.firstName.equalsIgnoreCase(name) || employee.lastName.equalsIgnoreCase(name)) {
                employeeList.remove(i);
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void calculateAverageSalaryByType() {
        double temporaryEmployeeTotalSalary = 0;
        double permanentEmployeeTotalSalary = 0;
        int temporaryEmployeeCount = 0;
        int permanentEmployeeCount = 0;

        if (employeeList.isEmpty()) {
            System.out.println("No employees found. Cannot calculate average salary.");
        } else {
            for (Employee employee : employeeList) {
                if (employee instanceof TemporaryEmployee) {
                    temporaryEmployeeTotalSalary += employee.calculateSalary();
                    temporaryEmployeeCount++;
                } else if (employee instanceof PermanentEmployee) {
                    permanentEmployeeTotalSalary += employee.calculateSalary();
                    permanentEmployeeCount++;
                }
            }

            double temporaryEmployeeAverageSalary = temporaryEmployeeTotalSalary / temporaryEmployeeCount;
            double permanentEmployeeAverageSalary = permanentEmployeeTotalSalary / permanentEmployeeCount;

            System.out.println("Average Salary by Employee Type:");
            System.out.println("--------------------------------");
            System.out.println("Temporary Employee Average Salary: " + temporaryEmployeeAverageSalary);
            System.out.println("Permanent Employee Average Salary: " + permanentEmployeeAverageSalary);
        }
    }

}
