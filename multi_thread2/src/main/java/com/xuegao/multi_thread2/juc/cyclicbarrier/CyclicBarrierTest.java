package com.xuegao.multi_thread2.juc.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.cyclicbarrier
 * <br/> @ClassName：CyclicBarrierTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/7/24 11:05
 */
public class CyclicBarrierTest {

    // 回栏珊，注册一个额外的线程
    public static final CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> {
        System.out.println("令牌已经为空了，准备唤醒等待中的线程.");
    });


    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            executorService.submit(() -> {
                try {
                    String thName = Thread.currentThread().getName();
                    System.out.println(thName + " 执行完毕，等待通知...");
                    cyclicBarrier.await();
                    System.out.println(thName + " 收到通知.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    // ignore
                }
            });
        }

        executorService.shutdown();
    }
}