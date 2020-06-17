package com.xuegao.nio_server;

import com.xuegao.nio_server.netty4.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

@SpringBootApplication
public class NioServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NioServerApplication.class, args);
        // 启动netty4 目录下的 netty 服务端
        // NettyServer nettyServer = new NettyServer();
        // nettyServer.start(new InetSocketAddress("127.0.0.1", 8090));
    }

}
