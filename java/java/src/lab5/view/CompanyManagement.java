package lab5.view;

import lab5.model.Customer;
import lab5.model.Company;

import java.util.List;
import java.util.Scanner;

public class CompanyManagement {
    private static Company company = new Company();
    private static Scanner scanner = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("----- Company Management Menu -----\n1. Add new customer\n2. Display all customers\n3. Search customer\n4. Sort customer list\n5. Exit");
    }

    public static void addCustomer() {
        int customerID = Integer.parseInt(checkIntInPut("^-?\\d+$", "-Enter customer ID: ", "-Id contains only numbers, please re-enter: "));
        String name = checkIntInPut("^[a-zA-Z\\s]+$", "-Enter customer name: ", "-Name does not contain numbers or special characters, please re-enter: ");
        String phone = checkIntInPut("^\\d{10}$", "-Enter customer phone: ","-Phone number consists of only numbers and 10 digits, please re-enter: ");
        company.addCustomer(new Customer(customerID, name, phone));
        System.out.println("Customer added successfully.");
    }

    public static void displayAllCustomers() {
        List<Customer> customerList = company.getCustomerList();
        if (customerList.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("----- All Customers -----");
            for (Customer customer : customerList) {
                System.out.println(customer);
            }
        }
    }

    public static void searchCustomer() {
        String criteria;
        String value;

        System.out.println("----- Customer Search -----\nSearch by:\n1. Customer ID\n2. Name\n3. Phone");
        int choice = Integer.parseInt(checkIntInPut("^-?\\d+$","-Enter your choice: ","-Select contains only numbers, please re-enter: "));

        switch (choice) {
            case 1:
                criteria = "CustomerID";
                value = checkIntInPut("^-?\\d+$", "-Enter customer ID to find: ", "-Id contains only numbers, please re-enter: ");
                break;
            case 2:
                criteria = "Name";
                value = checkIntInPut("^[a-zA-Z\\s]+$", "-Enter customer name to find: ", "-Name does not contain numbers or special characters, please re-enter: ");
                break;
            case 3:
                criteria = "Phone";
                value = checkIntInPut("^\\d{10}$", "-Enter customer phone to find: ","-Phone number consists of only numbers and 10 digits, please re-enter: ");
                break;
            default:
                System.out.println("Invalid choice. Returning to the main menu.");
                return;
        }
        List<Customer> searchResults = company.searchCustomers(criteria, value);
        if (searchResults.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("----- Search Results -----");
            for (Customer customer : searchResults) {
                System.out.println(customer);
            }
        }
    }

    public static void sortCustomerList() {
        company.sortCustomerList();
        System.out.println("Customer list sorted by customerCode in ascending order.");
    }

    public static String checkIntInPut(String regex, String firstEnter, String errorEnter) {
        System.out.print(firstEnter);
        String input = scanner.nextLine();
        while (!input.matches(regex)){
            System.out.print(errorEnter);
            input = scanner.nextLine();
        }
        return input;
    }
}