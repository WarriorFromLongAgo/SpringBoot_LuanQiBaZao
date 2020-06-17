package com.xuegao.nio_server.netty2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * <br/> @PackageName：com.xuegao.nio_server.netty2
 * <br/> @ClassName：
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/17 10:23
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoServer(8888).start();
    }

    public void start() throws InterruptedException {
        final EchoServerHandler serverHandler = new EchoServerHandler();
        // 创建EventLoopGroup，处理事件
        // EventLoopGroup是处理I/O操作的线程池，用来分配 服务于Channel的I/O和事件的 EventLoop
        // NioEventLoopGroup是EventLoopGroup的一个实现类

        // 这里实例化了两个 NioEventLoopGroup，一个 boss,主要用于处理客户端连接，一个 worker用于处理客户端的数据读写工作
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            // ServerBootStrap是引导类，帮助服务启动的辅助类，可以设置 Socket参数
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boss, worker)
                    // 指定所使用的NIO传输 Channel
                    .channel(NioServerSocketChannel.class)
                    // 使用指定的端口设置套接字地址
                    // .localAddress(new InetSocketAddress(port))
                    // .option(ChannelOption.SO_BACKLOG, 100)
                    // .handler(new LoggingHandler(LogLevel.INFO))
                    // 添加一个EchoServerHandler到子Channel的ChannelPipeline
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //EchoServerHandler标志为@Shareable,所以我们可以总是使用同样的实例
                            socketChannel.pipeline().addLast(serverHandler);
                        }
                    });
            // 异步的绑定服务器，调用sync()方法阻塞等待直到绑定完成
            // 通过调用ServerBootStrap.bind()方法以绑定服务器
            ChannelFuture future = serverBootstrap.bind(port).sync();
            future.channel().closeFuture().sync();
        } finally {
            //关闭EventLoopGroup,释放所有的资源
            // boss.shutdownGracefully().sync();
            // worker.shutdownGracefully().sync();
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}