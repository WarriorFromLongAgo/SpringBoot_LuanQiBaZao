package com.xuegao.luanqibazao_1.jdk8.io.aio2;

import java.util.Scanner;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.io.aio2
 * <br/> @ClassName：AioClient
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/03/02 16:05
 */
public class AioClient {
    private static String DEFAULT_HOST = "127.0.0.1";
    private static int DEFAULT_PORT = 12345;
    private static AioClientHandler clientHandle;

    public static void start() {
        start(DEFAULT_HOST, DEFAULT_PORT);
    }

    public static synchronized void start(String ip, int port) {
        if (clientHandle != null) {
            return;
        }
        clientHandle = new AioClientHandler(ip, port);
        new Thread(clientHandle, "Client").start();
    }

    //向服务器发送消息
    public static boolean sendMsg(String msg) throws Exception {
        if (msg.equals("q")) {
            return false;
        }
        clientHandle.sendMsg(msg);
        return true;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        AioClient.start();
        System.out.println("请输入请求消息：");
        Scanner scanner = new Scanner(System.in);
        while (AioClient.sendMsg(scanner.nextLine())) ;
    }
// ————————————————
//     版权声明：本文为CSDN博主「anxpp」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//     原文链接：https://blog.csdn.net/anxpp/article/details/51512200
}