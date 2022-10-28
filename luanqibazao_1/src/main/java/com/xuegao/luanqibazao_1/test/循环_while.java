package com.xuegao.luanqibazao_1.test;

import java.util.concurrent.TimeUnit;

public class 循环_while {
    public static void main(String[] args) throws InterruptedException {
        String[] strArr = new String[3];
        strArr[0] = "str1";
        strArr[1] = "str2";
        strArr[2] = "str3";


        int i = 0;
        while (i < strArr.length) {
            System.out.println(" strArr[" + i + "] = " + strArr[i]);
            i++;
        }
        // strArr[0] = str1
        // strArr[1] = str2
        // strArr[2] = str3






        while (true) {
            System.out.println("for(;;)");
            TimeUnit.SECONDS.sleep(1);
        }


    }
}
