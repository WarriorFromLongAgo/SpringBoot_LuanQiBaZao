package com.xuegao.luanqibazao_1.jdk8.io.aio2;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.io.aio2
 * <br/> @ClassName：AioServer
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/03/02 16:04
 */
public class AioServer {

    private static int DEFAULT_PORT = 12345;
    private static AioServerHandler serverHandle;
    public volatile static long clientCount = 0;

    public static void start() {
        start(DEFAULT_PORT);
    }

    public static synchronized void start(int port) {
        if (serverHandle != null) {
            return;
        }
        serverHandle = new AioServerHandler(port);
        new Thread(serverHandle, "Server").start();
    }

    public static void main(String[] args) {
        AioServer.start();
    }
// ————————————————
//     版权声明：本文为CSDN博主「anxpp」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//     原文链接：https://blog.csdn.net/anxpp/article/details/51512200
}