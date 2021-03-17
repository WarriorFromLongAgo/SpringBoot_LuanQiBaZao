package com.xuegao.luanqibazao_1.jdk8.util.concurrent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.util.concurrent
 * <br/> @ClassName：ScheduledExecutorServiceTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/03/17 20:22
 */
public class ScheduledExecutorServiceTest {
    private static final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("ScheduledExecutorServiceTest");
            return thread;
        }
    });

    public static void main(String[] args) {
        a();
        // b();
    }

    private static void a() {
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format);
        // 创建并执行一个周期性操作，该操作在给定的初始延迟后首先启用，然后在给定的时间段内启用；
        // 也就是说执行将在initialDelay initialDelay+period ， initialDelay + 2 * period等之后开始。
        // 如果任务的任何执行遇到异常，则将禁止后续执行。
        // 否则，任务将仅通过取消或终止执行程序而终止。
        // 如果此任务的任何执行花费的时间超过其时间，则后续执行可能会开始较晚，但不会同时执行。
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                System.out.println("ScheduledExecutorServiceTest a = " + format);
            }
        }, 6, 10, TimeUnit.SECONDS);

        // 2021-03-17 20:28:39
        // ScheduledExecutorServiceTest a = 2021-03-17 20:28:44
        // ScheduledExecutorServiceTest a = 2021-03-17 20:28:54
    }

    private static void b() {
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format);
        // 创建并执行一个周期性动作，该动作将在给定的初始延迟后首先启用，然后在一个执行的终止与下一个执行的开始之间具有给定的延迟。
        // 如果任务的任何执行遇到异常，则将禁止后续执行。 否则，任务将仅通过取消或终止执行程序而终止。
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                System.out.println("ScheduledExecutorServiceTest a = " + format);
            }
        }, 5, 8, TimeUnit.SECONDS);

        // 2021-03-17 20:30:32
        // ScheduledExecutorServiceTest a = 2021-03-17 20:30:37
        // ScheduledExecutorServiceTest a = 2021-03-17 20:30:45
        // ScheduledExecutorServiceTest a = 2021-03-17 20:30:53
        // ScheduledExecutorServiceTest a = 2021-03-17 20:31:01
        // ScheduledExecutorServiceTest a = 2021-03-17 20:31:09
    }
}