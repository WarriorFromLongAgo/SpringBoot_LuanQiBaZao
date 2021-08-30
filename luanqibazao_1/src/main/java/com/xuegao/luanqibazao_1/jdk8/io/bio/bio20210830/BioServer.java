package com.xuegao.luanqibazao_1.jdk8.io.bio.bio20210830;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.io.bio.bio20210830
 * <br/> @ClassName：BioServer
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/8/30 23:07
 */
public class BioServer {

    public static void main(String[] args) throws Exception {
        //1. 创建一个线程池
        ExecutorService newCachedThreadPool = new ThreadPoolExecutor(0,
                Integer.MAX_VALUE,
                60L,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        //2、创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器启动了");
        while (true) {
            System.out.println("线程信息id = " + Thread.currentThread().getId() + "名字 = " + Thread.currentThread().getName());
            //监听，等待客户端连接
            System.out.println("等待连接....");
            //3.侦听要与此套接字建立的连接并接受它。 该方法阻塞，直到建立连接。
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            //4、就创建一个线程，与之通讯(单独写一个方法)
            newCachedThreadPool.execute(() -> {
                //可以和客户端通讯
                handler(socket);
            });
        }
    }

    /**
     * 编写一个handler方法，和客户端通讯，读取客户端发过来的信息
     *
     * @param socket
     */
    public static void handler(Socket socket) {
        try {
            System.out.println("线程信息id = " + Thread.currentThread().getId() + "名字 = " + Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            //通过socket获取输入流
            InputStream inputStream = socket.getInputStream();
            //循环的读取客户端发送的数据
            while (true) {
                System.out.println("线程信息id = " + Thread.currentThread().getId() + "名字 = " + Thread.currentThread().getName());
                System.out.println("read....");
                int read = inputStream.read(bytes);
                if (read != -1) {
                    //输出客户端发送的数据
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭和client的连接");
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 打开cmd命令输入telnet localhost 8888




}