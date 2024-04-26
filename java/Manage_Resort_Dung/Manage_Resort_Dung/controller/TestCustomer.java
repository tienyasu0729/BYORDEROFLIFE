package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.entity.Customer;
import model.entity.CustomerType;
import model.service.CustomerService;

public class TestCustomer {
    static CustomerService customerService=new CustomerService();
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
       while (true) {
        System.out.println("1.add");
        System.out.println("2.display");
        System.out.println("3.edit");
        System.out.println("4.delete");
        System.out.println("0.exit");
        int key=Integer.parseInt(sc.nextLine());
        switch (key) {
            case 0:System.exit(0);
            case 1:add();
                   break;
            case 2:display();
                   break;
            default:
                break;
        }
       } 
    }
    private static void display() throws Exception{
        ArrayList<Customer> customers=customerService.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }
    private static void add() throws Exception {
        System.out.println("id");
        int id=Integer.parseInt(sc.nextLine());
        System.out.println("name");
        String customerName=sc.nextLine();
        System.out.println("birthday");
        String birthday=sc.nextLine();
        System.out.println("gender");
        String gender=sc.nextLine();
        System.out.println("identify");
        String idCard=sc.nextLine();
        System.out.println("phone number");
        String phoneNumber=sc.nextLine();
        System.out.println("customer type 1.vip | 2.normal ");
        int customerTypeId=Integer.parseInt(sc.nextLine());
        CustomerType customerType=customerService.getCustomerTypeById(customerTypeId);
        System.out.println("address");
        String address=sc.nextLine();
        Customer customer=new Customer(id, customerName, birthday, gender, idCard, phoneNumber, customerType, address);
        customerService.addCustomer(customer);
    }
}
