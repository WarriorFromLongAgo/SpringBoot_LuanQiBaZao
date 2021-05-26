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
        BigDecimal bigDecimal = new BigDecimal("11.1100");
        BigDecimal multiply = bigDecimal.multiply(new BigDecimal("1.2"));
        System.out.println(multiply);
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