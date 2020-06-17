package com.xuegao.nio_server.official_echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * <br/> @PackageName：com.xuegao.nio_server.official_echo
 * <br/> @ClassName：EchoServer
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/17 15:00
 */
public class EchoServer {

    private final Logger log = LoggerFactory.getLogger(getClass());

    static final boolean SSL = System.getProperty("ssl") != null;
    static final int PORT = Integer.parseInt(System.getProperty("port", "8007"));

    public static void main(String[] args) throws Exception {
        // Configure SSL.
        final SslContext sslContext;
        if (SSL) {
            SelfSignedCertificate selfSignedCertificate = new SelfSignedCertificate();
            sslContext = SslContextBuilder.forServer(selfSignedCertificate.certificate(), selfSignedCertificate.privateKey()).build();
        } else {
            sslContext = null;
        }

        // Configure the server.
        // 配置服务
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        final EchoServerHandler serverHandler = new EchoServerHandler();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    // .option(ChannelOption.SO_BACKLOG, 100)
                    // .handler(new LoggingHandler(LogLevel.INFO))
                    // .localAddress(new InetSocketAddress(PORT))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline channelPipeline = socketChannel.pipeline();
                            if (sslContext != null) {
                                channelPipeline.addLast(sslContext.newHandler(socketChannel.alloc()));
                            }
                            //p.addLast(new LoggingHandler(LogLevel.INFO));
                            channelPipeline.addLast(serverHandler);
                        }
                    });

            // Start the server.
            // 开始服务
            ChannelFuture channelFuture = serverBootstrap.bind(PORT).sync();

            // Wait until the server socket is closed.
            // 等待直到服务器插座关闭。
            channelFuture.channel().closeFuture().sync();
        } finally {
            // Shut down all event loops to terminate all threads.
            // 关闭所有事件循环以终止所有线程。
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}