package com.xuegao.multi_thread2.juc.completablefuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.completablefuture
 * <br/> @ClassName：test10
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/7/22 20:42
 */
public class allOf3 {
    private final static Logger log = LoggerFactory.getLogger(allOf3.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                try {
                    log.info(" 111111111111111111 ");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 1;
            }
        });
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                log.info(" 22222222222222222 ");
                return 2;
            }
        });
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFuture1, completableFuture2);
        String startTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("waiting all task finish.." + startTime);
        System.out.println(voidCompletableFuture.get());
        String endTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("all task finish.." + endTime);

        // 14:38:42.432 [ForkJoinPool.commonPool-worker-2] INFO com.xuegao.multi_thread2.juc.completablefuture.allOf3 -  22222222222222222
        // 14:38:42.432 [ForkJoinPool.commonPool-worker-9] INFO com.xuegao.multi_thread2.juc.completablefuture.allOf3 -  111111111111111111
        // waiting all task finish..2020-09-14 14:38:42
        // null
        // all task finish..2020-09-14 14:38:44
    }
}