package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.completablefuture
 * <br/> @ClassName：test3
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/7/22 20:06
 */
public class whenComplete3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<HashMap<String, String>> completableFuture = CompletableFuture.supplyAsync(new Supplier<HashMap<String, String>>() {
            @Override
            public HashMap<String, String> get() {
                return new HashMap<String, String>();
            }
        }).whenComplete(new BiConsumer<HashMap<String, String>, Throwable>() {
            @Override
            public void accept(HashMap<String, String> hashMap, Throwable throwable) {
                hashMap.put("key1", "value1");
            }
        });
        System.out.println(completableFuture.get());
    }
}