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
public class scheduledExecutor3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName(" scheduledExecutor2 ");
                return thread;
            }
        });
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = LocalDateTime.now().format(formatter);
        System.out.println(format);
        System.out.println("============================");
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                String format = LocalDateTime.now().format(formatter);
                System.out.println("进入定时任务 1 的时间= " + format);
                int a = 8 / 0;
                String format2 = LocalDateTime.now().format(formatter);
                System.out.println("退出定时任务 1 的时间= " + format2);
            }
        }, 1, 3, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                String format = LocalDateTime.now().format(formatter);
                System.out.println("进入定时任务 2 的时间 = " + format);
            }
        }, 1, 3, TimeUnit.SECONDS);

        // 2020-08-27 12:55:52
        // ============================
        // 进入定时任务 1 的时间= 2020-08-27 12:55:53
        // 进入定时任务 2 的时间 = 2020-08-27 12:55:53
        // 进入定时任务 2 的时间 = 2020-08-27 12:55:56
        // 进入定时任务 2 的时间 = 2020-08-27 12:55:59
        // 进入定时任务 2 的时间 = 2020-08-27 12:56:02
        // 进入定时任务 2 的时间 = 2020-08-27 12:56:05
        // 进入定时任务 2 的时间 = 2020-08-27 12:56:08
        // 进入定时任务 2 的时间 = 2020-08-27 12:56:11
        // 进入定时任务 2 的时间 = 2020-08-27 12:56:14

        // 出现异常时，异常线程不再执行，但是另一个线程仍然是执行的
    }
}