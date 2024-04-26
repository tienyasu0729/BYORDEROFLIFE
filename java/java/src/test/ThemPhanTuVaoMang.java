package test;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập phần tử muốn thêm vào mảng : ");
        int x = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập vị trí phần tử muốn thêm vào mảng : ");
        int index = Integer.parseInt(scanner.nextLine());
        int [] arr1 = new int[10];
        int [] arr2 = new int[arr1.length + 1];
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i;
        }
        if (index >= arr1.length || index <= 1) {
            System.out.print("Vị trí vượt khỏi mảng");
        }else {
            for (int i = 0; i < arr2.length; i++) {
                if (i == index) {
                    arr2[index] = x;
                }else {
                    arr2[i] = arr1[count];
                    count++;
                }

            }
        }
        System.out.print(Arrays.toString(arr2));



    }
}
