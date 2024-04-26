package lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test3D {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person(1,"SE17d10",true));
        personArrayList.add(new Person(2,"SE17d10",false));

        // nhập thêm 2 phần tử
        for (int i = 0; i < 2; i++) {
            personArrayList.add(writeInformation(i));
        }

        // sắp xếp rồi in ra
        personArrayList = sapxep(personArrayList);
        System.out.println("--------------------------");
        for (int i = 0; i < personArrayList.size(); i++) {
            System.out.println(personArrayList.get(i));
        }

        // tìm kiếm
        search(personArrayList);
    }
    private static ArrayList<Person> sapxep(ArrayList<Person> personArrayList){
        System.out.println("------------------------");
        Person sp = new Person();
        for (int i = 0; i < personArrayList.size(); i++) {
            for (int j = i+1; j < personArrayList.size(); j++) {
                if (personArrayList.get(i).getName().compareTo(personArrayList.get(j).getName()) < 0){
                    sp = personArrayList.get(j);
                    personArrayList.set(j, personArrayList.get(i));
                    personArrayList.set(i,sp);
                }
            }

        }
        return personArrayList;
    }
    private static void search(List<Person> personArrayList){
        System.out.println("------------------------");
        System.out.print("- Nhập tên muốn tìm: ");
        String find = scanner.nextLine();
        for (int i = 0; i < personArrayList.size(); i++) {
            if (personArrayList.get(i).getName().equals(find)){
                System.out.println(personArrayList.get(i));
            }
        }
    }

    private static Person writeInformation(int i){
        System.out.println("----------------------------");
            System.out.print("- mời bạn nhập id cho người dùng thứ " + (i + 1) + " : ");
            int id = checkId(scanner.nextLine());
            System.out.print("- Nhập tên cho người thứ " + (i + 1) + " : ");
            String name = scanner.nextLine();
            System.out.print("- Nhập giới tính cho người dùng: " + (i + 1) + " : ");
            Boolean gender = checkGender();
            return new Person(id,name,gender);
    }

    private static int checkId(String idToCheck){
        int id = 0;
        Boolean check = false;
        do {
            try {
                id = Integer.parseInt(idToCheck);
                check = false;
            }catch (Exception e){
                System.out.print("- Chỉ nhập số tối đa 10 chữ số, xin mời nhập lại: ");
                check = true;
            }
        }while (check);
        return id;
    }

    private static Boolean checkGender(){
        Boolean gender;
        do {
                String input = scanner.nextLine().toLowerCase();
                if (input.matches("^(true|false)$")) {
                    gender = Boolean.parseBoolean(input);
                    break;
                } else {
                    System.out.print("- Chỉ nhập true hoặc false: ");
                }
        } while (true);
        return gender;
    }
}
