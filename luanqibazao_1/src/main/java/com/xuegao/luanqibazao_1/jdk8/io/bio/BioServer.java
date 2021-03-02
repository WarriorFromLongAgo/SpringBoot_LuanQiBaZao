package com.xuegao.luanqibazao_1.jdk8.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BioServer {
    public static void main(String[] args) throws IOException {
        //创建一个线程池
        //如果有客户端与之连接 就创建一个线程与之通讯
        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了");
        while (true) {
            System.out.println("等待连接");
            //监听 等待客户端连接
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            //创建一个线程与之通讯
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    handler(socket);
                }
            });

        }
    }

    //编写一个方法 和客户端通信
    public static void handler(Socket socket) {
        //接收数据
        byte[] bytes = new byte[1024];
        //通过socket获取输入流
        try {
            System.out.println("id" + Thread.currentThread().getId() + "名字" + Thread.currentThread().getName());
            System.out.println("read...");
            InputStream inputStream = socket.getInputStream();
            while (true) {
                System.out.println("id" + Thread.currentThread().getId() + "名字" + Thread.currentThread().getName());
                int read = inputStream.read(bytes);
                //输出传输的数据
                if (read != -1) {
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭和client的连接");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}