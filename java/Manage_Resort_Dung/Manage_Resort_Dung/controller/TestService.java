package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.entity.AccompaniedService;
import model.entity.House;
import model.entity.RentalType;
import model.entity.Room;
import model.entity.Villa;
import model.service.AccompaniedServiceService;
import model.service.RentalTypeService;
import model.service.ServiceService;

public class TestService {
    static ServiceService serviceService=new ServiceService();
    static RentalTypeService rentalTypeService=new RentalTypeService();
    static AccompaniedServiceService accompaniedServiceService=new AccompaniedServiceService();
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args)throws Exception {
        while (true) {
            System.out.println("1. Add New Villa\n"+
                               "2. Add New House\n"+
                               "3. Add New Room\n"+
                               "4. Back to menu\n"+
                               "5. Exit");
            int key=Integer.parseInt(sc.nextLine());
            switch (key) {
                case 0: showService();
                        break;
                case 1: addVilla();
                        break;
                case 2: addHouse();
                        break;
                case 3: addRoom();
                        break;
                case 4: continue;
                case 5: System.exit(0);
                default:
                    break;
            }
        }
    }
    private static void showService() throws Exception {
        ArrayList<Villa> villas=serviceService.getAllVillas();
        for (Villa villa : villas) {
            System.out.println(villa.showInfor());
        }
        ArrayList<House> houses=serviceService.getAllHouses();
        for (House house : houses) {
            System.out.println(house.showInfor());
        }
        ArrayList<Room> rooms=serviceService.getAllRoom();
        for (Room room : rooms) {
            System.out.println(room.showInfor());
        }
    }
    private static void addRoom() throws Exception {
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
    private static void addVilla() throws Exception {
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
