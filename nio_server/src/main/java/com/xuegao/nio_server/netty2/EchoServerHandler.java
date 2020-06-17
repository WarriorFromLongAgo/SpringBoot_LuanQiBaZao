package com.xuegao.nio_server.netty2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// EchoServerHandler 实现了业务逻辑

// 标识一个 ChannelHandler可以被多个Channel安全地共享
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * <br/> @Title: 接受前端的消息，第一执行
     * <br/> @MethodName:  channelRead
     * <br/> @param ctx:
     * <br/> @param msg:
     * <br/> @Return void
     * <br/> @Description:
     * <br/> @author: 花名：xuegao
     * <br/> @date:  2020/6/17 15:32
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.error("===========================================");
        log.error("{}", "channelRead");
        log.error("===========================================");
        // 接收到client的消息
        ByteBuf buffer = (ByteBuf) msg;
        //将消息记录到控制台
        System.out.println("Server received: " + buffer.toString(CharsetUtil.UTF_8));
        //将接受到消息回写给发送者
        ctx.write(buffer);
    }

    /**
     * <br/> @Title: 执行完成后，关闭链接，第二执行
     * <br/> @MethodName:  channelReadComplete
     * <br/> @param ctx:
     * <br/> @Return void
     * <br/> @Description:
     * <br/> @author: 花名：xuegao
     * <br/> @date:  2020/6/17 15:32
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        log.error("===========================================");
        log.error("{}", "channelReadComplete");
        log.error("===========================================");
        //将未消息冲刷到远程节点，并且关闭该 Channel
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);
    }

    /**
     * <br/> @Title: 出现报错的时候执行到这里，哪怕是 channelReadComplete的最后一行报错，也会到这里
     * <br/> @Title: 如果提前报错，就提前退出
     * <br/> @MethodName:  exceptionCaught
     * <br/> @param ctx:
     * <br/> @param cause:
     * <br/> @Return void
     * <br/> @Description:
     * <br/> @author: 花名：xuegao
     * <br/> @date:  2020/6/17 15:36
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("===========================================");
        log.error("{}", "exceptionCaught");
        log.error("===========================================");
        //打印异常栈跟踪
        cause.printStackTrace();
        //关闭该Channel
        ctx.close();
    }
}