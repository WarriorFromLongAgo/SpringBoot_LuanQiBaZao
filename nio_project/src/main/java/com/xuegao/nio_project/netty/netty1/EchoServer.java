package com.xuegao.nio_project.netty.netty1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * <br/> @PackageName：com.xuegao.nio_project.netty
 * <br/> @ClassName：
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/16 17:45
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    // public static void main(String[] args) throws InterruptedException {
    //     new EchoServer(8888).start();
    // }
    //
    // public void start() throws InterruptedException {
    //     final EchoServerHandler serverHandler = new EchoServerHandler();
    //     //创建EventLoopGroup，处理事件
    //     EventLoopGroup boss = new NioEventLoopGroup();
    //     EventLoopGroup worker = new NioEventLoopGroup();
    //     try {
    //         ServerBootstrap b = new ServerBootstrap();
    //         b.group(boss, worker)
    //                 //指定所使用的NIO传输 Channel
    //                 .channel(NioServerSocketChannel.class)
    //                 //使用指定的端口设置套接字地址
    //                 .localAddress(new InetSocketAddress(port))
    //                 //添加一个EchoServerHandler到子Channel的ChannelPipeline
    //                 .childHandler(new ChannelInitializer<SocketChannel>() {
    //                     @Override
    //                     protected void initChannel(SocketChannel socketChannel) throws Exception {
    //                         //EchoServerHandler标志为@Shareable,所以我们可以总是使用同样的实例
    //                         socketChannel.pipeline().addLast(serverHandler);
    //                     }
    //                 });
    //         //异步的绑定服务器，调用sync()方法阻塞等待直到绑定完成
    //         ChannelFuture future = b.bind().sync();
    //         future.channel().closeFuture().sync();
    //     } finally {
    //         //关闭EventLoopGroup,释放所有的资源
    //         group.shutdownGracefully().sync();
    //         worker.shutdownGracefully().sync();
    //     }
    // }
}