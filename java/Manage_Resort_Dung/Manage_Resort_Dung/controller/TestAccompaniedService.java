package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.entity.AccompaniedService;
import model.service.AccompaniedServiceService;

public class TestAccompaniedService {
    static AccompaniedServiceService accompaniedServiceService= new AccompaniedServiceService();
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("1. add | 2. display");
            int key= Integer.parseInt(sc.nextLine());
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
    private static void display()throws Exception {
        ArrayList<AccompaniedService> accompaniedServices=accompaniedServiceService.getAllAccompaniedServices();
        for (AccompaniedService accompaniedService : accompaniedServices) {
            System.out.println(accompaniedService.toString());
        }
    }
    private static void add() {
        System.out.println(":)");
    }
}
