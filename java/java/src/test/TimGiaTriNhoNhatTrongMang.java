package test;

import java.util.Arrays;
import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhập vào đây số hàng của mảng 2 chiều : ");
        int rows = Integer.parseInt(nhap.nextLine());
        System.out.print("Nhập vào đây số cột của mảng 2 chiều : ");
        int columns = Integer.parseInt(nhap.nextLine());
        int [][] arr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Nhập vào đây phần tử ở hàng  " + (i+1) + " cột " + (j+1) + " : ");
                arr[i][j] = Integer.parseInt(nhap.nextLine());
            }
        }
        int min = arr[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (min > arr[i][j]) {
                    min = arr[i][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
        System.out.print("Số nhỏ nhất trong mảng vừa rồi là : " + min);
    }
}
