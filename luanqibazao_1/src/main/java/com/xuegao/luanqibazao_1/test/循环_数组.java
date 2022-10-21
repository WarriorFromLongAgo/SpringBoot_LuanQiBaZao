package com.xuegao.luanqibazao_1.test;

public class 循环_数组 {
    public static void main(String[] args) {
        // int arr[] = new int[]{1, 2, 3, 4};
        // System.out.println("arr = " + arr);
        // System.out.println("arr length = " + arr.length);

        int a1 = 1;
        int a2 = 1;
        int a3 = 1;


        int[] arr2 = new int[3];
        arr2[0] = 1;
        arr2[1] = 2;
        arr2[2] = 3;
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("arr2[" + i + "] = " + arr2[i]);
            // arr2[0] = 1
            // arr2[1] = 2
            // arr2[2] = 3
        }

        int[] arr3 = new int[4];
        // arr2[0] = 1;
        // arr2[1] = 2;
        // arr2[2] = 3;
        for (int i = 0; i < arr2.length; i++) {
            arr3[i] = arr2[i];
        }
        arr2[3] = 4;

        // String str = new String("11");
        // String str1 = "11";

        String[] strArr = new String[3];
        strArr[0] = "str1";
        strArr[1] = "str2";
        strArr[2] = "str3";



    }
}
