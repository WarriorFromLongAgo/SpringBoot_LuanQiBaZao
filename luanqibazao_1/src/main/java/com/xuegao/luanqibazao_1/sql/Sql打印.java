package com.xuegao.luanqibazao_1.sql;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1
 * <br/> @ClassName：Sql打印
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/29 10:46
 */
public class Sql打印 {
    public static void main(String[] args) {
        long a = 6000_0;
        System.out.println(a);

        double seconds = a / 1000.0;
        System.out.println(seconds);

        String str = "train.homework/001/597/216/872/916/097bd3e3-5670-47e1-b333-ba7c028d962f.mp4";
        String substring = str.substring(0, str.lastIndexOf("/") + 1);
        System.out.println(substring);

        String s = String.valueOf(Long.MAX_VALUE);
        System.out.println(s);
        System.out.println(s.length());

        String s1 = String.valueOf(Integer.MAX_VALUE);
        System.out.println(s1);
        System.out.println(s1.length());
    }
}