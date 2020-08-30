package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.completablefuture
 * <br/> @ClassName：handle1
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/30 12:07
 */
public class handle1 {
    public static void main(String[] args) {
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> "100")
                .thenApply(s -> s + "100")
                .handle((s, t) -> s != null ? Double.parseDouble(s) : 0);
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}