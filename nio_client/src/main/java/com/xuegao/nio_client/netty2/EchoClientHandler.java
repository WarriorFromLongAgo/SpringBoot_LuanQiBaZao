package com.xuegao.nio_client.netty2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// EchoClientHandler类负责处理业务逻辑
@ChannelHandler.Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * <br/> @Title: 第二执行，发送消息，
     * <br/> @MethodName:  channelRead0
     * <br/> @param channelHandlerContext:
     * <br/> @param byteBuf:
     * <br/> @Return void
     * <br/> @Description:
     * <br/> @author: 花名：xuegao
     * <br/> @date:  2020/6/17 15:38
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        log.error("===========================================");
        log.error("{}", "channelRead0");
        log.error("===========================================");
        System.out.println("Client received channelRead0: " + byteBuf.toString());
    }

    /**
     * <br/> @Title: 第一执行，将要发出的消息放到 ByteBuf 里面
     * <br/> @MethodName:  channelActive
     * <br/> @param ctx:
     * <br/> @Return void
     * <br/> @Description:
     * <br/> @author: 花名：xuegao
     * <br/> @date:  2020/6/17 15:44
     */
    @Override
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        log.error("===========================================");
        log.error("{}", "channelActive");
        log.error("===========================================");
        channelHandlerContext.writeAndFlush(Unpooled.copiedBuffer("Netty rocks channelRead0 啊大大", CharsetUtil.UTF_8));
    }

    /**
     * <br/> @Title: channelActive 报错，直接到这里，但是仍然会继续执行发出消息
     * <br/> @Title: channelRead0 报错，直接到这里，但是仍然会继续执行发出消息
     * <br/> @MethodName:  exceptionCaught
     * <br/> @param ctx:
     * <br/> @param cause:
     * <br/> @Return void
     * <br/> @Description:
     * <br/> @author: 花名：xuegao
     * <br/> @date:  2020/6/17 15:48
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("===========================================");
        log.error("{}", "exceptionCaught");
        log.error("===========================================");
        cause.printStackTrace();
        ctx.close();
    }
}