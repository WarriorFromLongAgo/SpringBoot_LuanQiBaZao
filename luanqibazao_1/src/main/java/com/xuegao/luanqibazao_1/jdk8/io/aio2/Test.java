package com.xuegao.luanqibazao_1.jdk8.io.aio2;

import java.util.Scanner;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.io.aio2
 * <br/> @ClassName：Test
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/03/02 16:16
 */
public class Test {
    //测试主方法
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception{
        //运行服务器
        AioServer.start();
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        //运行客户端
        AioClient.start();
        System.out.println("请输入请求消息：");
        Scanner scanner = new Scanner(System.in);
        while(AioClient.sendMsg(scanner.nextLine()));
    }
// ————————————————
//     版权声明：本文为CSDN博主「anxpp」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//     原文链接：https://blog.csdn.net/anxpp/article/details/51512200
}