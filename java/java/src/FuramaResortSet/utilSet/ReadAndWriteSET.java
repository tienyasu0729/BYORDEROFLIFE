package FuramaResortSet.utilSet;

import FuramaResortSet.ModelSet.CustomerSET;
import FuramaResortSet.ModelSet.EmployeeSET;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Set;
import java.util.TreeSet;

public class ReadAndWriteSET {

    public static void writeAllEmployee(Set<EmployeeSET> employeeList){ // truyền vào 1 cái list để ghi vào file
        try {
            FileWriter fileWriter =new FileWriter("src/FuramaResortSet/DataSet/EmployeeSet");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (EmployeeSET e: employeeList) {
                bufferedWriter.write(e.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
            System.out.println("Error, can not find file");
        }
    }
    public static void writeAllCustomer(Set<CustomerSET> customerList){ // truyền vào 1 cái list để ghi vào file
        try {
            FileWriter fileWriter =new FileWriter("src/FuramaResortSet/DataSet/CustomerSet");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (CustomerSET e: customerList) {
                bufferedWriter.write(e.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
            System.out.println("Error, can not find file");
        }
    }

    public static void writeEmployee(EmployeeSET employee){ // ghi 1 dòng
        try {
            FileWriter fileWriter =new FileWriter("src/FuramaResortSet/DataSet/EmployeeSet", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.valueOf(employee));
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
            System.out.println("Error, can not find file");
        }
    }
    public static void writeCustomer(CustomerSET customer){ // ghi 1 dòng
        try {
            FileWriter fileWriter =new FileWriter("src/FuramaResortSet/DataSet/CustomerSet", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.valueOf(customer));
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
            System.out.println("Error, can not find file");
        }
    }
//    public static void writeFind(String find){
//        try {
//            FileWriter fileWriter =new FileWriter("src/FuramaResortSet/DataSet/EmployeeSet", true);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//
//            bufferedWriter.close();
//            fileWriter.close();
//        }catch (Exception e){
//            System.out.println("Error, can not find file");
//        }
//    }

    public static Set<EmployeeSET> ReadAll(){ // chuyển đổi tất cả dữ liệu trong file rồi chuyển đổi thành 1 đối tượng và bỏ vào list rồi trả về
        Set<EmployeeSET> list = new TreeSet<>();
        String [] nn;
        String line = null;
        try{
            FileReader fileReader = new FileReader("src/FuramaResortSet/DataSet/EmployeeSet");
            BufferedReader bufferedReader =new BufferedReader(fileReader);
            do {
                line = bufferedReader.readLine();
                if (line != null){
                    nn = line.split(",");
                    list.add(new EmployeeSET(nn[0],nn[1],Integer.parseInt(nn[2]),nn[3]));
                }
            }while (line != null);
            bufferedReader.close();
            fileReader.close();
        }catch (Exception e){

        }
        return list;
    }
    public static Set<CustomerSET> ReadCustomerAll(){ // chuyển đổi tất cả dữ liệu trong file rồi chuyển đổi thành 1 đối tượng và bỏ vào list rồi trả về
        Set<CustomerSET> list = new TreeSet<>();
        String [] nn;
        String line = null;
        try{
            FileReader fileReader = new FileReader("src/FuramaResortSet/DataSet/CustomerSet");
            BufferedReader bufferedReader =new BufferedReader(fileReader);
            do {
                line = bufferedReader.readLine();
                if (line != null){
                    nn = line.split(",");
                    list.add(new CustomerSET(nn[0],nn[1],Integer.parseInt(nn[2]),nn[3]));
                }
            }while (line != null);
            bufferedReader.close();
            fileReader.close();
        }catch (Exception e){

        }
        return list;
    }

    public static String Read(String pathFile){ // đọc dòng đầu tiên trong file
        String line = null;
        try{
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader =new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            bufferedReader.close();
            fileReader.close();
        }catch (Exception e){

        }
        return line;
    }
}
