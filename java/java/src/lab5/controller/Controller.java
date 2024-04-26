package lab5.controller;

import lab5.view.CompanyManagement;


public class Controller {
    public static void main(String[] args) {
        while (true) {
            CompanyManagement.printMenu();
            int choice = Integer.parseInt(CompanyManagement.checkIntInPut("^-?\\d+$","-Enter your choice: ","-Select contains only numbers, please re-enter: "));
            switch (choice) {
                case 1:
                    CompanyManagement.addCustomer();
                    break;
                case 2:
                    CompanyManagement.displayAllCustomers();
                    break;
                case 3:
                    CompanyManagement.searchCustomer();
                    break;
                case 4:
                    CompanyManagement.sortCustomerList();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
