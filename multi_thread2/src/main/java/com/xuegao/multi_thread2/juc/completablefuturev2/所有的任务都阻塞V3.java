package com.xuegao.multi_thread2.juc.completablefuturev2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/6/17 0:30
 */
public class 所有的任务都阻塞V3 {
    public static void main(String[] args) {
        double random = Math.random();
        // 0.8573953110249356
        System.out.println(random);
        long l = Double.valueOf(random * 10).longValue();
        // 8
        System.out.println(l);

        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format);
        List<CompletableFuture> completableFutureList = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            long sleep = (long) (Math.random() * 10);
            System.out.println(" sleep i = " + i + " sleep " + sleep);
            CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(new Runnable() {
                @Override
                public void run() {
                    sleep(sleep);
                }
            });
            completableFutureList.add(voidCompletableFuture);
        }


        String format2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format2);
        System.out.println("===========================");
    }

    static void sleep(long sleep) {
        try {
            TimeUnit.SECONDS.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}