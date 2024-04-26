package lab3;

import lab3.Person;

import java.util.Scanner;

public class test3b {

    public static void main(String[] args) {
    Person p=new Person();
    p=scanInfo();
    printInfo(p);
    
    
}
    public static Person scanInfo() {
            Scanner input = new Scanner(System.in);
            System.out.print ("Enter ID: ");
            int id = input.nextInt();
            input.nextLine();
            System.out.print ("Enter Name:"); 
            String name = input.nextLine();
            System.out.print ("Enter Gender(true/false): ");
             boolean gender= input.nextBoolean();
            return new Person(id, name, gender);
    }
    public static void printInfo(Person person) {
        
        System.out.println ("---------------------------------------------");
        System.out.println("| ID | Name | Male |");
        System.out.printf("|%d |%s | %b |\n", person.getId(), person.getName(), person.getGender());
    } 
}