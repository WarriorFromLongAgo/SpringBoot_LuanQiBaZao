package com.xuegao.luanqibazao_1.test;
// protected

// 用于定义访问权限修饰符的关键字
// private public

// 共同点：
// 1，public定义的方法和private定义的方法，在同一个class类里面，可以直接调用


// 不同点：
// 1，在不同的class里面，不能调用private修饰的方法，可以调用public修饰的方法

public class 方法定义_public_提供方 {
    public static void main(String[] args) {

        public定义的方法1111111(11111);

        private定义的方法(222222);
    }

    public static void public定义的方法1111111(int a) {
        System.out.println("public定义的方法1111111;  a = " + a);
    }

    private static void private定义的方法(int a) {
        System.out.println("private定义的方法; a = " + a);
    }

    // protected void protected定义的方法(int a) {
    //
    // }
}
