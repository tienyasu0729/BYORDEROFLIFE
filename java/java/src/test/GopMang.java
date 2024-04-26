package test;

import java.util.Arrays;

public class GopMang {
    public static void main(String[] args) {
        int [] arr1 = new int[10];
        int [] arr2 = new int[10];
        int [] arr3 = new int[arr1.length + arr2.length];
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i;
            arr3[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i;
        }
        for (int i = arr1.length; i < arr3.length ; i++) {
            arr3[i] = arr2[count];
            count++;
        }
        System.out.print(Arrays.toString(arr3));
    }
}
