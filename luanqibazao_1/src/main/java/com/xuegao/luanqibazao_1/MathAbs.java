package com.xuegao.luanqibazao_1;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1
 * <br/> @ClassName：
 * <br/> @Description：
 * <br/> @author：feijm
 * <br/> @date：2020/6/15 11:23
 */
public class MathAbs {
    public static void main(String[] args) {
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        // 2147483647
        int abs = Math.abs(Integer.MAX_VALUE);
        System.out.println("Math.abs(Integer.MAX_VALUE) = " + abs);
        System.out.println("====================================");
        // 也就是如果参数是整数最小负数，则Math.abs（int a）方法会返回最小负数本身，那么该方法为啥这样做那。
        // 其实是因为最大正数为2147483647，而最小负数为-2147483648，对最小负数加绝对值后，已经超过了最大正正数所表达的范围。

        // 可以使用long来处理

        System.out.println("Integer.MAX_VALUE = " + Integer.MIN_VALUE);
        // -2147483648
        int abs1 = Math.abs(Integer.MIN_VALUE);
        System.out.println("Math.abs(Integer.MIN_VALUE) = " + abs1);
    }
}