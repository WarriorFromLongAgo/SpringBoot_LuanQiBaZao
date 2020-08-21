package com.xuegao.multi_thread2.atomic.countdownlatch;

import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.countdownlatch
 * <br/> @ClassName：CountDownLatchTest2
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/18 22:41
 */
public class CountDownLatchTest2 {
    private static final Logger log = LoggerFactory.getLogger(CountDownLatchTest2.class);

    public static void main(String[] args) throws InterruptedException {
        System.out.println(" 主线程开始 ");
        Stopwatch stopwatch = Stopwatch.createStarted();

        CountDownLatch countDownLatch = new CountDownLatch(2);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "，休眠了3秒 ");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.shutdown();

        ExecutorService executorService2 = Executors.newFixedThreadPool(1);
        executorService2.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getName() + "，休眠了5秒 ");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService2.shutdown();

        countDownLatch.await();
        System.out.println(" 主线程结束 ");
        System.out.println("共消耗时间为 = " + stopwatch.elapsed(TimeUnit.SECONDS) + " 秒");


        // 主线程开始
        // pool-1-thread-1，休眠了3秒
        // pool-2-thread-1，休眠了5秒
        // 主线程结束
        // 共消耗时间为 = 5 秒
    }
}