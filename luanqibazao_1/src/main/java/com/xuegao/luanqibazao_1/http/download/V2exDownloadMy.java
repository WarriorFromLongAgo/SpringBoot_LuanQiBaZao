package com.xuegao.luanqibazao_1.http.download;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

public class V2exDownloadMy {
    private final static Logger log = LoggerFactory.getLogger(V2exDownloadMy.class);
    private final static AtomicLong ATOMIC_LONG = new AtomicLong();

    public static void main(String[] args) throws IOException, InterruptedException {

        Map<String, String> map = imageUrlMap();

        long startTime = System.currentTimeMillis();
        download(map);
        long endTime = System.currentTimeMillis();
        System.out.println(" spend time = " + (endTime - startTime));

        download("https://pics4.baidu.com/feed/a8ec8a13632762d0eee0ae3c3a0e32fd533dc644.png?token=800e7344bb9f69c7aa7e4546b514e53d");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("map size = " + map.size());
        System.out.println("========================================================================================");
        System.out.println("========================================================================================");
        System.out.println("========================================================================================");
        startTime = System.currentTimeMillis();
        downloadCompletableFuture2(map);
        endTime = System.currentTimeMillis();
        System.out.println("spend time = " + (endTime - startTime));

        // TimeUnit.SECONDS.sleep(3);
        // System.out.println("map size = " + map.size());
        // DownloadPicture3.download("https://pics4.baidu.com/feed/a8ec8a13632762d0eee0ae3c3a0e32fd533dc644.png?token=800e7344bb9f69c7aa7e4546b514e53d");
        // System.out.println("========================================================================================");
        // System.out.println("========================================================================================");
        // System.out.println("========================================================================================");
        // startTime = System.currentTimeMillis();
        // downloadCompletableFuture2(map);
        // endTime = System.currentTimeMillis();
        // System.out.println("spend time = " + (endTime - startTime));

    }

    /**
     * </br> @Title: 单线程下载图片
     * </br> @MethodName: download
     * </br> @param map:
     * </br> @Return void
     * </br> @Description:
     * </br> @author: xuegao
     * </br> @date: 2020/9/6 1:02
     */
    private static void download(Map<String, String> map) throws IOException {
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            String value = stringStringEntry.getValue();
            download(value);
        }
    }

    /**
     * </br> @Title: CompletableFuture 下载图片
     * </br> @MethodName: downloadCompletableFuture2
     * </br> @param map:
     * </br> @Return void
     * </br> @Description:
     * </br> @author: xuegao
     * </br> @date: 2020/9/6 1:01
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

    /**
     * </br> @Title: 提供图片 map
     * </br> @MethodName: imageUrlMap
     * </br>
     * </br> @Return java.util.Map<java.lang.String,java.lang.String>
     * </br> @Description:
     * </br> @author: xuegao
     * </br> @date: 2020/9/6 1:01
     */
    public static Map<String, String> imageUrlMap() {
        Map<String, String> imageUrlMap = new HashMap<>();
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