// package com.xuegao.nio_project.netty.netty2;
//
// import io.netty.channel.ChannelFuture;
// import io.netty.channel.EventLoopGroup;
// import io.netty.channel.nio.NioEventLoopGroup;
// import io.netty.channel.socket.nio.NioSocketChannel;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;
//
// import javax.annotation.PostConstruct;
//
// @Component
// public class HeartbeatClient {
//
//     private final static Logger LOGGER = LoggerFactory.getLogger(HeartbeatClient.class);
//
//     private EventLoopGroup group = new NioEventLoopGroup();
//
//
//     @Value("${netty.server.port}")
//     private int nettyPort;
//
//     @Value("${netty.server.host}")
//     private String host;
//
//     private SocketChannel channel;
//
//     @PostConstruct
//     public void start() throws InterruptedException {
//         Bootstrap bootstrap = new Bootstrap();
//         bootstrap.group(group)
//                 .channel(NioSocketChannel.class)
//                 .handler(new CustomerHandleInitializer())
//         ;
//
//         ChannelFuture future = bootstrap.connect(host, nettyPort).sync();
//         if (future.isSuccess()) {
//             LOGGER.info("启动 Netty 成功");
//         }
//         channel = (SocketChannel) future.channel();
//     }
//
// }
//
// // 作者：crossoverJie
// // 链接：https://juejin.im/post/5b0b50a4f265da0dbd7a697d
// // 来源：掘金
// // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。