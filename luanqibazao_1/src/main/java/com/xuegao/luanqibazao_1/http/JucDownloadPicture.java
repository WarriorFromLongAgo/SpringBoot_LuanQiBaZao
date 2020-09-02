package com.xuegao.luanqibazao_1.http;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.*;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.http
 * <br/> @ClassName：JucDownloadPicture
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/9/2 10:55
 */
public class JucDownloadPicture {
    private final static Logger log = LoggerFactory.getLogger(JucDownloadPicture.class);

    public static void main(String[] args) {
        String json = "{\"22\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/22.jpg\",\"23\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/23.jpg\",\"24\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/24.jpg\",\"25\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/25.jpg\",\"10\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/10.jpg\",\"11\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/11.jpg\",\"12\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/12.jpg\",\"13\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/13.jpg\",\"14\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/14.jpg\",\"15\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/15.jpg\",\"16\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/16.jpg\",\"17\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/17.jpg\",\"18\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/18.jpg\",\"19\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/19.jpg\",\"0\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/0.jpg\",\"1\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/1.jpg\",\"2\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/2.jpg\",\"3\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/3.jpg\",\"4\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/4.jpg\",\"5\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/5.jpg\",\"6\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/6.jpg\",\"7\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/7.jpg\",\"8\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/8.jpg\",\"9\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/9.jpg\",\"20\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/20.jpg\",\"21\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/21.jpg\"}\n";
        Map<String, String> map = JSONObject.parseObject(json, new TypeReference<Map<String, String>>() {
        });
        System.out.println(map);

        long startTime = System.currentTimeMillis();
        download(map);
        long endTime = System.currentTimeMillis();
        System.out.println("总共耗时 = " + (endTime - startTime));

        System.out.println("========================================================================================");
        System.out.println("========================================================================================");
        System.out.println("========================================================================================");
        startTime = System.currentTimeMillis();
        download2(map);
        endTime = System.currentTimeMillis();
        System.out.println("总共耗时 = " + (endTime - startTime));
    }

    private static void download(Map<String, String> map) {
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            String value = stringStringEntry.getValue();
            DownloadPicture3.download(value);
        }
    }

    private static void download2(Map<String, String> map) {
        ThreadPoolExecutor threadPoolExecutor = null;
        try {
            threadPoolExecutor = new ThreadPoolExecutor(2, 4, 30, TimeUnit.SECONDS,
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
                        DownloadPicture3.download(value);
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
}