package com.xuegao.luanqibazao_1.ali.ttl;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import com.xuegao.luanqibazao_1.common.ThreadPoolOne;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * ttl 和 Inheritable 的区别
 * <p>
 * 1，运费预测context使用的是jdk的in，如果在某个线程池里面修改了context的值，那么上下文traceId就会被修改了
 *
 *
 * @author xuegao
 * @version 1.0
 * @date 2021/12/18 14:04
 */
public class TtlCompare1 {
    public static void main(String[] args) throws InterruptedException {
        // inheritable1000();
        ttl1000();
    }

    private static void enter() {
        System.out.println("===========================");
    }

    public static void ttl1000() throws InterruptedException {
        ThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();
        Executor ttlExecutor = TtlExecutors.getTtlExecutor(ThreadPoolOne.getInstance());
        threadLocal.set("11111");
        System.out.println(Thread.currentThread().getName() + " main = " + threadLocal.get());

        ttlExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " aaa = " + threadLocal.get());
                threadLocal.set("22222");
            }
        });
        System.out.println(Thread.currentThread().getName() + " main = " + threadLocal.get());
        ttlExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " ddd = " + threadLocal.get());
            }
        });
        System.out.println(Thread.currentThread().getName() + " main = " + threadLocal.get());
        TimeUnit.SECONDS.sleep(1);
        ThreadPoolOne.getInstance().shutdown();
    }
    // main main = 11111
    // main main = 11111
    // main main = 11111
    // ThreadPoolOne1 aaa = 11111
    // ThreadPoolOne1 ddd = 11111

    /**
     * 第一个线程在使用的时候，会获取到这个值，然后进行了修改，
     * 就会影响这个线程在其他地方的使用，也就是context被修改了，导致其他线程在用的时候，出现了不一样的地方
     *
     * @author fjm
     * @date 2021/12/18 19:34
     */
    public static void inheritable1000() throws InterruptedException {
        ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
        threadLocal.set("11111");
        System.out.println(Thread.currentThread().getName() + " main = " + threadLocal.get());

        ThreadPoolOne.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " aaa = " + threadLocal.get());
                threadLocal.set("22222");
            }
        });
        System.out.println(Thread.currentThread().getName() + " main = " + threadLocal.get());
        ThreadPoolOne.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " ddd = " + threadLocal.get());
            }
        });
        System.out.println(Thread.currentThread().getName() + " main = " + threadLocal.get());
        TimeUnit.SECONDS.sleep(1);
        ThreadPoolOne.getInstance().shutdown();
    }
    // main main = 11111
    // main main = 11111
    // main main = 11111
    // ThreadPoolOne1 aaa = 11111
    // ThreadPoolOne1 ddd = 22222


}