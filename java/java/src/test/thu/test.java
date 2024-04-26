package test.thu;

import java.util.Scanner;

public class test {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        while (true){
//            System.out.print("Nhập : ");
//            String nn = scanner.next();
//        }

//        int x = 1;
//        while (true){
//            System.out.println(x);
//            x++;
//            if (x == 50){
//                break;
//            }
//        }

//        String nn = "123456789ggg";
//        System.out.println(nn.length());

//        int nn = 123123123;
//        String mm = String.valueOf(nn);
//        System.out.println(mm);

//        String nn = "1231231223423434234234242323423423423423";
//        int x = 2;
//        System.out.println(nn.length() > x);

//        String nn = "ab3d";
//        char [] checkForLettersInput = nn.toCharArray();
//        System.out.println(checkForLettersInput[2] + 2);
//        for (int i = 0; i < nn.length(); i++) {
//            System.out.println(Character.isLetter(checkForLettersInput[i]));  // Character.isLetter() : kiểm tra bên trong ngoặc có phải một kí tự không
//        }

        // ví dụ về regex

//        String regexClass ="^[AC]\\d{4}[IG]\\d$";
//        String className1 = "C0uuu";
//        String className2 = "C0922G1";
//        //cách sử dụng regex
//        //cách1
//        System.out.println(className1.matches(regexClass));
//        System.out.println(className2.matches(regexClass));
//        // cách 2
//        Pattern pattern = Pattern.compile(regexClass);
//        System.out.println(pattern.matcher(className2));
//        // cách 3
//        Pattern pattern1= Pattern.compile(regexClass);
//        Matcher matcher = pattern.matcher(className1);
//        System.out.println(matcher.matches());
//        String str ="hello                 world      việtnam      ";
//        String[] arr = str.split("\\s+");
//        System.out.println("số lượng tử trong chuỗi "+ arr.length);

//        String nn =  "123";
//        char[] mm = nn.toCharArray();
//        System.out.println(Character.getNumericValue(mm[0]) > 2); // Character.getNumericValue(mm[0]) : chuyển đổi kí tự thành số nguyên interger, nếu không chuyển sẽ chuyển thành số địa chỉ ô nhớ


        // test thuwr TreeSet

//        TreeSet<Human> test = new TreeSet<>();
////        ArrayList<Human> testArrayList = new ArrayList<>();
//
//
//        test.add(new Human("123123123123","tien1", 87));
//        test.add(new Human("189789789789","tien2", 23));
//        test.add(new Human("167567567567","tien3", 31));
//        test.add(new Human("145345345345","tien4", 14));
//
//        read();

//        System.out.println(test);
//        System.out.println("-------------------------------");

//        TreeSet<Human> test2 = new TreeSet<>();
//        test2.add(new Human("823123123123","tien5", 87));
//        test2.add(new Human("889789789789","tien6", 23));
//        test2.add(new Human("867567567567","tien7", 31));
//        test2.add(new Human("845345345345","tien8", 14));
//        System.out.println(test2);
//        System.out.println("-------------------------------");


//        for (Human e: test) {
//            System.out.println(e);
//        }
//        testArrayList.addAll(test2);
//        for (int i = 0; i < testArrayList.size(); i++) {
//            System.out.println(testArrayList.get(i));
//        }
//        System.out.println("-------------------------------");
//        testArrayList.addAll(test);
//        testArrayList.addAll(test);
//        testArrayList.addAll(test);
//        testArrayList.addAll(test);
//        for (int i = 0; i < testArrayList.size(); i++) {
//            System.out.println(testArrayList.get(i));
//        }
//        write(test);

//        for (int i = 0; i < test.size(); i++) {
//            System.out.println(test.clone());
//        }


        // test thử cộng string
//        String a = "hello";
//        String b = "world";
//        System.out.println(a + b);



        // test thử cộng string có tạo nên regex kh

//        String regex = "^[0-9]{6}$";
//        String a = "^[0-9]";
//        String b = "{6}$";
//        String c = a + b;
//        String aa = "312123";
//        System.out.println(aa.matches(c));
//        int id = 1234543;
//        String ff = String.valueOf(id);
//        System.out.println(ff);
    }

//    private static void write(int i){
//        try {
//            FileWriter fileWriter = new FileWriter("D:\\codegym\\text\\java\\java\\src\\test\\thu\\data");
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
////            bufferedWriter.write();
//            bufferedWriter.close();
//            fileWriter.close();
//        }catch (Exception e){
//            System.out.println("sssss");
//        }
//    }
//    private static void read(){
//        try{
//            FileReader fileReader = new FileReader("D:\\codegym\\text\\java\\java\\src\\test\\thu\\data");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            String [] stringArray;
//            line = bufferedReader.readLine();
//            stringArray = line.split(",");
//            for (int i = 0; i < stringArray.length; i++) {
//                System.out.println(stringArray[i]);
//            }
//        }catch (Exception e){
//            System.out.println("Error");
//        }
//    }
}
