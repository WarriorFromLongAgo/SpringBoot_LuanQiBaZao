package com.xuegao.multi_thread2.juc.completablefuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.completablefuture
 * <br/> @ClassName：thenRunAsync1
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/9/4 11:40
 */
public class thenRunAsync1 {
    private final static Logger log = LoggerFactory.getLogger(thenRunAsync1.class);

    public static void main(String[] args) {
        thenRunAsync2();
    }

    private static void thenRunAsync3() {
        List<CompletableFuture> completableFutureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            completableFutureList.add(CompletableFuture.runAsync(new Runnable() {
                @Override
                public void run() {
                    log.info(String.valueOf(finalI));
                }
            }));
        }
    }

    private static void thenRunAsync2() {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            CompletableFuture.runAsync(new Runnable() {
                @Override
                public void run() {
                    log.info(String.valueOf(finalI));
                }
            });
        }
    }

    private static void thenRunAsync1() {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        completableFuture.thenRunAsync(new Runnable() {
            @Override
            public void run() {
                log.info("111");
            }
        });
        completableFuture.thenRunAsync(new Runnable() {
            @Override
            public void run() {
                log.info("222");
            }
        });
        completableFuture.thenRunAsync(new Runnable() {
            @Override
            public void run() {
                log.info("333");
            }
        });
        Integer join = completableFuture.join();
        System.out.println(join);
    }
}