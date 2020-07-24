package com.xuegao.multi_thread2.atomic.completablefuture;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.completablefuture
 * <br/> @ClassName：test3
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/7/22 20:06
 */
public class test3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<HashMap> completableFuture = CompletableFuture.supplyAsync(new Supplier<HashMap>() {
            @Override
            public HashMap get() {
                return new HashMap();
            }
        }).whenComplete(new BiConsumer<HashMap, Throwable>() {
            @Override
            public void accept(HashMap hashMap, Throwable throwable) {
                hashMap.put("key1", "value1");
            }
        });
        System.out.println(completableFuture.get());
    }
}