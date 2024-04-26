package CCCD.service;

import CCCD.model.CCCD;
import CCCD.util.CheckCCCD;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CCCDService {
    private static Scanner scanner = new Scanner(System.in);
    private static Set<CCCD> cccdList = new TreeSet<>();

    public static void displayCCCD(){

    }
    public static void addCCCD(){
        System.out.print("Nhập CCCD cầm: ");
        String cccd = CheckCCCD.checkRegex("^[0-9]{12}$","Nhập sai CCCD rồi, xin mời nhập lại: ");
        System.out.print("Nhập tên của khách cầm: ");
        String name = CheckCCCD.checkRegex("^[\\p{L}\\s]+$","Nhập tên lỗi rồi, xin mời nhập lại: ");
        System.out.print("Nhập số tiền cầm: ");
        int price = CheckCCCD.checkPrice();


    }
    public static void deleteCCCD(){

    }
    public static void editCCCD(){

    }
    public static void findCCCD(){

    }
}
