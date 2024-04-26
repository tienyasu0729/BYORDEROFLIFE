package final_module_2.util;

import final_module_2.model.People;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class ReadAndWriteHospital {
    public static void writeAll(List<People> peopleList){ // truyền vào 1 cái list để ghi vào file
        try {
            FileWriter fileWriter =new FileWriter("C:\\codegym\\text\\java\\java\\src\\final_module_2\\data\\List");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (People e: peopleList) {
                bufferedWriter.write(e.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
            System.out.println("ádasada");
        }
    }
}
