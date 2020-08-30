package com.xuegao.multi_thread2.juc.线程池;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.线程池
 * <br/> @ClassName：scheduledExecutor
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/27 12:43
 */
public class scheduledExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName(" scheduledExecutor 1 ");
                return thread;
            }
        });
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = LocalDateTime.now().format(formatter);
        System.out.println(format);
        System.out.println("============================");
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                String format = LocalDateTime.now().format(formatter);
                System.out.println(format);
            }
        }, 2, 3, TimeUnit.SECONDS);
        System.out.println(scheduledFuture.get());

        // 2020-08-27 12:48:00
        // ============================
        // 2020-08-27 12:48:02
        // 2020-08-27 12:48:05
        // 2020-08-27 12:48:08
        // 2020-08-27 12:48:11
        // 2020-08-27 12:48:14
        // 最开始的时候，2秒打印，后面的都是3秒打印
    }
}