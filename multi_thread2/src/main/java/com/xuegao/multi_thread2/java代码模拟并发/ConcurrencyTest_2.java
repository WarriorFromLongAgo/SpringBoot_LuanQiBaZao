package com.xuegao.multi_thread2.java代码模拟并发;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

// 并发代码线程安全提升
// 由线程不安全变为线程安全，仅使用栅栏的方式：
public class ConcurrencyTest_2 {
 
       // 请求总数
    public static int clientTotal = 5000;
 
    // 原子锁
    public static AtomicInteger count = new AtomicInteger(0);
 
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
 
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal ; i++) {
            executorService.execute(() -> {
                countDownLatch.countDown();
                try {
                    countDownLatch.await();
                    add();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
 
        try{
            //直到方法执行完成
            Thread.sleep(10000);
            executorService.shutdown();
            System.out.println(count);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
 
    private static void add() {
        count.incrementAndGet();
    }
 
}
