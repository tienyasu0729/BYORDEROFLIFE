package IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class textIO {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
//        while (true){
            try {
                FileWriter fileWriter = new FileWriter("D:\\codegym\\text\\java\\java\\src\\IO\\data");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                String ss = scanner.nextLine();
                bufferedWriter.write(ss);

                bufferedWriter.close();
                fileWriter.close();

            }catch (Exception e){
                System.out.println("error");
            }
        }

//    }
}
