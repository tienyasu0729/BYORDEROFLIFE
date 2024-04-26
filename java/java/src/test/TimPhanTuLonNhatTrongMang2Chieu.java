package test;

import java.util.Arrays;
import java.util.Scanner;

public class TimPhanTuLonNhatTrongMang2Chieu {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhập vào đây số hàng của mảng 2 chiều : ");
        int rows = Integer.parseInt(nhap.nextLine());
        System.out.print("Nhập vào đây số cột của mảng 2 chiều : ");
        int columns = Integer.parseInt(nhap.nextLine());
        int [][] arr = new int[rows][columns];
        int max = arr[0][0];
        int [] index = new int[2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Nhập vào đây phần tử ở hàng  " + (i+1) + " cột " + (j+1) + " : ");
                arr[i][j] = Integer.parseInt(nhap.nextLine());
                if (max < arr[i][j]) {
                    max = arr[i][j];
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
        System.out.print("Số lớn nhất trong mảng vừa rồi là : " + max + " .Tại vị trí : Hàng : " + (index[0]+1) + " cột : " + (index[1]+1));
    }
}
