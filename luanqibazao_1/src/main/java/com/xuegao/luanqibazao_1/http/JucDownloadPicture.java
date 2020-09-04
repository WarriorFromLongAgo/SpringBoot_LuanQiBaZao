package com.xuegao.luanqibazao_1.http;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.http
 * <br/> @ClassName：JucDownloadPicture
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/9/2 10:55
 */
public class JucDownloadPicture {
    private final static Logger log = LoggerFactory.getLogger(JucDownloadPicture.class);

    public static void main(String[] args) throws InterruptedException {
        String json = "{\"22\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/22.jpg\",\"23\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/23.jpg\",\"24\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/24.jpg\",\"25\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/25.jpg\",\"27\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/27.jpg\",\"28\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/28.jpg\",\"29\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/29.jpg\",\"10\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/10.jpg\",\"11\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/11.jpg\",\"12\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/12.jpg\",\"13\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/13.jpg\",\"14\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/14.jpg\",\"15\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/15.jpg\",\"16\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/16.jpg\",\"17\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/17.jpg\",\"18\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/18.jpg\",\"19\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/19.jpg\",\"0\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/0.jpg\",\"1\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/1.jpg\",\"2\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/2.jpg\",\"3\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/3.jpg\",\"4\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/4.jpg\",\"5\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/5.jpg\",\"6\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/6.jpg\",\"7\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/7.jpg\",\"8\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/8.jpg\",\"9\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/9.jpg\",\"20\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/20.jpg\",\"21\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/21.jpg\"}\n";
        // String json = "{\"27\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/27.jpg\",\"28\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/28.jpg\",\"29\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/29.jpg\",\"10\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/10.jpg\",\"11\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/11.jpg\",\"12\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/12.jpg\",\"13\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/13.jpg\",\"14\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/14.jpg\",\"15\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/15.jpg\",\"16\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/16.jpg\",\"17\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/17.jpg\",\"18\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/18.jpg\",\"19\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/19.jpg\",\"0\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/0.jpg\",\"1\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/1.jpg\",\"2\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/2.jpg\",\"3\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/3.jpg\",\"4\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/4.jpg\",\"5\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/5.jpg\",\"6\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/6.jpg\",\"7\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/7.jpg\",\"8\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/8.jpg\",\"9\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/9.jpg\",\"20\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/20.jpg\",\"21\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/21.jpg\"}\n";
        Map<String, String> map = JSONObject.parseObject(json, new TypeReference<Map<String, String>>() {
        });
        System.out.println(map);
        System.out.println(map.size());

        long startTime = System.currentTimeMillis();
        download(map);
        long endTime = System.currentTimeMillis();
        System.out.println(" spend time = " + (endTime - startTime));

        // TimeUnit.SECONDS.sleep(3);
        // DownloadPicture3.download("https://pics4.baidu.com/feed/a8ec8a13632762d0eee0ae3c3a0e32fd533dc644.png?token=800e7344bb9f69c7aa7e4546b514e53d");
        // System.out.println("========================================================================================");
        // System.out.println("========================================================================================");
        // System.out.println("========================================================================================");
        // startTime = System.currentTimeMillis();
        // downloadThreadPoolExecutor(map);
        // endTime = System.currentTimeMillis();
        // System.out.println("总共耗时 = " + (endTime - startTime));

        // TimeUnit.SECONDS.sleep(3);
        // System.out.println("map size = " + map.size());
        // DownloadPicture3.download("https://pics4.baidu.com/feed/a8ec8a13632762d0eee0ae3c3a0e32fd533dc644.png?token=800e7344bb9f69c7aa7e4546b514e53d");
        // System.out.println("========================================================================================");
        // System.out.println("========================================================================================");
        // System.out.println("========================================================================================");
        // startTime = System.currentTimeMillis();
        // downloadCompletableFuture(map);
        // endTime = System.currentTimeMillis();
        // System.out.println("总共耗时 = " + (endTime - startTime));

        TimeUnit.SECONDS.sleep(3);
        System.out.println("map size = " + map.size());
        DownloadPicture3.download("https://pics4.baidu.com/feed/a8ec8a13632762d0eee0ae3c3a0e32fd533dc644.png?token=800e7344bb9f69c7aa7e4546b514e53d");
        System.out.println("========================================================================================");
        System.out.println("========================================================================================");
        System.out.println("========================================================================================");
        startTime = System.currentTimeMillis();
        downloadCompletableFuture2(map);
        endTime = System.currentTimeMillis();
        System.out.println("spend time = " + (endTime - startTime));

    }

    private static void download(Map<String, String> map) {
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            String value = stringStringEntry.getValue();
            DownloadPicture3.download(value);
        }
    }

    private static void downloadThreadPoolExecutor(Map<String, String> map) {
        ThreadPoolExecutor threadPoolExecutor = null;
        try {
            threadPoolExecutor = new ThreadPoolExecutor(2, 4, 50, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(), new ThreadFactory() {
                @Override
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("KMS");
                    return thread;
                }
            }
                    // , new RejectedExecutionHandler() {
                    //     @Override
                    //     public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    //         log.info("rejectedExecution");
                    //     }
                    // }
            );

            for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
                String value = stringStringEntry.getValue();
                threadPoolExecutor.submit(new Runnable() {
                    @Override
                    public void run() {
                        log.info("下载所花时间 = " + DownloadPicture3.download(value));
                    }
                });
            }
        } catch (Exception e) {
            log.error("download2 error {}", map, e);
            e.printStackTrace();
        } finally {
            if (threadPoolExecutor != null) {
                threadPoolExecutor.shutdown();
            }
        }
    }

    private static void downloadCompletableFuture(Map<String, String> map) {
        LongAdder longAdder = new LongAdder();
        try {
            List<CompletableFuture<Void>> futureList = new ArrayList<>();
            for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
                // image Url
                String imageUrl = stringStringEntry.getValue();
                CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
                    @Override
                    public void run() {
                        // download picture
                        longAdder.increment();
                        log.info("下载所花时间 = " + DownloadPicture3.download(imageUrl));
                    }
                });
                futureList.add(future);
            }
            CompletableFuture<Void> allDoneFuture = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
            allDoneFuture.get(200, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log.info("end longAdder = " + longAdder.toString());
            // 11:27:37.442 [main] INFO com.ice.http.JucDownloadPicture
        }
    }

    private static void downloadCompletableFuture2(Map<String, String> map) {
        LongAdder longAdder = new LongAdder();
        try {
            List<CompletableFuture<?>> futureList = new ArrayList<>();
            for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
                // image Url
                String imageUrl = stringStringEntry.getValue();
                CompletableFuture<Long> longCompletableFuture = CompletableFuture.supplyAsync(new Supplier<Long>() {
                    @Override
                    public Long get() {
                        longAdder.increment();
                        Long downloadTime = DownloadPicture3.download(imageUrl);
                        log.info(" downloadTime = " + downloadTime);
                        return downloadTime;
                    }
                });
                futureList.add(longCompletableFuture);
            }
            // Wait for them all to complete.
            CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).get();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log.info(" picture num longAdder = " + longAdder.toString());
            // 11:27:37.442 [main] INFO com.ice.http.JucDownloadPicture
        }
    }

    static <V> CompletableFuture<Collection<V>> allOf(Collection<CompletableFuture<V>> futures) {
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));
    }

}