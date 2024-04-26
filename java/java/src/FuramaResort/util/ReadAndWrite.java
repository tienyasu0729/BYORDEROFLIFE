package FuramaResort.util;

import FuramaResort.Model.Employee;

import java.io.*;
import java.util.List;

public class ReadAndWrite {
    public static void write(String pathFile, boolean append, List<Employee> employeeList){
        try {
            FileWriter fileWriter =new FileWriter(pathFile, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee e: employeeList) {
                bufferedWriter.write(e.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
            System.out.println("Error, can not find file");
        }
    }
    public static void Read(String pathFile){
        try{
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader =new BufferedReader(fileReader);

            bufferedReader.close();
            fileReader.close();
        }catch (Exception e){

        }
    }
}
