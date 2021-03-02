package com.xuegao.luanqibazao_1.jdk8.io.nio;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.io.nio
 * <br/> @ClassName：NioTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/03/01 20:25
 */

 // 打开ServerSocketChannel，监听客户端连接
 // 绑定监听端口，设置连接为非阻塞模式
 // 创建Reactor线程，创建多路复用器并启动线程
 // 将ServerSocketChannel注册到Reactor线程中的Selector上，监听ACCEPT事件
 // Selector轮询准备就绪的key
 // Selector监听到新的客户端接入，处理新的接入请求，完成TCP三次握手，简历物理链路
 // 设置客户端链路为非阻塞模式
 // 将新接入的客户端连接注册到Reactor线程的Selector上，监听读操作，读取客户端发送的网络消息
 // 异步读取客户端消息到缓冲区
 // 对Buffer编解码，处理半包消息，将解码成功的消息封装成Task
 // 将应答消息编码为Buffer，调用SocketChannel的write将消息异步发送给客户端

public class NioServer {
    private static final int DEFAULT_PORT = 12345;
    private static NioServerHandle nioServerHandle;

    public static void start() {
        start(DEFAULT_PORT);
    }

    public static synchronized void start(int port) {
        if (nioServerHandle != null) {
            nioServerHandle.stop();
        }
        nioServerHandle = new NioServerHandle(port);
        new Thread(nioServerHandle, "Server").start();
    }

    public static void main(String[] args) {
        start();
    }
// ————————————————
//     版权声明：本文为CSDN博主「anxpp」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//     原文链接：https://blog.csdn.net/anxpp/article/details/51512200
}