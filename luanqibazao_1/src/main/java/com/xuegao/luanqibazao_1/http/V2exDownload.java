package com.xuegao.luanqibazao_1.http;

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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class V2exDownload {
    private final static Logger log = LoggerFactory.getLogger(V2exDownload.class);
    static Map<String, String> map = imageUrlMap();
    private final static AtomicLong ATOMIC_LONG = new AtomicLong();

    public static void main(String[] args) throws IOException, InterruptedException {
        long startTime = System.currentTimeMillis();
        dsync();
        long endTime = System.currentTimeMillis();
        System.out.println(" spend time = " + (endTime - startTime));

        System.out.println("map size = " + map.size());
        download("https://pics4.baidu.com/feed/a8ec8a13632762d0eee0ae3c3a0e32fd533dc644.png?token=800e7344bb9f69c7aa7e4546b514e53d");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("========================================================================================");
        System.out.println("========================================================================================");
        System.out.println("========================================================================================");
        startTime = System.currentTimeMillis();
        dasync();
        endTime = System.currentTimeMillis();
        System.out.println("spend time = " + (endTime - startTime));
    }

    private static void dsync() throws IOException {
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            String value = stringStringEntry.getValue();
            download(value);
        }
    }

    private static void dasync() {
        try {
            List<CompletableFuture<?>> futureList = new ArrayList<>();
            for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
                String imageUrl = stringStringEntry.getValue();
                CompletableFuture<Long> longCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    Long downloadTime = null;
                    try {
                        downloadTime = download(imageUrl);
                        log.info(" downloadTime = {}", downloadTime);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return downloadTime;
                }).exceptionally(throwable -> {
                    log.error(throwable.getMessage());
                    return 0L;
                });
                futureList.add(longCompletableFuture);
            }
            CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log.info(" picture num longAdder ");
        }
    }

    public static Map<String, String> imageUrlMap() {
        Map<String, String> imageUrlMap = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            imageUrlMap.put(Integer.toString(i), "https://img-blog.csdn.net/20180823221048359?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zOTc3ODU3MA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70");
        }
        return imageUrlMap;
    }

    private static Long download(String imgUrl) throws IOException {
        long i = ATOMIC_LONG.incrementAndGet();
        String path = "D:\\nfsc\\KMS\\train.homework\\";
        URLConnection urlConnection = new URL(imgUrl).openConnection();
        try (ReadableByteChannel readableByteChannel = Channels.newChannel(urlConnection.getInputStream());
             FileChannel outputChannel = new FileOutputStream(
                     new File(path + i + ".jpg")).getChannel()) {
            outputChannel.transferFrom(readableByteChannel, 0, urlConnection.getContentLength());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }
}