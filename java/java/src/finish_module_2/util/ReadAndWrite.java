package finish_module_2.util;

import finish_module_2.model.DanhBa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class ReadAndWrite {
    public static void writeDanhBa(DanhBa danhBa){ // ghi 1 dòng
        try {
            FileWriter fileWriter =new FileWriter("C:\\codegym\\text\\java\\java\\src\\finish_module_2\\data\\DanhBa", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.valueOf(danhBa));
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
            System.out.println("Error, can not find file");
        }
    }
    public static void writeAllDanhBa(List<DanhBa> danhBaList){ // truyền vào 1 cái list để ghi vào file
        try {
            FileWriter fileWriter =new FileWriter("C:\\codegym\\text\\java\\java\\src\\finish_module_2\\data\\DanhBa");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (DanhBa e: danhBaList) {
                bufferedWriter.write(e.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
            System.out.println("Error, can not find file");
        }
    }
    public static void Read(){ // đọc dòng đầu tiên trong file
        String line = null;
        try{
            FileReader fileReader = new FileReader("C:\\codegym\\text\\java\\java\\src\\finish_module_2\\data\\DanhBa");
            BufferedReader bufferedReader =new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            if (line != null){
                do {
                    System.out.println(line);
                    line = bufferedReader.readLine();
                }while (line != null);
            }

            bufferedReader.close();
            fileReader.close();
        }catch (Exception e){

        }}
}
