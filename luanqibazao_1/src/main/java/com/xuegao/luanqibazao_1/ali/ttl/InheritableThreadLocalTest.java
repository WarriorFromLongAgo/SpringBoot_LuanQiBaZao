package com.xuegao.luanqibazao_1.ali.ttl;

import com.xuegao.luanqibazao_1.common.ThreadPoolOne;
import com.xuegao.luanqibazao_1.common.ThreadPoolBusiness;

import java.util.concurrent.TimeUnit;

/**
 * 1-1线程池，3-3线程池使用的区别
 *
 * @author xuegao
 * @version 1.0
 * @date 2021/12/18 14:04
 */
public class InheritableThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        // inheritable1();
        inheritable2();


    }

    private static void enter() {
        System.out.println("===========================");
    }

    public static void inheritable1() throws InterruptedException {
        // 在这个地方使用后，线程池中的线程都会获取到这个值，
        // 并且可以在其他地方使用，这里用的时候，线程池都是，1，1，最大1，活动1
        ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

        ThreadPoolOne.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("11111");
                System.out.println(Thread.currentThread().getName() + " aaa = " + threadLocal.get());
            }
        });

        ThreadPoolOne.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " ddd = " + threadLocal.get());
            }
        });

        TimeUnit.SECONDS.sleep(1);
        ThreadPoolOne.getInstance().shutdown();
    }

    public static void inheritable2() throws InterruptedException {
        ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

        ThreadPoolBusiness.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("11111");
                System.out.println(Thread.currentThread().getName() + " aaa = " + threadLocal.get());
            }
        });

        for (int i = 0; i < 10; i++) {
            ThreadPoolBusiness.getInstance().execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " ddd = " + threadLocal.get());
                }
            });
        }
        TimeUnit.SECONDS.sleep(1);
        ThreadPoolBusiness.getInstance().shutdown();
    }

}