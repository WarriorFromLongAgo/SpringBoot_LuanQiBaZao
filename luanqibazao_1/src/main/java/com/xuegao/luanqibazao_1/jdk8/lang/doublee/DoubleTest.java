package com.xuegao.luanqibazao_1.jdk8.lang.doublee;

import java.math.BigDecimal;

/**
 * <br/> @ClassName：DoubleTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/6/10 15:15
 */
public class DoubleTest {
    public static void main(String[] args) {
        Double aDouble = Double.valueOf("1");
        System.out.println(aDouble);


    }

    private static void extracted1() {
        Double bigDecimal1 = new Double("0");
        Double bigDecimal2 = new Double("100.00");
        Double bigDecimal3 = new Double("99.99");
        Double bigDecimal4 = new Double("-1");
        System.out.println(bigDecimal1.equals(bigDecimal3));
        System.out.println(bigDecimal1.equals(bigDecimal2));
        System.out.println(bigDecimal1.compareTo(bigDecimal2));
        System.out.println(bigDecimal1.compareTo(bigDecimal3));
        System.out.println(bigDecimal1.compareTo(bigDecimal4));
    }

    private static void extracted() {
        Double aDouble1 = new Double(1000.00);
        a1000(aDouble1);
        Double aDouble2 = new Double(0.00);
        a1000(aDouble2);
        Double aDouble3 = new Double(200.00);
        a1000(aDouble3);
        Double aDouble4 = new Double(999.99);
        a1000(aDouble4);
    }

    private static void a1000(Double aDouble1) {
        double v = aDouble1 / 1000;
        System.out.println(v);
    }
}