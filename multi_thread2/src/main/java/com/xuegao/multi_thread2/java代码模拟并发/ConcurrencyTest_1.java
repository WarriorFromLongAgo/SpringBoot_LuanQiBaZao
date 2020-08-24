package com.xuegao.multi_thread2.java代码模拟并发;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

// 并发代码演示
// 下面的代码既用了栅栏又用了信号量，许多简单的测试使用栅栏就够了。
@NotThreadSafe
public class ConcurrencyTest_1 {

    private final static Logger log = LoggerFactory.getLogger(ConcurrencyTest.class);

    // 请求总数
    public static int clientTotal = 5000;
 
    // 同时并发执行的线程数
    public static int threadTotal = 200;
 
    public static int count = 0;
 
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal ; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);
    }
 
    private static void add() {
        count++;
    }
}
