package FuramaResortSet.viewSet;

import FuramaResort.util.Check;
import FuramaResortSet.serviceSet.EmployeeServiceSET;
import FuramaResortSet.utilSet.CheckSET;

import java.util.Scanner;

public class MainMenuSET {
    static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        while (true) {
            System.out.println("---------- MENU ---------- \n1.EmployeeSet Management \n2.Customer Management \n3.Facility Management \n4.Booking Management \n5.Promotion Management \n6.Exit");
            int chooseInMainMenu = 0;
            chooseInMainMenu = CheckSET.checkChoose(6);
            switch (chooseInMainMenu) {
                case 1:
                    EmployeeServiceSET.mainEmployee();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
