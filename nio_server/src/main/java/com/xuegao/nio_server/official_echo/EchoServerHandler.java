package com.xuegao.nio_server.official_echo;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handler implementation for the echo server.
 * 回显服务器的处理程序实现
 */
// 服务端可以与多个handler建立连接
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    private final Logger log = LoggerFactory.getLogger(getClass());

    // 第一执行，接受消息
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        log.error("===========================================");
        log.error("{}", "channelRead");
        log.error("{}, {}", ctx.channel().remoteAddress(), msg);
        log.error("===========================================");
        ctx.write(msg);
    }

    // 第二执行 处理相关
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        log.error("===========================================");
        log.error("{}", "channelReadComplete");
        log.error("===========================================");
        ctx.flush();
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