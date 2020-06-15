package com.xuegao.xianliu_demo;

import com.xuegao.xianliu_demo.controller.LimitController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.xianliu_demo
 * <br/> @ClassName：
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/15 14:46
 */
public class LimitControllerTest {
    // 接下来我们写一个类，十个线程并发访问上面写的controller：
    private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);

    private static String sendGet(URL realUrl) {
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try {
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();

            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result.toString();
    }


    public void access() throws Exception {
        final URL url = new URL("http://localhost:8080/access");

        for (int i = 0; i < 10; i++) {
            fixedThreadPool.submit(new Runnable() {
                public void run() {
                    System.out.println(sendGet(url));
                }
            });
        }

        fixedThreadPool.shutdown();
        fixedThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        LimitController limitController = new LimitController();
        limitController.access();
    }
// ————————————————
//     版权声明：本文为CSDN博主「程序员欣宸」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//     原文链接：https://blog.csdn.net/boling_cavalry/article/details/75174486
}