package com.xuegao.multi_thread2.java代码模拟并发;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.java代码模拟并发
 * <br/> @ClassName：不使用CountDownLatch
 * <br/> @Description： 故针对上述一次并发不推荐使用CountDownLatch增加程序复杂度
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/24 17:07
 */
public class 不使用CountDownLatch {
    public static void main(String[] args) {
        int parrelnum=100;
        List<Future<String>> futureList = new ArrayList<>();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(parrelnum);
        for (int i = 0; i < parrelnum; i++) {
            Future<String> submit = fixedThreadPool.submit(() -> {
                try {
                    System.out.println("======-----------------------------"+ LocalDateTime.now());
//                    System.out.println("======-----------------------------"+ LocalDateTime.now()
//                            +":"+Thread.currentThread().getName()
//                            +"；守护线程："+Thread.currentThread().isDaemon());
                    Thread.sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "ok:"+LocalDateTime.now();
            });
            futureList.add(submit);
        }
        fixedThreadPool.shutdown();

        try {
            System.out.println(LocalDateTime.now()+":"+"1秒后统一开始");
            Thread.sleep(1000);
            for (Future<String> future : futureList) {
                System.out.println(future.get());
            }
            System.out.println(LocalDateTime.now()+":"+"全部结束");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}