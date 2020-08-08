package com.xuegao.luanqibazao_1.class_init;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.class_init
 * <br/> @ClassName：ClassInit2
 * <br/> @Description：
 * <br/> @author：feijm
 * <br/> @date：2020/8/7 0:01
 */
public class ClassInit3 {

    public static void main(String[] args) {
        B b = new B();
        b.aaa();
        // A : = 1
        // A : = 2
        // A : = 3
        // B============
        // A : = 33
        // aaaa
    }
}

class A {
    public A(int i) {
        System.out.println("A : = " + i);
    }
}

class B {
    public B() {
        System.out.println("B============");
        a3 = new A(33);
    }

    A a1 = new A(1);
    A a2 = new A(2);
    A a3 = new A(3);

    public void aaa() {
        System.out.println("aaaa");
    }
}