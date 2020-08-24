package com.xuegao.multi_thread2.java代码模拟并发;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrencyTest_3 {
 
    // 请求总数
    public static int clientTotal = 5000;
 
    // 原子锁
    public static AtomicInteger count = new AtomicInteger(0);
 
    public static void main(String[] args) throws Exception {
 
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
 
        for (int i = 0; i < clientTotal ; i++) {
            new Thread(()->{
                countDownLatch.countDown();
                try {
                    countDownLatch.await();
                    add();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            Thread.sleep(10000);
            System.out.println(count);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
 
    private static void add() {
        count.incrementAndGet();
    }
}
