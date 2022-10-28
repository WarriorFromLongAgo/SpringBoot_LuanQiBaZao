package com.xuegao.luanqibazao_1.test;

public class 循环_do_while {
    public static void main(String[] args) {
        String[] strArr = new String[3];
        strArr[0] = "str1";
        strArr[1] = "str2";
        strArr[2] = "str3";


        int i = 0;
        do {
            System.out.println(" strArr[" + i + "] = " + strArr[i]);
            i++;
        } while (i < strArr.length);

        // strArr[0] = str1
        // strArr[1] = str2
        // strArr[2] = str3

    }
}
