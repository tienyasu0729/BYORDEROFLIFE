package lab3;

import java.util.Scanner;

public class test3c {

    public static void main(String[] args) {
//        Person p=new Person();
//        
//        p.scanInfo();
//        p.printInfo();
        Person p1 = new Person(1001, "Trần Long", true);
        Person p2 = new Person(1002, "Nguyễn Tiến", true);

        Person[] perArr = new Person[4];
        perArr[0] = p1;
        perArr[1] = p2;
        Scanner sc = new Scanner(System.in);
        for (int i = 2; i < 4; i++) {
            System.out.println("Enter information for Person " + (i+1) + ":");
             System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Is male (true/false): ");
            boolean isMale = sc.nextBoolean();
            perArr[i] = new Person(id, name, isMale);
            }
            for (int i = 0; i < 4; i++) {
//            perArr[i].printInfo();
                }
            }
    }