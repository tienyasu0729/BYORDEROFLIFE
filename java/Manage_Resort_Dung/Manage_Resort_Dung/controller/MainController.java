package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.entity.AccompaniedService;
import model.entity.Booking;
import model.entity.Customer;
import model.entity.CustomerType;
import model.entity.Employee;
import model.entity.House;
import model.entity.RentalType;
import model.entity.Room;
import model.entity.Villa;
import model.service.AccompaniedServiceService;
import model.service.BookingService;
import model.service.CustomerService;
import model.service.EmployeeService;
import model.service.RentalTypeService;
import model.service.ServiceService;
import validate.Validate;

public class MainController {
    static Scanner sc=new Scanner(System.in);
    static CustomerService customerService=new CustomerService();
    static EmployeeService employeeService=new EmployeeService();
    static RentalTypeService rentalTypeService=new RentalTypeService();
    static AccompaniedServiceService accompaniedServiceService=new AccompaniedServiceService();
    static ServiceService serviceService=new ServiceService();
    static BookingService bookingService=new BookingService();
    public static void main(String[] args)throws Exception {
        while (true) {
            displayMainMenu();
            int key= Integer.parseInt(Validate.checkIntInPut("^[1-7]$","- Enter your choice: ","- Enter only numbers from 1 to 7, please re-enter: "));
            switch (key) {
                case 1: addNewService();
                        break;
                case 2: showService();
                        break;
                case 3: addNewCustomer();
                        break;
                case 4: showInforOfCustomer();
                        break;
                case 5: addNewBooking();
                        break;
                case 6: showInforOfEmployee();
                        break;
                case 7: System.exit(0);
            }
        }
    
    }

    private static void addNewBooking()throws Exception {
        ArrayList<Customer> customers=customerService.getAllCustomers();
        System.out.println("Choose customer to book");
        int n=1;
        for (Customer customer : customers) {
            System.out.println(n+". ( "+customer.toString()+" )");
            n++;
        }
        int choice=Integer.parseInt(sc.nextLine());
        Customer customer=customerService.getCustomerById(choice);
        System.out.println("1. Booking Villa\n"+
                           "2. Booking House\n"+
                           "3. Booking Room");
        int key=Integer.parseInt(sc.nextLine());
        switch (key) {
            case 1: showVillas();
                    System.out.println("choose 1 villa");
                    String choice2=sc.nextLine();
                    String service=serviceService.getVillaById(choice2).showInfor();
                    Booking booking=new Booking(customer, service);
                    bookingService.addBooking(booking);
                    break;
            case 2: showHouses();
                    System.out.println("choose 1 house");;
                    int choice3=Integer.parseInt(sc.nextLine());
                    String service2=serviceService.getHouseById(choice3).showInfor();
                    Booking booking2=new Booking(customer, service2);
                    bookingService.addBooking(booking2);
                    break;
            case 3: showRooms();
                    System.out.println("choose 1 room");
                    int choice4=Integer.parseInt(sc.nextLine());
                    String service3=serviceService.getRoomById(choice4).showInfor();
                    Booking booking3=new Booking(customer, service3);
                    bookingService.addBooking(booking3);
                    break;
            default:
                break;
        }
    }

    private static void showVillas()throws Exception{
        ArrayList<Villa> villas=serviceService.getAllVillas();
            for (Villa villa : villas) {
                System.out.println(villa.showInfor());
            }
    }

    private static void showHouses()throws Exception{
        ArrayList<House> houses=serviceService.getAllHouses();
        for (House house : houses) {
            System.out.println(house.showInfor());
        }
    }

    private static void showRooms()throws Exception{
        ArrayList<Room> rooms=serviceService.getAllRoom();
        for (Room room : rooms) {
            System.out.println(room.showInfor());
        }
    }

    private static void showService() throws Exception {
        System.out.println("1. Show all Villa\n"+
                           "2. Show all House\n"+
                           "3. Show all Room\n"+
                           "4. Back to menu\n"+
                           "5. Exit");
            int key=Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1: showVillas();
                        break;
                case 2: showHouses();
                        break;
                case 3: showRooms();
                        break;
                case 4: break;
                case 5: System.exit(0);
                default:
                    break;
            }
    }

    private static void showInforOfEmployee() throws Exception {
        ArrayList<Employee> employees=employeeService.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    private static void showInforOfCustomer() throws Exception {
        ArrayList<Customer> customers=customerService.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    private static void addNewCustomer()throws Exception {
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

    public static void displayMainMenu(){
        System.out.println("--------------- MAIN MENU ---------------\n" +
                            "1. Add New Services\n"+
                            "2. Show Services\n"+
                            "3. Add New Customer\n"+
                            "4. Show Information of Customer\n"+
                            "5. Add New Booking\n"+
                            "6. Show Information of Employee\n"+
                            "7. Exit");
    }

    public static void addNewService()throws Exception{
        boolean exit = false;
        while (!exit) {
            System.out.println("--------------- ADD NEW SERVICE ---------------\n" +
                                "1. Add New Villa\n" +
                                "2. Add New House\n" +
                                "3. Add New Room\n" +
                                "4. Back to main menu\n" +
                                "5. Exit");
            int key = Integer.parseInt(Validate.checkIntInPut("^[1-5]$", "- Enter your choice: ", "- Enter only numbers from 1 to 5, please re-enter: "));
            switch (key) {
                case 1:
                    addVilla();
                    break;
                case 2:
                    addHouse();
                    break;
                case 3:
                    addRoom();
                    break;
                case 4:
                    exit = true; // Đặt exit = true để thoát khỏi vòng lặp
                    break;
                case 5:
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    private static void addRoom()throws Exception {
        System.out.println("name");
        String serviceName=sc.nextLine();
        System.out.println("usable area");
        String usableArea=sc.nextLine();
        System.out.println("double expense");
        double expense=Double.parseDouble(sc.nextLine());
        System.out.println("int max number of people");
        int maxNumOfPeople=Integer.parseInt(sc.nextLine());
        ArrayList<RentalType> rentalTypes=rentalTypeService.getAllRentalTypes();
        System.out.println("rental type");
        for (RentalType rentalType : rentalTypes) {
            System.out.println(rentalType.toString());
        }
        int rentalTypeId=Integer.parseInt(sc.nextLine());
        RentalType rentalType=rentalTypeService.getRentalTypeById(rentalTypeId);
        System.out.println("int room id");
        int roomId=Integer.parseInt(sc.nextLine());
        System.out.println("bonus service");
        String bonusService=sc.nextLine();
        ArrayList<AccompaniedService> accompaniedServices=accompaniedServiceService.getAllAccompaniedServices();
        System.out.println("accompanied service");
        for (AccompaniedService accompaniedService : accompaniedServices) {
            System.out.println(accompaniedService.toString());
        }
        int accompaniedServiceId=Integer.parseInt(sc.nextLine());
        AccompaniedService accompaniedService=accompaniedServiceService.getAccompaniedServiceById(accompaniedServiceId);
        Room room=new Room(serviceName, usableArea, expense, maxNumOfPeople, rentalType, roomId, bonusService, accompaniedService);
        serviceService.addRoom(room);
    }

    private static void addHouse()throws Exception {
        System.out.println("name");
        String serviceName=sc.nextLine();
        System.out.println("usable area");
        String usableArea=sc.nextLine();
        System.out.println("double expense");
        double expense=Double.parseDouble(sc.nextLine());
        System.out.println("int max number of people");
        int maxNumOfPeople=Integer.parseInt(sc.nextLine());
        ArrayList<RentalType> rentalTypes=rentalTypeService.getAllRentalTypes();
        System.out.println("rental type");
        for (RentalType rentalType : rentalTypes) {
            System.out.println(rentalType.toString());
        }
        int rentalTypeId=Integer.parseInt(sc.nextLine());
        RentalType rentalType=rentalTypeService.getRentalTypeById(rentalTypeId);
        System.out.println("int house id");
        int houseId=Integer.parseInt(sc.nextLine());
        System.out.println("String roomStandard");
        String roomStandard=sc.nextLine();
        System.out.println("other advantage");
        String otherAdvantage=sc.nextLine();
        System.out.println("int number of floors");
        int numberOfFloors=Integer.parseInt(sc.nextLine());
        ArrayList<AccompaniedService> accompaniedServices=accompaniedServiceService.getAllAccompaniedServices();
        System.out.println("accompanied service");
        for (AccompaniedService accompaniedService : accompaniedServices) {
            System.out.println(accompaniedService.toString());
        }
        int accompaniedServiceId=Integer.parseInt(sc.nextLine());
        AccompaniedService accompaniedService=accompaniedServiceService.getAccompaniedServiceById(accompaniedServiceId);
        House house=new House(serviceName, usableArea, expense, maxNumOfPeople, rentalType, houseId, roomStandard, otherAdvantage, numberOfFloors, accompaniedService);
        serviceService.addHouse(house);
    }

    private static void addVilla()throws Exception {
        String serviceName= Validate.checkIntInPut("^[a-zA-Z]+$","- Enter villa name: ","- Please do not include numbers, please re-enter: ");
        String usableArea= Validate.checkIntInPut(".*","- Enter usable Area: ","- Please do not include numbers, please re-enter: ");
        double expense=Double.parseDouble(Validate.checkIntInPut("^[-+]?\\d*\\.?\\d+$","- Enter double expense: ","- Please do not enter characters, please re-enter: "));
        int maxNumOfPeople=Integer.parseInt(Validate.checkIntInPut("^\\d+$","- Enter max number of people: ","- Enter numbers only, please re-enter: "));
        ArrayList<RentalType> rentalTypes=rentalTypeService.getAllRentalTypes();
        System.out.println("rental type");
        for (RentalType rentalType : rentalTypes) {
            System.out.println(rentalType.toString());
        }
        int rentalTypeId=Integer.parseInt(sc.nextLine());
        RentalType rentalType=rentalTypeService.getRentalTypeById(rentalTypeId);
        System.out.println("String villa id");
        String villaId=sc.nextLine();
        System.out.println("String roomStandard");
        String roomStandard=sc.nextLine();
        System.out.println("other advantage");
        String otherAdvantage=sc.nextLine();
        System.out.println("double poolArea");
        double poolArea=Double.parseDouble(sc.nextLine());
        System.out.println("int number of floors");
        int numberOfFloors=Integer.parseInt(sc.nextLine());
        ArrayList<AccompaniedService> accompaniedServices=accompaniedServiceService.getAllAccompaniedServices();
        System.out.println("accompanied service");
        for (AccompaniedService accompaniedService : accompaniedServices) {
            System.out.println(accompaniedService.toString());
        }
        int accompaniedServiceId=Integer.parseInt(sc.nextLine());
        AccompaniedService accompaniedService=accompaniedServiceService.getAccompaniedServiceById(accompaniedServiceId);
        Villa villa=new Villa(serviceName, usableArea, expense, maxNumOfPeople, rentalType, villaId, roomStandard, otherAdvantage, poolArea, numberOfFloors, accompaniedService);
        serviceService.addVilla(villa);
    }
}
