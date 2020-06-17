package com.xuegao.nio_client;

import com.xuegao.nio_client.netty.NettyClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NioClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NioClientApplication.class, args);
        // 启动netty目录下的，netty1客户端
        // NettyClient nettyClient = new NettyClient();
        // nettyClient.start();
    }

}
