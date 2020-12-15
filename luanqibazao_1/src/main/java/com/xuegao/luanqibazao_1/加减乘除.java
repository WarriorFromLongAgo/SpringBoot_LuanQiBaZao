package com.xuegao.luanqibazao_1;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1
 * <br/> @ClassName：加减乘除
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/12/15 14:27
 */
public class 加减乘除 {
    public static void main(String[] args) {
        chu();
    }

    private static void chu() {

        int v = (int) ((BigDecimal.valueOf((float) 22 / 23).setScale(2, RoundingMode.UP).doubleValue()) * 100);

        System.out.println(v + "%");
    }
}