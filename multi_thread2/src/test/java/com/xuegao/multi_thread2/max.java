package com.xuegao.multi_thread2;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2
 * <br/> @ClassName：max
 * <br/> @Description：
 * <br/> @author：feijm
 * <br/> @date：2020/8/29 9:26
 */
public class max {
    public static void main(String[] args) {
        long maxValue = Long.MAX_VALUE;
        System.out.println(maxValue);
        System.out.println(String.valueOf(maxValue).length());
        long maxValue2 = Long.MAX_VALUE - 100;
        boolean b = maxValue == maxValue2;
        System.out.println(b);

        double maxValue1 = Double.MAX_VALUE;
        System.out.println(maxValue1);
    }
}