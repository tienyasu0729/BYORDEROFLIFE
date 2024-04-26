package view;

import model.Vaccine;
import model.VaccineManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VaccineRepository extends Menu<String>{
    private VaccineManager vaccineManager = new VaccineManager();
    static String[] options = new String[]{"1. Display All Vaccine From The File", "2. Add a Vaccine", "3. Delete a Vaccine by code", "4. Sort Vaccine By Name", "5. Save The File", "Exit"};
    public VaccineRepository() throws ParseException, IOException {
        super("----- Vaccine Management System -----", options);
        loadsTheListOfVaccines();
    }
    public void loadsTheListOfVaccines() {
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        String line;
        String[] data;
        try {
            FileReader fileReader = new FileReader("C:\\codegym\\text\\java\\VaccinesManagement\\src\\data\\vaccines_input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                data = line.split(",");
                String name = data[0].trim();
                String code = data[1].trim();
                int quantity = Integer.parseInt(data[2].trim());
                Date expirationDate = dateFormat.parse(data[3].trim());
                Double price = Double.valueOf(data[4].trim());
                Date lastInjectedDate = dateFormat.parse(data[5].trim());
                vaccineManager.addVaccine(new Vaccine(name,code,quantity,expirationDate,price,lastInjectedDate));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    ///hàm in ra danh sách khách hàng
    public void displayVaccineList() {
        System.out.println("- List Vaccine");
        System.out.println("-------------------------");
        vaccineManager.printVaccineList();
        System.out.println("-------------------------");
    }

    public Vaccine addVaccine(ArrayList<Vaccine> vaccineList) {
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        System.out.print("- Enter Code Vaccine: ");
        String vaccineCode = scanner.nextLine();
        /////check id tồn tại hay chưa
        while (isCodeExist(vaccineCode, vaccineList)) {
            System.out.print("- Code already exist, please re-enter code: ");
            vaccineCode = scanner.nextLine();
        }
        System.out.print("_ Enter Name Vaccine: ");
        String name = scanner.nextLine();
        System.out.print("- Enter quantity Vaccine: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("-Enter expirationDate Vaccine (dd/MM/yyyy): ");
        Date expirationDate = null;
        try {
            expirationDate = dateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.print("- Enter price Vaccine: ");
        Double price = Double.valueOf(scanner.nextLine());
        System.out.print("-Enter lastInjectedDate Vaccine (dd/MM/yyyy): ");
        Date lastInjectedDate = null;
        try {
            lastInjectedDate = dateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return new Vaccine(name, vaccineCode,quantity,expirationDate, price,lastInjectedDate);
    }
    public boolean isCodeExist(String code, ArrayList<Vaccine> vaccineArrayList) {
        for (Vaccine vaccine : vaccineArrayList) {
            if (vaccine.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void execute(int choice) {
        Scanner sc = new Scanner(System.in);
        switch (choice) {
            case 1:
                displayVaccineList();
                break;
            case 2:
                searchByName(sc);
                break;
            case 3:
                Vaccine vaccine = addVaccine(new ArrayList<>(vaccineManager.getVaccines()));
                vaccineManager.addVaccine(vaccine);
                System.out.println("- Add successful.");
                break;
            case 4:
//                sortByName();
                break;
            case 5:
//                writeCustomerDataToFile();
                break;
            case 6:
                System.out.println("Đã thoát chương trình.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại, chỉ nhập từ 1 -> 7");
        }

    }

    private void sortByName() {

    }

    private void searchByName(Scanner sc) {
        System.out.println("-Enter Name Vaccine To Find");
        String name = sc.nextLine();
        List<Vaccine> searchResult = vaccineManager.searchCondition((Vaccine t) -> t.getName().contains(name));
        printSearchResults(searchResult);
    }
    private void printSearchResults(List<Vaccine> searchResult) {
        if (!searchResult.isEmpty()) {
            for (Vaccine cus : searchResult) {
                System.out.println(cus.toString());
            }
        } else {
            System.out.println("- Can not find anything");
        }
    }

}
