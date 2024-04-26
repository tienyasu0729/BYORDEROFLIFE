package test;

import java.util.Scanner;

public class ung_dung_doc_so_thanh_chu {
    private static String oneDigit(int num) {
        switch (num) {
            case 1:
                return ("một");
            case 2:
                return ("hai");

            case 3:
                return ("ba");

            case 4:
                return ("bốn");

            case 5:
                return ("năm");

            case 6:
                return ("sáu");

            case 7:
                return ("bảy");

            case 8:
                return ("tám");

            case 9:
                return ("chín");
        }
        return "mười";
    }

//    private static String twoDigit(int num) {
//        String res;
//        int hangChuc = num / 10;
//        int hangDonvi = num % 10;
//        if (hangChuc == 1) {
//            res = "mười " + oneDigit(hangDonvi);
//        } else {
//            res = oneDigit(hangChuc) + " " + oneDigit(hangDonvi);
//        }
//
//        return res.replace("một", "mốt").replace("mười", "mươi");
//    }
//
//    private static String threeDigit(int num) {
//        int hangTram = num / 100;
//        int phanConLai = num - (hangTram * 100);
//
//        return oneDigit(phanConLai) + " trăm " + twoDigit(phanConLai);
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời nhập số: ");
        int num = Integer.parseInt(scanner.nextLine());
        if (num >= 0 && num < 10) {
            System.out.println(oneDigit(num));}
//        } else if (num < 100) {
//            System.out.println(twoDigit(num));
//        } else if (num < 1000) {
//            System.out.println(threeDigit(num));
//        } else {
//            System.out.println("out of order");
//        }
    }
}
