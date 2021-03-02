package com.xuegao.luanqibazao_1.jdk8.io.aio2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.io.aio2
 * <br/> @ClassName：AioAsyncServerHandler
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/03/02 16:05
 */
public class AioServerHandler implements Runnable {
    public CountDownLatch latch;
    public AsynchronousServerSocketChannel channel;

    public AioServerHandler(int port) {
        try {
            //创建服务端通道
            channel = AsynchronousServerSocketChannel.open();
            //绑定端口
            channel.bind(new InetSocketAddress(port));
            System.out.println("服务器已启动，端口号：" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //CountDownLatch初始化
        //它的作用：在完成一组正在执行的操作之前，允许当前的现场一直阻塞
        //此处，让现场在此阻塞，防止服务端执行完成后退出
        //也可以使用while(true)+sleep
        //生成环境就不需要担心这个问题，以为服务端是不会退出的
        latch = new CountDownLatch(1);
        //用于接收客户端的连接
        channel.accept(this, new AioServerAcceptHandler());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
// ————————————————
//     版权声明：本文为CSDN博主「anxpp」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//     原文链接：https://blog.csdn.net/anxpp/article/details/51512200
}