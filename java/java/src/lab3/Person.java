package lab3;

import java.util.Scanner;


public class Person {
    int id;
    String name;
    boolean gender;

    public Person() {
    }

    public Person(int id, String name, boolean gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void scanInfo() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter ID: ");
        this.id = input.nextInt();
        System.out.println("Enter Name: ");
        input.nextLine();
        this.name = input.nextLine();
        System.out.print("Enter Gender: ");
        this.gender = input.nextBoolean();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}