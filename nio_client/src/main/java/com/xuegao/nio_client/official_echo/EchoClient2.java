package com.xuegao.nio_client.official_echo;

import com.xuegao.nio_client.netty2.EchoClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <br/> @PackageName：com.xuegao.nio_client.official_echo
 * <br/> @ClassName：EchoClient
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/17 15:00
 */
public class EchoClient2 {

    private final Logger log = LoggerFactory.getLogger(getClass());

    static final boolean SSL = System.getProperty("ssl") != null;
    static final String HOST = System.getProperty("host", "127.0.0.1");
    static final int PORT = Integer.parseInt(System.getProperty("port", "8007"));
    static final int SIZE = Integer.parseInt(System.getProperty("size", "256"));

    public static void main(String[] args) throws Exception {
        // Configure SSL.git
        final SslContext sslContext;
        if (SSL) {
            sslContext = SslContextBuilder.forClient()
                    .trustManager(InsecureTrustManagerFactory.INSTANCE).build();
        } else {
            sslContext = null;
        }

        // Configure the client.
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    // .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline channelPipeline = socketChannel.pipeline();
                            if (sslContext != null) {
                                // channelPipeline.addLast(sslContext.newHandler(socketChannel.alloc(), HOST, PORT));
                                channelPipeline.addLast(sslContext.newHandler(socketChannel.alloc()));
                            }
                            //p.addLast(new LoggingHandler(LogLevel.INFO));
                            channelPipeline.addLast(new EchoClientHandler());
                        }
                    });

            // Start the client.
            ChannelFuture channelFuture = bootstrap.connect(HOST, PORT).sync();

            // Wait until the connection is closed.
            channelFuture.channel().closeFuture().sync();
        } finally {
            // Shut down the event loop to terminate all threads.
            eventLoopGroup.shutdownGracefully();
        }
    }
}