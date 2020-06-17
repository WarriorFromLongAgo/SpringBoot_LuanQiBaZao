// package com.xuegao.nio_project.netty.netty2;
//
// import io.netty.handler.timeout.IdleStateHandler;
//
// public class CustomerHandleInitializer extends ChannelInitializer<Channel> {
//     @Override
//     protected void initChannel(Channel ch) throws Exception {
//         ch.pipeline()
//                 //10 秒没发送消息 将IdleStateHandler 添加到 ChannelPipeline 中
//                 .addLast(new IdleStateHandler(0, 10, 0))
//                 .addLast(new HeartbeatEncode())
//                 .addLast(new EchoClientHandle())
//         ;
//     }
// }
//
// // 作者：crossoverJie
// // 链接：https://juejin.im/post/5b0b50a4f265da0dbd7a697d
// // 来源：掘金
// // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。