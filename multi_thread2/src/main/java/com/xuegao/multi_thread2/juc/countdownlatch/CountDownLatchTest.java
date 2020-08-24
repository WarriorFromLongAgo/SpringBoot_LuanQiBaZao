package com.xuegao.multi_thread2.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static final CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) {
        Thread th1 = new Thread(() -> {
            System.out.println("th1 run.");
            countDownLatch.countDown();
        });

        Thread th2 = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("th2 run.");
            countDownLatch.countDown();
        });

        Thread th3 = new Thread(() -> {
            System.out.println("th3 waiting until count down 0.");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("th3 last to run.");
        });

        th1.start();
        th2.start();
        th3.start();
    }
}