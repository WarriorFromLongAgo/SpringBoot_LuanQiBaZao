package com.xuegao.luanqibazao_1.jdk8.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AioServerHandle extends Thread {
 
    private AsynchronousServerSocketChannel serverSocketChannel;
 
    boolean stop = false;
 
    public AioServerHandle() {
        try {
            serverSocketChannel = AsynchronousServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 1986));
            System.out.println("server init ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public void run() {
        serverSocketChannel.accept(this, new CompletionHandler<AsynchronousSocketChannel, AioServerHandle>() {
            @Override
            public void completed(final AsynchronousSocketChannel channel, AioServerHandle attachment) {
 
                attachment.serverSocketChannel.accept(attachment, this);
                System.out.println("server accepted ");
 
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                channel.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        attachment.flip();
                        byte[] bytes = new byte[attachment.remaining()];
                        attachment.get(bytes);
                        System.out.println("server read : " + new String(bytes));
 
                        String sendMsg = "server ack";
                        ByteBuffer writeBuffer = ByteBuffer.allocate(sendMsg.getBytes().length);
                        writeBuffer.put(sendMsg.getBytes());
                        writeBuffer.flip();
                        channel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                            @Override
                            public void completed(Integer result, ByteBuffer attachment) {
                                if (attachment.hasRemaining()){
                                    channel.write(attachment, attachment ,this);
                                }
                                System.out.println("server write ");
                            }
 
                            @Override
                            public void failed(Throwable exc, ByteBuffer attachment) {
                                try {
                                    channel.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
 
                    }
 
                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        try {
                            serverSocketChannel.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
 
            @Override
            public void failed(Throwable exc, AioServerHandle attachment) {
 
            }
        });
        try {
            Thread.sleep(100000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
// ————————————————
// 版权声明：本文为CSDN博主「fengyunhust」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/fengyunhust/article/details/51930754