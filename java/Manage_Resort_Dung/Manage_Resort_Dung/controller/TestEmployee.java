package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.entity.Employee;
import model.entity.Level;
import model.entity.Role;
import model.entity.WorkingParts;
import model.service.EmployeeService;

public class TestEmployee {
    static EmployeeService employeeService=new EmployeeService();
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        while (true) {
            System.out.println("1 add  | 2 display");
            int key= Integer.parseInt(sc.nextLine());
            switch (key) {
                case 0: System.exit(0);
                case 1:add();
                    
                    break;
            case 2: display();
                default:
                    break;
            }
        }
    }
    private static void display()throws Exception {
        ArrayList<Employee> employees=employeeService.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }
    private static void add()throws Exception {
        System.out.println("int id");
        int employeeId=Integer.parseInt(sc.nextLine());
        System.out.println("name");
        String employeeName=sc.nextLine();
        System.out.println("birthday");
        String birthday=sc.nextLine();
        System.out.println("id card");
        String identifyNumber=sc.nextLine();
        System.out.println("phone number");
        String phoneNumber=sc.nextLine();
        System.out.println("email");
        String email=sc.nextLine();
        System.out.println("level");
        ArrayList<Level> levels=employeeService.getAllLevels();
        for (Level level : levels) {
            System.out.println(level.toString());
        }
        int levelId=Integer.parseInt(sc.nextLine());
        System.out.println("role");
        ArrayList<Role> roles=employeeService.getAllRoles();
        for (Role role : roles) {
            System.out.println(role.toString());
        }
        int roleId=Integer.parseInt(sc.nextLine());
        System.out.println("working part");
        ArrayList<WorkingParts> workingParts=employeeService.getAllWorkingParts();
        for (WorkingParts workingParts2 : workingParts) {
            System.out.println(workingParts2.toString());
        }
        int workingPartId=Integer.parseInt(sc.nextLine());
        Employee employee=new Employee(employeeId, employeeName, birthday, identifyNumber, phoneNumber, email, employeeService.getLevelById(levelId), employeeService.getRoleById(roleId), employeeService.getWorkingPartById(workingPartId));
        employeeService.addEmployee(employee);
    }
}
