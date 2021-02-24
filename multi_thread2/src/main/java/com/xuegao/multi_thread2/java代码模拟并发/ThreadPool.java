package com.xuegao.multi_thread2.java代码模拟并发;

import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.java代码模拟并发
 * <br/> @ClassName：ThreadPool
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/02/24 18:38
 */
public class ThreadPool {
    public static void main(String[] args) throws MalformedURLException {

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                5,
                10,
                10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                r -> {
                    Thread thread = new Thread(r);
                    thread.setName("ThreadPool");
                    return thread;
                });

        long begin = System.currentTimeMillis();
        for (int i = 0; i < 545605506; i++) {
            threadPool.execute(ThreadPool::send2);
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
        threadPool.shutdown();
    }

    private static void send2() {
        final String uri = "http://localhost:12000/index/234243";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

    }

    private static void send() {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;// 返回结果字符串
        try {
            // 创建远程url连接对象
            URL url = new URL("http://localhost:12000/index/234243");

            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接方式：get
            connection.setRequestMethod("GET");
            // 设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(15000);

            // 设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(60000);
            // 发送请求
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            connection.disconnect();// 关闭远程连接
        }
    }
}