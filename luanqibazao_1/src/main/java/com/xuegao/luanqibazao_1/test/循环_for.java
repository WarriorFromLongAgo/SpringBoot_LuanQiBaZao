package com.xuegao.luanqibazao_1.test;

import java.util.concurrent.TimeUnit;

public class 循环_for {
    public static void main(String[] args) throws InterruptedException {
        String[] strArr = new String[3];
        strArr[0] = "str1";
        strArr[1] = "str2";
        strArr[2] = "str3";

        for (int i = 0; i < strArr.length; i++) {
            System.out.println(" strArr[" + i + "] = " + strArr[i]);
        }
        // strArr[0] = str1
        // strArr[1] = str2
        // strArr[2] = str3









        for (; ; ) {
            System.out.println("for(;;)");
            TimeUnit.SECONDS.sleep(1);
            break;
        }


    }
}
