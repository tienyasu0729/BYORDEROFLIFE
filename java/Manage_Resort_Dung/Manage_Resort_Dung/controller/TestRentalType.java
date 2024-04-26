package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.entity.RentalType;
import model.service.RentalTypeService;

public class TestRentalType {
    static RentalTypeService rentalTypeService=new RentalTypeService();
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        while(true){
            System.out.println("1.add | 2.display");
            int key=Integer.parseInt(sc.nextLine());
            switch (key) {
                case 0: System.exit(0);
                case 1: add();
                        break;
                case 2: display();
                        break;
                default:
                        break;
            }
        }
    }
    private static void display() throws Exception {
        ArrayList<RentalType> rentalTypes=rentalTypeService.getAllRentalTypes();
        for (RentalType rentalType : rentalTypes) {
            System.out.println(rentalType.toString());
        }
    }
    private static void add() {
    }
}
