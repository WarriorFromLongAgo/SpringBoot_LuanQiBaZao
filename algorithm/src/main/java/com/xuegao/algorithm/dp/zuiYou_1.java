package com.xuegao.algorithm.dp;

/**
 * <br/> @PackageName：com.xuegao.algorithm.dp
 * <br/> @ClassName：
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/15 16:55
 */
public class zuiYou_1 {
    // 1，最后一步
    // 可以往前一步，27 - 1，或者27 - 2

    public static void main(String[] args) {
        int clim = getClim(10);
        System.out.println(clim);
    }

    private static int getClim(int n) {
        int[] sum = new int[n + 1];
        sum[0] = 0;
        if (n > 0) {
            sum[1] = 1;
        }
        if (n > 1) {
            sum[2] = 2;
        }
        for (int i = 3; i <= n; i++) {
            sum[i] = sum[i - 2] + sum[i - 1];
        }
        return sum[n];
    }
}