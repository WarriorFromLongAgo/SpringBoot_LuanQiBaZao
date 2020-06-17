package com.xuegao.nio_server.offcial_discard;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiscardServerHandler extends SimpleChannelInboundHandler<Object> {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.error("===========================================");
        log.error("{}", "channelRead0");
        log.error("===========================================");
        // discard
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