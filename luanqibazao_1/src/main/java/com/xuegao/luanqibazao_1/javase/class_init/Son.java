package com.xuegao.luanqibazao_1.javase.class_init;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.javase.class_init
 * <br/> @ClassName：Son
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/03/15 18:11
 */
public class Son extends Father {

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

    public Son() {
        System.out.println("B============");
        father3 = new Father(33);
    }

    Father father1 = new Father(1);
    Father father2 = new Father(2);
    Father father3 = new Father(3);

    public void aaa() {
        System.out.println("aaaa");
    }

    public static void main(String[] args) {
        System.out.println("mainmain");
        Son son = new Son();
        son.aaa();
        System.out.println(son.publicStr);
        // 报错
        // System.out.println(son.privateStr);

        Father father = new Son();

    }
}