package com.xuegao.multi_thread2.juc.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.semaphore
 * <br/> @ClassName：SemaphoreTest2
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/9/30 14:08
 */
public class SemaphoreTest2 {

    // 前面两个章节学习了 CountDownLatch 和 CyclicBarrier  ，他们都是递减同步器，今天学习递增同步器 Semaphore。
    // Semaphore（信号量）是用来控制同时访问特定资源的线程数量，它通过协调各个线程，以保证合理的使用公共资源。
    // 看到这个信号量我的脑海中就出现了红绿灯，为了保证学生的安全，学校的十字路口一般都设有红绿灯，车流量控制，
    // 每一次绿灯同时能通行 100 辆汽车，没有在绿灯通行的汽车都会被阻塞，直到下一次绿灯。

    // 校门口红绿灯等待中.....
    // 1年级通过红绿灯......
    // 2年级通过红绿灯......
    // 4年级通过红绿灯......
    // 3年级通过红绿灯......
    // 5年级通过红绿灯......
    // 6年级通过红绿灯......

    private final static int gradeNum = 6;

    private static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newScheduledThreadPool(gradeNum);
        System.out.println("校门口红绿灯等待中.....");
        for (int i = 0; i < gradeNum; i++) {
            int gradeName = i + 1;
            exec.submit(() -> {
                try {
                    // 获取一个许可
                    semaphore.acquire();
                    wait(gradeName);
                    // 释放一个许可
                    semaphore.release();
                } catch (Exception e) {
                }
            });
        }
        exec.shutdown();
    }

    private static void wait(int gradeName) throws Exception {
        TimeUnit.SECONDS.sleep(1);
        System.out.println(gradeName + "年级通过红绿灯......");
    }

    // 作者：山间木匠
    // 链接：https://juejin.im/post/6878082567095418888
    // 来源：掘金
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}