package com.xuegao.luanqibazao_1.jdk8.math;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.math
 * <br/> @ClassName：BigDecimalTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/9/26 0:06
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal("85.0");
        BigDecimal bigDecimal2 = new BigDecimal("84.00");
        BigDecimal bigDecimal3 = new BigDecimal("86.00");
        // BigDecimal bigDecimal4 = new BigDecimal("99.98");
        // System.out.println(bigDecimal1.equals(bigDecimal3));
        // System.out.println(bigDecimal1.equals(bigDecimal2));
        System.out.println(bigDecimal1.compareTo(bigDecimal2));
        System.out.println(bigDecimal1.compareTo(bigDecimal3));
        // System.out.println(bigDecimal1.compareTo(bigDecimal4));


    }

    public static void bigDecimal1() {
        BigDecimal bigDecimal = new BigDecimal(1);
        BigDecimal bigDecimal1 = new BigDecimal(1);
        System.out.println(bigDecimal == bigDecimal1);
    }

    public static void bigDecimal2() {
        BigDecimal bigDecimal = new BigDecimal(1);
        BigDecimal bigDecimal1 = new BigDecimal(1);
        System.out.println(bigDecimal.equals(bigDecimal1));
    }

    public static void bigDecimal3() {
        BigDecimal bigDecimal = new BigDecimal(1);
        BigDecimal bigDecimal1 = new BigDecimal(1.0);
        System.out.println(bigDecimal.equals(bigDecimal1));
    }

    public static void bigDecimal4() {
        BigDecimal bigDecimal = new BigDecimal("1");
        BigDecimal bigDecimal1 = new BigDecimal("1.0");
        System.out.println(bigDecimal.equals(bigDecimal1));
    }

    public static void bigDecimal5() {
        BigDecimal bigDecimal = new BigDecimal("1");
        BigDecimal bigDecimal1 = new BigDecimal("1");
        System.out.println(bigDecimal.equals(bigDecimal1));
    }

    public static void bigDecimal6_CompareTo() {
        BigDecimal bigDecimal = new BigDecimal("1");
        BigDecimal bigDecimal1 = new BigDecimal("1.0");
        System.out.println(bigDecimal.compareTo(bigDecimal1));
    }

    public static void multiplication() {
        BigDecimal bigDecimal = new BigDecimal("100.0000");
        BigDecimal multiply = bigDecimal.multiply(new BigDecimal("1.2"));
        System.out.println(multiply);
    }

}