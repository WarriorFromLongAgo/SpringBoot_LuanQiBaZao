package com.xuegao.luanqibazao_1.jdk8.util.scanner;

import java.util.Scanner;

/**
 * <br/> @ClassName：ScannerTest
 * <br/> @Description：
 * <br/> @date：2021/9/16 15:16
 */
public class ScannerTest {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        int x = 10; // 첫 번째 숫자 저장
        int y = 20; //두 번째 숫자 저장

        System.out.println("첫번째 숫자를 입력하시오:" + x);//입력 안내 출력
        x = input.nextInt();

        System.out.println("두번째 숫자를 입력하시오:" + y); //입력 안내 출력
        y = input.nextInt();
        int sum = x + y; //합을 저장

        System.out.println(sum); //합을 출력한다
    }
}