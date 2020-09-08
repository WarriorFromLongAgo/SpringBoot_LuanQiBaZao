package com.xuegao.luanqibazao_1.http;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
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
    private final static AtomicLong ATOMIC_LONG = new AtomicLong();

    public static void main(String[] args) throws InterruptedException, IOException {
        String json = "{\"22\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/22.jpg\",\"23\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/23.jpg\",\"24\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/24.jpg\",\"25\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/25.jpg\",\"27\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/27.jpg\",\"28\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/28.jpg\",\"29\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/29.jpg\",\"10\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/10.jpg\",\"11\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/11.jpg\",\"12\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/12.jpg\",\"13\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/13.jpg\",\"14\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/14.jpg\",\"15\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/15.jpg\",\"16\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/16.jpg\",\"17\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/17.jpg\",\"18\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/18.jpg\",\"19\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/19.jpg\",\"0\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/0.jpg\",\"1\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/1.jpg\",\"2\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/2.jpg\",\"3\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/3.jpg\",\"4\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/4.jpg\",\"5\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/5.jpg\",\"6\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/6.jpg\",\"7\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/7.jpg\",\"8\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/8.jpg\",\"9\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/9.jpg\",\"20\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/20.jpg\",\"21\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/21.jpg\"}\n";
        Map<String, String> map = JSONObject.parseObject(json, new TypeReference<Map<String, String>>() {
        });
        System.out.println(map);
        System.out.println(map.size());

        // 外网下载图片
        map = imageUrlMap();

        long startTime = System.currentTimeMillis();
        download(map);
        long endTime = System.currentTimeMillis();
        System.out.println(" spend time = " + (endTime - startTime));

        System.out.println("map size = " + map.size());
        download("https://pics4.baidu.com/feed/a8ec8a13632762d0eee0ae3c3a0e32fd533dc644.png?token=800e7344bb9f69c7aa7e4546b514e53d");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("========================================================================================");
        System.out.println("========================================================================================");
        System.out.println("========================================================================================");
        startTime = System.currentTimeMillis();
        downloadThreadPoolExecutor(map);
        endTime = System.currentTimeMillis();
        System.out.println("总共耗时 = " + (endTime - startTime));

        System.out.println("map size = " + map.size());
        TimeUnit.SECONDS.sleep(10);
        download("https://pics4.baidu.com/feed/a8ec8a13632762d0eee0ae3c3a0e32fd533dc644.png?token=800e7344bb9f69c7aa7e4546b514e53d");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("========================================================================================");
        System.out.println("========================================================================================");
        System.out.println("========================================================================================");
        startTime = System.currentTimeMillis();
        downloadCompletableFuture2(map);
        endTime = System.currentTimeMillis();
        System.out.println("spend time = " + (endTime - startTime));

    }

    /**
     * <br/> @Title: 单线程下载
     * <br/> @MethodName:  download
     * <br/> @param map:
     * <br/> @Return void
     * <br/> @Description:
     * <br/> @author: 80004960
     * <br/> @date:  2020/9/7 10:00
     */
    private static void download(Map<String, String> map) throws IOException {
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            String value = stringStringEntry.getValue();
            download(value);
        }
    }

    /**
     * <br/> @Title: 线程池多线程下载
     * <br/> @MethodName:  downloadThreadPoolExecutor
     * <br/> @param map:
     * <br/> @Return void
     * <br/> @Description:
     * <br/> @author: 80004960
     * <br/> @date:  2020/9/7 9:59
     */
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
                        try {
                            log.info("下载所花时间 = " + download(value));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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

    /**
     * <br/> @Title: 不能使用，longAdder没有incrementAndGet，只能increment，longvalue
     * <br/> @MethodName:  downloadCompletableFuture
     * <br/> @param map:
     * <br/> @Return void
     * <br/> @Description:
     * <br/> @author: 80004960
     * <br/> @date:  2020/9/7 9:58
     */
    @Deprecated
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
                        try {
                            log.info("下载所花时间 = " + download(imageUrl));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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

    /**
     * <br/> @Title:
     * <br/> @MethodName:  downloadCompletableFuture2
     * <br/> @param map:
     * <br/> @Return void
     * <br/> @Description:
     * <br/> @author: 80004960
     * <br/> @date:  2020/9/8 19:10
     */
    private static void downloadCompletableFuture2(Map<String, String> map) {
        try {
            List<CompletableFuture<?>> futureList = new ArrayList<>();
            for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
                // image Url
                String imageUrl = stringStringEntry.getValue();
                CompletableFuture<Long> longCompletableFuture = CompletableFuture.supplyAsync(new Supplier<Long>() {
                    @Override
                    public Long get() {
                        Long downloadTime = null;
                        try {
                            downloadTime = download(imageUrl);
                            log.info(" downloadTime = {} ", downloadTime);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return downloadTime;
                    }
                }).exceptionally(throwable -> {
                    log.error(throwable.getMessage());
                    return 0L;
                });
                futureList.add(longCompletableFuture);
            }
            // Wait for them all to complete.
            CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log.info(" picture num longAdder ");
            // 11:27:37.442 [main] INFO com.ice.http.JucDownloadPicture
        }
    }

    static <V> CompletableFuture<Collection<V>> allOf(Collection<CompletableFuture<V>> futures) {
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));
    }

    /**
     * <br/> @Title: 外网提供图片
     * <br/> @MethodName:  imageUrlMap
     * <br/>
     * <br/> @Return java.util.Map<java.lang.String,java.lang.String>
     * <br/> @Description:
     * <br/> @author: 80004960
     * <br/> @date:  2020/9/7 10:01
     */
    public static Map<String, String> imageUrlMap() {
        Map<String, String> imageUrlMap = new HashMap<>(32);
        for (int i = 0; i < 20; i++) {
            imageUrlMap.put(Integer.toString(i), "https://img-blog.csdn.net/20180823221048359?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zOTc3ODU3MA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70");
        }
        return imageUrlMap;
    }

    /**
     * </br> @Title: 下载图片
     * </br> @MethodName: download
     * </br> @param imgUrl:
     * </br> @Return java.lang.Long
     * </br> @Description:
     * </br> @author: xuegao
     * </br> @date: 2020/9/6 1:01
     */
    private static Long download(String imgUrl) throws IOException {
        URLConnection urlConnection = new URL(imgUrl).openConnection();
        long l = ATOMIC_LONG.incrementAndGet();
        try (ReadableByteChannel readableByteChannel = Channels.newChannel(urlConnection.getInputStream());
             FileChannel outputChannel = new FileOutputStream(
                     new File("D:\\nfsc\\KMS\\train.homework\\" + l + ".jpg")).getChannel()) {
            outputChannel.transferFrom(readableByteChannel, 0, urlConnection.getContentLength());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return l;
    }
}