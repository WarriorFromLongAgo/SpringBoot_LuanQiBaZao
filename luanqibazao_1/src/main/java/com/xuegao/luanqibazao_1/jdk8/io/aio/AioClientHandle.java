package com.xuegao.luanqibazao_1.jdk8.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AioClientHandle extends Thread implements CompletionHandler<Void, AioClientHandle> {

    private AsynchronousSocketChannel socketChannel;

    boolean stop = false;

    public AioClientHandle() {
        try {
            socketChannel = AsynchronousSocketChannel.open();
            System.out.println("client init ");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        try {
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 1986), this, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(100000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void completed(Void result, AioClientHandle attachment) {

        System.out.println("client connected ");

        String sendMsg = System.currentTimeMillis() + "";
        ByteBuffer writeBuffer = ByteBuffer.allocate(sendMsg.getBytes().length);
        writeBuffer.put(sendMsg.getBytes());
        writeBuffer.flip();

        socketChannel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if (attachment.hasRemaining()) {
                    socketChannel.write(writeBuffer, attachment, this);
                } else {

                    System.out.println("client write ");

                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    socketChannel.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            readBuffer.flip();
                            byte[] bytes = new byte[readBuffer.remaining()];
                            readBuffer.get(bytes);
                            System.out.println("client read : " + new String(bytes));
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            try {
                                socketChannel.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void failed(Throwable exc, AioClientHandle attachment) {
        try {
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

// ————————————————
// 版权声明：本文为CSDN博主「fengyunhust」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/fengyunhust/article/details/51930754