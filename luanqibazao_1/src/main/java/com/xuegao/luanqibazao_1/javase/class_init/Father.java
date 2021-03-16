package com.xuegao.luanqibazao_1.javase.class_init;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.javase.class_init
 * <br/> @ClassName：Father
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/03/15 18:12
 */
public class Father {
    public String publicStr;
    private String privateStr;

    public Father() {
        System.out.println("Father()");
    }

    public Father(int i) {
        System.out.println("Father(int i) = " + i);
    }

    public void publicVoid() {
        System.out.println("publicVoid  publicStr = " + publicStr + ", privateStr = " + privateStr);
    }

    private void privateVoid() {
        System.out.println("privateVoid  publicStr = " + publicStr + ", privateStr = " + privateStr);
    }
}