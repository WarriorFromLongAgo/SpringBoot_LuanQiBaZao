package com.xuegao.multi_thread2.juc.semaphore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestSemaPhore {
    private static int count = 0;
    //初始化信号量为 1
    private static final Semaphore semaphore = new Semaphore(3);

    public static void addOne() throws InterruptedException {
        //使用信号量保证互斥，只有一个线程进入
        semaphore.acquire();
        try {
            count++;
            System.out.println("addOne = " + count);
        } finally {
            semaphore.release();
        }
    }

    public static int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        //模拟十个线程同时访问
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    addOne();
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        countDownLatch.countDown();
        TimeUnit.SECONDS.sleep(3);
        int count = getCount();
        System.out.println(count);
    }

}