package com.xuegao.luanqibazao_1.jdk8.util.object;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * <br/> @ClassName：ObjectsTest
 * <br/> @Description：
 * <br/> @date：2021/6/6 12:47
 */
public class ObjectsTest2 {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("1.0");
        System.out.println(Objects.equals(a, b));

        Integer aa = new Integer("1");
        Integer bb = new Integer("1");
        System.out.println(Objects.equals(aa, bb));
    }
}