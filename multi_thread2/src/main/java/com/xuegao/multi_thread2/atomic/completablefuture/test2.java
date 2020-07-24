package com.xuegao.multi_thread2.atomic.completablefuture;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.completablefuture
 * <br/> @ClassName：test2
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/7/22 19:52
 */
public class test2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<ArrayList> completableFuture = CompletableFuture.supplyAsync(new Supplier<ArrayList>() {
            @Override
            public ArrayList get() {
                System.out.println("0000" + Thread.currentThread().getName());
                return new ArrayList();
            }
        }).whenCompleteAsync(new BiConsumer<ArrayList, Throwable>() {
            @Override
            public void accept(ArrayList arrayList, Throwable throwable) {
                System.out.println("1111" + Thread.currentThread().getName());
                arrayList.add(1);
            }
        }).whenCompleteAsync(new BiConsumer<ArrayList, Throwable>() {
            @Override
            public void accept(ArrayList arrayList, Throwable throwable) {
                System.out.println("2222" + Thread.currentThread().getName());
                arrayList.add(2);
            }
        }).whenCompleteAsync(new BiConsumer<ArrayList, Throwable>() {
            @Override
            public void accept(ArrayList arrayList, Throwable throwable) {
                System.out.println("33333" + Thread.currentThread().getName());
                arrayList.add(3);
            }
        });
        System.out.println(completableFuture.get());

        // 0000ForkJoinPool.commonPool-worker-9
        // 1111ForkJoinPool.commonPool-worker-9
        // 2222ForkJoinPool.commonPool-worker-9
        // 33333ForkJoinPool.commonPool-worker-9
        // [1, 2, 3]
    }
}