package com.xuegao.luanqibazao_1.class_init;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1
 * <br/> @ClassName：ClassInit1
 * <br/> @Description：
 * <br/> @author：feijm
 * <br/> @date：2020/8/6 23:55
 */
public class ClassInit1 {

    static {
        System.out.println("静态代码块1");
    }

    {
        System.out.println("代码块1");
    }

    {
        System.out.println("代码块2");
    }

    static {
        System.out.println("静态代码块2");
    }

    public static void main(String[] args) {
        // 静态代码块1
        // 静态代码块2
        // mainmain
        System.out.println("mainmain");
    }

}