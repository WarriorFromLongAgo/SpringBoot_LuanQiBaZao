package com.xuegao.luanqibazao_1.jdk8.io.aio2;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.io.aio2
 * <br/> @ClassName：AioAcceptHandler
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/03/02 16:05
 */
public class AioServerAcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AioServerHandler> {

    @Override
    public void completed(AsynchronousSocketChannel channel, AioServerHandler serverHandler) {
        //继续接受其他客户端的请求
        AioServer.clientCount++;
        System.out.println("连接的客户端数：" + AioServer.clientCount);
        serverHandler.channel.accept(serverHandler, this);
        //创建新的Buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //异步读  第三个参数为接收消息回调的业务Handler
        channel.read(buffer, buffer, new AioServerReadHandler(channel));
    }

    @Override
    public void failed(Throwable exc, AioServerHandler serverHandler) {
        exc.printStackTrace();
        serverHandler.latch.countDown();
    }
// ————————————————
//     版权声明：本文为CSDN博主「anxpp」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//     原文链接：https://blog.csdn.net/anxpp/article/details/51512200
}