package com.xuegao.luanqibazao_1.jdk8.lang.threadlocal;

/**
 * @author xuegao
 * @version 1.0
 * @date 2021/12/11 14:58
 */
public class MyThreadLocalTest1 {
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void main(String[] args) {
        THREAD_LOCAL.set("luanqi");
        System.out.println("main线程 = " + THREAD_LOCAL.get());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("新的线程 = " + THREAD_LOCAL.get());
            }
        }).start();
    }
}