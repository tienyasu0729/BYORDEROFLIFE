package test;

import java.util.Arrays;
import java.util.Scanner;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhập vào đây số lượng nguyên tố bạn muốn test.in ra màn hình : ");
        int soluong = Integer.parseInt(nhap.nextLine());
        int soluongmang = 0;
        int [] arr = new int[soluong];
        for (int i = 1; i > 0 ;i++) {
            if (i > 1 && i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0 || i == 2 || i == 3) {
                arr[soluongmang] = i;
                soluongmang++;
            }
            if (soluongmang == soluong) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
