package com.xuegao.multi_thread2.java代码模拟并发;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.java代码模拟并发
 * <br/> @ClassName：CyclicBarrier
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/24 17:08
 */
public class CyclicBarrierTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int parrelnum = 5;
        //所有线程阻塞，然后统一开始
        CyclicBarrier cyclicBarrier = new CyclicBarrier(parrelnum);
        List<Future<String>> futureList = new ArrayList<>();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(parrelnum);
        for (int i = 0; i < 15; i++) {
            Future<String> submit = fixedThreadPool.submit(() -> {
                try {
                    Thread.sleep(new Random().nextInt(2000));
                    //begin 阻塞所有线程
                    cyclicBarrier.await();
                    System.out.println("======-----------------------------并发：" + LocalDateTime.now());
                    Thread.sleep(new Random().nextInt(2000));
                    System.out.println("======-----------------------------" + LocalDateTime.now()
                            + ":" + Thread.currentThread().getName()
                            + "；守护线程：" + Thread.currentThread().isDaemon());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "ok:" + LocalDateTime.now();
            });
            futureList.add(submit);
        }

        for (Future<String> future : futureList) {
            future.get();
//                System.out.println(future.get());
        }
    }
}