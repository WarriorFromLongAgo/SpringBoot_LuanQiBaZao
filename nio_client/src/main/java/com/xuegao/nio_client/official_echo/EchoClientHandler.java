package com.xuegao.nio_client.official_echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 服务端可以与多个handler建立连接
@ChannelHandler.Sharable
public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final StringBuffer firstMessage = new StringBuffer();

    /**
     * 构造函数直接执行
     */
    public EchoClientHandler() {
        log.error("===========================================");
        log.error("{}", "EchoClientHandler");
        log.error("===========================================");
        for (int i = 0; i < EchoClient.SIZE; i++) {
            firstMessage.append(i);
        }
    }

    // 第一执行，然后发送消息
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ByteBuf byteBuf = Unpooled.copiedBuffer(firstMessage.toString(), CharsetUtil.UTF_8);

        log.error("===========================================");
        log.error("{}", "channelActive");
        log.error("{}", byteBuf);
        log.error("===========================================");
        ctx.writeAndFlush(byteBuf);
    }

    // 执行完消息，第一，走这里
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        log.error("===========================================");
        log.error("{}", "channelRead");
        log.error("{}", msg);
        log.error("===========================================");

        // ctx.writeAndFlush(msg);

        // ReferenceCountUtil.release(msg);
        // ctx.write(msg);
        // ctx.flush();
        // ctx.fireChannelActive();
    }

    // 执行完消息，第二，走这里
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        log.error("===========================================");
        log.error("{}", "channelReadComplete");
        log.error("===========================================");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("===========================================");
        log.error("{}", "exceptionCaught");
        log.error("===========================================");
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}