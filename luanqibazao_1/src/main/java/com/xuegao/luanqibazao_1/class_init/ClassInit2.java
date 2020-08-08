package com.xuegao.luanqibazao_1.class_init;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.class_init
 * <br/> @ClassName：ClassInit2
 * <br/> @Description：
 * <br/> @author：feijm
 * <br/> @date：2020/8/7 0:01
 */
public class ClassInit2 {

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
        System.out.println("mainmainmain");
        ClassInit2 classInit2 = new ClassInit2();
        // 静态代码块1
        // 静态代码块2
        // mainmainmain
        // 代码块1
        // 代码块2
    }
}