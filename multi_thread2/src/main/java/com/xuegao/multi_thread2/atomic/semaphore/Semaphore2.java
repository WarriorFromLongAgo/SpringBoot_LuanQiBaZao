package com.xuegao.multi_thread2.atomic.semaphore;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.semaphore
 * <br/> @ClassName：Semaphore2
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/11 19:05
 */
public class Semaphore2 implements Runnable {

    static Semaphore semaphore = new Semaphore(3);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getId() + " 抢到了位置 ");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId() + " 停车2秒后 离开车位 ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(6, 6, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        // 模拟 6 辆车
        Semaphore2 semaphore2 = new Semaphore2();
        for (int i = 1; i <= 6; i++) {
            threadPoolExecutor.execute(semaphore2);
        }
        threadPoolExecutor.shutdown();
    }
}