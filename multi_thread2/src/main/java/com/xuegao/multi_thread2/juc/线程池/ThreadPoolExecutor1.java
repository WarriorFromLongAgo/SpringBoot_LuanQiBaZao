package com.xuegao.multi_thread2.juc.线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.线程池
 * <br/> @ClassName：ThreadLocalPool
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/9/2 20:16
 */
public class ThreadPoolExecutor1 {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(4), runnable -> {
            Thread thread = new Thread(runnable);
            thread.setName("KMS");
            return thread;
        });
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(finalI + " 号线程开始执行");
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPoolExecutor.shutdown();

    }
}