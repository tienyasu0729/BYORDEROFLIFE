package test_retake_module_2.util;

import test_retake_module_2.model.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class ReadAndWrite {
    public static void writeAll(List<Student> studentList){ // truyền vào 1 cái list để ghi vào file
        try {
            FileWriter fileWriter =new FileWriter("C:\\codegym\\text\\java\\java\\src\\test_retake_module_2\\data\\Student");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student e: studentList) {
                bufferedWriter.write(e.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
        }
    }
    public static List<Student> ReadAll(){ // chuyển đổi tất cả dữ liệu trong file rồi chuyển đổi thành 1 đối tượng và bỏ vào list rồi trả về
        List<Student> list = new ArrayList<>();
        String [] nn;
        String line = null;
        try{
            FileReader fileReader = new FileReader("C:\\codegym\\text\\java\\java\\src\\test_retake_module_2\\data\\Student");
            BufferedReader bufferedReader =new BufferedReader(fileReader);
            do {
                line = bufferedReader.readLine();
                if (line != null){
                    nn = line.split(",");
                    list.add(new Student(Integer.parseInt(nn[0]),nn[1],nn[2],nn[3],nn[4],Integer.parseInt(nn[5])));
                }
            }while (line != null);
            bufferedReader.close();
            fileReader.close();
        }catch (Exception e){
        }
        return list;
    }
}
