package com.xuegao.multi_thread2.java代码模拟并发;

import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.java代码模拟并发
 * <br/> @ClassName：ThreadPool
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/02/24 18:38
 */
public class ThreadPool {
    public static void main(String[] args) throws MalformedURLException, InterruptedException, ExecutionException {
        init();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                10,
                50,
                10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                r -> {
                    Thread thread = new Thread(r);
                    thread.setName("ThreadPool");
                    return thread;
                });
        List<Future<String>> futures = new ArrayList<>();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            futures.add(threadPool.submit(ThreadPool::send3));
        }
        long end = System.currentTimeMillis();

        List<String> str = new ArrayList<>();
        for (Future<String> future : futures) {
            str.add(future.get());
        }

        System.out.println(end - begin);

        while (str.size() < 1000) {
            TimeUnit.SECONDS.sleep(1);
        }
        ThreadPool.sout();
        threadPool.shutdown();
    }

    private static void init() {
        final String uri = "http://localhost:11112/product/init";
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(uri, String.class);
    }

    private static void sout() {
        final String uri = "http://localhost:11112/product/sout";
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(uri, String.class);
        System.out.println(forObject);
    }

    private static String send3() {
        final String uri = "http://localhost:11112/product/decr";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }

    private static void send2() {
        final String uri = "http://localhost:12000/index/234243";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(uri, String.class);
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