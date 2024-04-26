package test;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        String prin = "";
        do {
            System.out.print("Mời nhập số nguyên không âm dưới 1000 : ");
            number = Integer.parseInt(sc.next());
        } while (number >= 1000 || number < 0);
        if (number <= 10) {
            prin = read(number);
            System.out.println("Đọc số cần test.in ra màn hình là : " + prin);
        } else if (number % 10 == 0 && number < 100) {
            int ahi = number / 10;
            prin = read(ahi) + " mươi";
            System.out.println("Đọc số cần test.in ra màn hình là : " + prin);
        } else if (number % 100 == 0 && number >= 100) {
            int ahihi = number / 100;
            prin = read(ahihi) + " trăm";
            System.out.println("Đọc số cần test.in ra màn hình là : " + prin);
        } else if (number < 100) {
            int firstNumber = number / 10;
            int secondNumber = number % 10;
            prin += read(firstNumber) + " mươi " + read(secondNumber);
            System.out.println("Đọc số cần test.in ra màn hình là : " + prin);
        } else {
            int firstNumber = number / 100;
            int secondNumber = (number - (firstNumber * 100)) / 10;
            int thirdNumber = number % 10;
            prin += read(firstNumber) + " trăm " + read(secondNumber) + " mươi " + read(thirdNumber);
            System.out.println("Đọc số cần test.in ra màn hình là : " + prin);
        }
        System.out.print("Số vừa nhập là : " + number);
    }

    private static String read(int number) {
        String print = "";
        switch (number) {
            case 1:
                print += "Một";
                break;
            case 2:
                print += "Hai";
                break;
            case 3:
                print += "Ba";
                break;
            case 4:
                print += "Bốn";
                break;
            case 5:
                print += "Năm";
                break;
            case 6:
                print += "Sáu";
                break;
            case 7:
                print += "Bảy";
                break;
            case 8:
                print += "Tám";
                break;
            case 9:
                print += "Chín";
                break;
            case 10:
                print += "Mười";
                break;
            default:
                print += "Không";
        }
        return (print);
    }
}
