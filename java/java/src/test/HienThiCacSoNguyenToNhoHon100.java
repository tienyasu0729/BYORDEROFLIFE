package test;

import java.util.Scanner;

public class HienThiCacSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhập vào đây giá trị mà bạn muốn test.in ra số nguyên tố nhỏ hơn : ");
        int smallthan = Integer.parseInt(nhap.nextLine());
        for (int i = 2; i < smallthan; i++) {
            if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0|| i == 2 || i == 3 || i == 5 || i == 7) {
                System.out.print(i + " ");
            }
        }
    }
}
