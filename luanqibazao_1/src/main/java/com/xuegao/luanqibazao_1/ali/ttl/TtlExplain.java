package com.xuegao.luanqibazao_1.ali.ttl;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import com.xuegao.luanqibazao_1.common.ThreadPoolTwo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ttl使用注意事项，必须对线程池包一层
 *
 * @author xuegao
 * @version 1.0
 * @date 2021/12/18 20:49
 */
public class TtlExplain {
    public static void main(String[] args) {
        // ttl2();
        // ttl2_2();
    }

    /**
     * 不能直接这样使用
     * 线程池复用还是会有这个现象，只要使用了，上面线程设置的值，会在其他线程继续使用的时候，再次打印出来
     *
     * @author fjm
     * @date 2021/12/18 18:19
     */
    public static void ttl2() throws InterruptedException {
        ThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();

        ThreadPoolTwo.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("11111");
                System.out.println(Thread.currentThread().getName() + " aaa = " + threadLocal.get());
            }
        });

        for (int i = 0; i < 10; i++) {
            ThreadPoolTwo.getInstance().execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " ddd = " + threadLocal.get());
                }
            });
        }
        TimeUnit.SECONDS.sleep(1);
        ThreadPoolTwo.getInstance().shutdown();
    }
    // ThreadPoolTwo1 aaa = 11111
    // ThreadPoolTwo1 ddd = 11111
    // ThreadPoolTwo1 ddd = 11111
    // ThreadPoolTwo2 ddd = null
    // ThreadPoolTwo3 ddd = null
    // ThreadPoolTwo1 ddd = 11111
    // ThreadPoolTwo1 ddd = 11111
    // ThreadPoolTwo2 ddd = null
    // ThreadPoolTwo2 ddd = null
    // ThreadPoolTwo1 ddd = 11111
    // ThreadPoolTwo3 ddd = null

    /**
     * 不能直接这样使用，这里就是线程池必须包一层
     *
     * @author fjm
     * @date 2021/12/18 18:19
     */
    public static void ttl2_2() throws InterruptedException {
        ThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();
        ExecutorService executorService = TtlExecutors.getTtlExecutorService(ThreadPoolTwo.getInstance());

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("11111");
                System.out.println(Thread.currentThread().getName() + " aaa = " + threadLocal.get());
            }
        });

        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " ddd = " + threadLocal.get());
                }
            });
        }
        TimeUnit.SECONDS.sleep(1);
        executorService.shutdown();
    }
    // ThreadPoolTwo1 aaa = 11111
    // ThreadPoolTwo1 ddd = null
    // ThreadPoolTwo1 ddd = null
    // ThreadPoolTwo1 ddd = null
    // ThreadPoolTwo1 ddd = null
    // ThreadPoolTwo1 ddd = null
    // ThreadPoolTwo1 ddd = null
    // ThreadPoolTwo1 ddd = null
    // ThreadPoolTwo1 ddd = null
    // ThreadPoolTwo2 ddd = null
    // ThreadPoolTwo3 ddd = null
}