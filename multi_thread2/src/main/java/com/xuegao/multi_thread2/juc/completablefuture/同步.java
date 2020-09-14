package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.completablefuture
 * <br/> @ClassName：同步
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/9/14 14:22
 */
public class 同步 {
    public static void main(String[] args) throws Exception {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(同步::fetchPrice);
        // 如果执行成功:
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Double aDouble = cf.get();
        System.out.println("aDouble = " + aDouble);
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(" InterruptedException ");
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}