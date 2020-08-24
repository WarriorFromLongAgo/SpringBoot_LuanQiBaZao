package com.xuegao.luanqibazao_1.基础类型;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.基础类型
 * <br/> @ClassName：asda
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/24 10:27
 */
public class DoubleString {
    public static void main(String[] args) {
        String price = "123.00";
        String price2 = "";
        double priceDouble = Double.parseDouble(price);
        System.out.println(priceDouble);
    }
}