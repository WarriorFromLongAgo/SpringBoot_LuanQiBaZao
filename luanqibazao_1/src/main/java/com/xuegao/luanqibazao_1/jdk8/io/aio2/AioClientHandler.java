package com.xuegao.luanqibazao_1.jdk8.io.aio2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.io.aio2
 * <br/> @ClassName：AioAsyncClientHandler
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/03/02 16:06
 */
public class AioClientHandler implements CompletionHandler<Void, AioClientHandler>, Runnable {

    private AsynchronousSocketChannel clientChannel;
    private String host;
    private int port;
    private CountDownLatch latch;
    public AioClientHandler(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            //创建异步的客户端通道
            clientChannel = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        //创建CountDownLatch等待
        latch = new CountDownLatch(1);
        //发起异步连接操作，回调参数就是这个类本身，如果连接成功会回调completed方法
        clientChannel.connect(new InetSocketAddress(host, port), this, this);
        try {
            latch.await();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        try {
            clientChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //连接服务器成功
    //意味着TCP三次握手完成
    @Override
    public void completed(Void result, AioClientHandler attachment) {
        System.out.println("客户端成功连接到服务器...");
    }
    //连接服务器失败
    @Override
    public void failed(Throwable exc, AioClientHandler attachment) {
        System.err.println("连接服务器失败...");
        exc.printStackTrace();
        try {
            clientChannel.close();
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //向服务器发送消息
    public void sendMsg(String msg){
        byte[] req = msg.getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
        writeBuffer.put(req);
        writeBuffer.flip();
        //异步写
        clientChannel.write(writeBuffer, writeBuffer,new AioClientWriteHandler(clientChannel, latch));
    }
// ————————————————
//     版权声明：本文为CSDN博主「anxpp」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//     原文链接：https://blog.csdn.net/anxpp/article/details/51512200
}