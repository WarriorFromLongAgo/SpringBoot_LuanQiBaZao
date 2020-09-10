package com.xuegao.multi_thread2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.http
 * <br/> @ClassName：WordTest
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/9/10 9:18
 */
public class 标准ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始执行");
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(10, 10, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable runnable) {
                        Thread thread = new Thread(runnable);
                        thread.setName("KMS");
                        return thread;
                    }
                });
        // 设置拒绝策略，
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 空闲队列存活时间
        threadPoolExecutor.setKeepAliveTime(20, TimeUnit.SECONDS);
        List<Integer> intList = new ArrayList<>(2000);

        try {
            for (int i = 0; i < 200; i++) {
                final int num = i;
                threadPoolExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + "- 结果：" + num);
                        intList.add(num);
                    }
                });
            }
        } finally {
            threadPoolExecutor.shutdown();
            threadPoolExecutor.awaitTermination(10, TimeUnit.SECONDS);
        }
        System.out.println("线程执行结束");
    }
}