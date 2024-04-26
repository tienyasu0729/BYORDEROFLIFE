package FuramaResortSet.serviceSet;

import FuramaResort.util.Check;
import FuramaResortSet.ModelSet.CustomerSET;
import FuramaResortSet.utilSet.CheckSET;
import FuramaResortSet.utilSet.ReadAndWriteSET;
import FuramaResortSet.viewSet.MainMenuSET;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CustomerServiceSet {
    static Scanner scanner = new Scanner(System.in);
    private static Set<CustomerSET> customerSETList = new TreeSet<>();
    public static void mainEmployee() {
        customerSETList.addAll(ReadAndWriteSET.ReadCustomerAll());
        while (true){
            System.out.println("---------- CustomerSet ----------\n" + "1.Display list customer\n" + "2.Add new customer\n" + "3.Edit customer\n" + "4.Return main menu");
            int chooseInEmployeeService = Check.checkChoose(4);
            // lựa chọn = kiểm tra dữ liệu nập vào (  lựa chọn cho trước không nằm trong số tương ứng với chức năng ( 0 ), số lượng chức năng trong quản lí )
            switch (chooseInEmployeeService) {
                case 1:
                    displayListCustomer();
                    break;
                case 2:
                    addNewCustomer();
                    break;
                case 3:
                    editCustomer();
                    break;
                case 4:
                    ReadAndWriteSET.writeAllCustomer(customerSETList);
                    MainMenuSET.displayMainMenu();
                    break;
            }
        }

    }
    private static void displayListCustomer(){
        if (customerSETList.isEmpty()){
            System.out.println("----- List is empty -----");
        }else {
            System.out.println("----- List customers -----");
            for (CustomerSET list: customerSETList) {
                System.out.println("CCCD: " + list.getCccd() + ", Name: " + list.getName() + ", Age: " + list.getAge() + ", Skills: " + list.getPhoneNumBer());
            }
        }
    }
    private static void addNewCustomer(){
        System.out.println("---------- Add Customer ----------");
        System.out.print("Enter your CCCD : ");
        String cccd = CheckSET.checkIntInPut("^[0-9]{12}$");
        System.out.print("Enter your NAME : ");
        String name = scanner.nextLine();
        System.out.print("Enter your AGE : ");
        int age = CheckSET.checkAge();
        System.out.print("Enter your SKILL : ");
        String phoneNumber = CheckSET.checkIntInPut("^[0-9]{10}$");
        System.out.println("------------------------------ \nEmployee { CCCD: " + cccd + ", Name: " + name + ", Age: " + age + ", Skill: " + phoneNumber + " }");
        System.out.print("Are you sure ?\n" + "1. YES\n" + "2. NO\n");
        int chooseYNAdd = CheckSET.checkChoose(2);
        if (chooseYNAdd == 1){
//            ReadAndWriteSET.write(new CustomerSET(cccd,name,age,phoneNumber));
//            listemployeeSET.add(new EmployeeSET(cccd,name,age,skill));
        }
    }
    private static void editCustomer(){

    }
}
