package com.xuegao.multi_thread2.java代码模拟并发;

import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.java代码模拟并发
 * <br/> @ClassName：CompletableFutureTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/02/25 19:31
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException, ExecutionException {
        init();
        long begin = System.currentTimeMillis();
        List<CompletableFuture> futures = new ArrayList();
        for (int i = 0; i < 1000; i++) {
            futures.add(CompletableFuture.runAsync(CompletableFutureTest::send3));
        }
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        Void aVoid = voidCompletableFuture.get();
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
        CompletableFutureTest.sout();
    }

    private static void init() {
        final String uri = "http://localhost:11112/product/init";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(uri, String.class);
    }

    private static void sout() {
        final String uri = "http://localhost:11112/product/sout";
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(uri, String.class);
        System.out.println(forObject);
    }

    private static void send3() {
        final String uri = "http://localhost:11112/product/decr";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(uri, String.class);
    }
}