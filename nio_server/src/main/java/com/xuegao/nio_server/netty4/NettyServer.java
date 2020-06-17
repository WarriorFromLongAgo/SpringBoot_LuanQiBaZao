package com.xuegao.nio_server.netty4;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

public class NettyServer {

    private final Logger log = LoggerFactory.getLogger(NettyServer.class);

    public void start(InetSocketAddress socketAddress) {
        //new 一个主线程组    创建EventLoopGroup，处理事件
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //new 一个工作线程组   创建EventLoopGroup，处理事件
        EventLoopGroup workGroup = new NioEventLoopGroup(200);
        ServerBootstrap bootstrap = new ServerBootstrap()
                .group(bossGroup, workGroup)
                // 指定所使用的NIO传输 Channel
                .channel(NioServerSocketChannel.class)
                // 添加一个EchoServerHandler到子Channel的ChannelPipeline
                .childHandler(new ServerChannelInitializer())
                // 使用指定的端口设置套接字地址
                .localAddress(socketAddress)
                // 设置队列大小
                .option(ChannelOption.SO_BACKLOG, 1024)
                // 两小时内没有数据的通信时,TCP会自动发送一个活动探测数据报文
                .childOption(ChannelOption.SO_KEEPALIVE, true);
        //绑定端口,开始接收进来的连接
        try {
            // 异步的绑定服务器，调用sync()方法阻塞等待直到绑定完成
            ChannelFuture future = bootstrap.bind(socketAddress).sync();
            log.info("服务器启动开始监听端口: {}", socketAddress.getPort());
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 关闭EventLoopGroup,释放所有的资源
            //关闭主线程组
            bossGroup.shutdownGracefully();
            //关闭工作线程组
            workGroup.shutdownGracefully();
        }
    }
}