package FuramaResortSet.serviceSet;

import FuramaResort.util.Check;
import FuramaResortSet.ModelSet.EmployeeSET;
import FuramaResortSet.utilSet.CheckSET;
import FuramaResortSet.utilSet.ReadAndWriteSET;
import FuramaResortSet.viewSet.MainMenuSET;

import java.util.*;

public class EmployeeServiceSET {
    static Scanner scanner = new Scanner(System.in);
    private static Set<EmployeeSET> listemployeeSET = new TreeSet<>();
    public static void mainEmployee() {
        listemployeeSET.addAll(ReadAndWriteSET.ReadAll());
        while (true){
            System.out.println("---------- EmployeeSet ----------\n" + "1Display list employees\n" + "2Add new employee\n" + "3Edit employee\n" + "4Return main menu");
            int chooseInEmployeeService = Check.checkChoose(4);
            // lựa chọn = kiểm tra dữ liệu nập vào (  lựa chọn cho trước không nằm trong số tương ứng với chức năng ( 0 ), số lượng chức năng trong quản lí )
            switch (chooseInEmployeeService) {
                case 1:
                    displayListEmployee();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    editEmployee();
                    break;
                case 4:
                    ReadAndWriteSET.writeAllEmployee(listemployeeSET);
                    MainMenuSET.displayMainMenu();
                    break;
            }
        }

    }

    public static void addEmployee() {
        System.out.println("---------- Add EmployeeSet ----------");
        System.out.print("Enter your CCCD : ");
        String cccd = CheckSET.checkIntInPut("^[0-9]{12}$");
        System.out.print("Enter your NAME : ");
        String name = scanner.nextLine();
        System.out.print("Enter your AGE : ");
        int age = CheckSET.checkAge();
        System.out.print("Enter your SKILL : ");
        String skill = scanner.nextLine();
        System.out.println("------------------------------ \nEmployee { CCCD: " + cccd + ", Name: " + name + ", Age: " + age + ", Skill: " + skill + " }");
        System.out.print("Are you sure ?\n" + "1. YES\n" + "2. NO\n");
        int chooseYNAdd = CheckSET.checkChoose(2);
        if (chooseYNAdd == 1){
            ReadAndWriteSET.writeEmployee(new EmployeeSET(cccd,name,age,skill));
            listemployeeSET.add(new EmployeeSET(cccd,name,age,skill));
        }
    }

    public static void displayListEmployee() {
        if (listemployeeSET.isEmpty()){
            System.out.println("----- List Employees is empty -----");
        }else {
            System.out.println("----- List Employees -----");
            for (EmployeeSET list : listemployeeSET) {
                System.out.println("CCCD: " + list.getCccd() + ", Name: " + list.getName() + ", Age: " + list.getAge() + ", Skills: " + list.getSkills());
            }
        }
    }

    public static void editEmployee() {
        System.out.print("Enter CCCD you want to edit : ");
        boolean checkFindCCCD;
        List<EmployeeSET> listemployeeArrayList = new ArrayList<>();
        listemployeeArrayList.addAll(listemployeeSET);
        do {
            checkFindCCCD = true; // kiểm tra xem có tìm được cccd đó không
            String findCCCD = CheckSET.checkIntInPut("^[0-9]{12}$");
            for (int i = 0; i < listemployeeArrayList.size(); i++) {
                if (findCCCD.equals(listemployeeArrayList.get(i).getCccd())){
                    checkFindCCCD = false;
                    System.out.println("---------- Edit EmployeeSet ----------");
                    System.out.print("Enter your CCCD : ");
                    String cccd = CheckSET.checkIntInPut("^[0-9]{12}$");
                    System.out.print("Enter your NAME : ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your AGE : ");
                    int age = CheckSET.checkAge();
                    System.out.print("Enter your SKILL : ");
                    String skill = scanner.nextLine();
                    System.out.println("------------------------------ \nEmployee { CCCD: " + cccd + ", Name: " + name + ", Age: " + age + ", Skill: " + skill + " }");
                    System.out.print("Are you sure ?\n" + "1. YES\n" + "2. NO\n");
                    int chooseYNAdd = CheckSET.checkChoose(2);
                    if (chooseYNAdd == 1){
                        listemployeeArrayList.set(i, new EmployeeSET(cccd,name,age,skill));
                        listemployeeSET.clear();
                        listemployeeSET.addAll(listemployeeArrayList);
//                        ReadAndWriteSET.writeEdit(listemployeeSET);
                        System.out.println("----- Successful -----");
                    }
                }
            }
            if (checkFindCCCD){
                System.out.println("---Can not find your CCCD ---");
            }
        } while (checkFindCCCD);
    }
}
