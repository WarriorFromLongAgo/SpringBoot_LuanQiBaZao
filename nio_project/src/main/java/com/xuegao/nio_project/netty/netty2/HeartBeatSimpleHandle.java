// package com.xuegao.nio_project.netty.netty2;
//
// import io.netty.buffer.ByteBuf;
// import io.netty.buffer.Unpooled;
// import io.netty.channel.ChannelFutureListener;
// import io.netty.channel.ChannelHandlerContext;
// import io.netty.channel.socket.nio.NioSocketChannel;
// import io.netty.handler.timeout.IdleState;
// import io.netty.handler.timeout.IdleStateEvent;
// import io.netty.util.CharsetUtil;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
//
// public class HeartBeatSimpleHandle extends SimpleChannelInboundHandler<CustomProtocol> {
//
//     private final static Logger LOGGER = LoggerFactory.getLogger(HeartBeatSimpleHandle.class);
//
//     private static final ByteBuf HEART_BEAT =  Unpooled.unreleasableBuffer(Unpooled.copiedBuffer(new CustomProtocol(123456L,"pong").toString(), CharsetUtil.UTF_8));
//
//
//     /**
//      * 取消绑定
//      * @param ctx
//      * @throws Exception
//      */
//     @Override
//     public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//
//         NettySocketHolder.remove((NioSocketChannel) ctx.channel());
//     }
//
//     @Override
//     public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
//
//         if (evt instanceof IdleStateEvent){
//             IdleStateEvent idleStateEvent = (IdleStateEvent) evt ;
//
//             if (idleStateEvent.state() == IdleState.READER_IDLE){
//                 LOGGER.info("已经5秒没有收到信息！");
//                 //向客户端发送消息
//                 ctx.writeAndFlush(HEART_BEAT).addListener(ChannelFutureListener.CLOSE_ON_FAILURE) ;
//             }
//
//
//         }
//
//         super.userEventTriggered(ctx, evt);
//     }
//
//     @Override
//     protected void channelRead0(ChannelHandlerContext ctx, CustomProtocol customProtocol) throws Exception {
//         LOGGER.info("收到customProtocol={}", customProtocol);
//
//         //保存客户端与 Channel 之间的关系
//         NettySocketHolder.put(customProtocol.getId(),(NioSocketChannel)ctx.channel()) ;
//     }
// }
//
// // 作者：crossoverJie
// // 链接：https://juejin.im/post/5b0b50a4f265da0dbd7a697d
// // 来源：掘金
// // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。