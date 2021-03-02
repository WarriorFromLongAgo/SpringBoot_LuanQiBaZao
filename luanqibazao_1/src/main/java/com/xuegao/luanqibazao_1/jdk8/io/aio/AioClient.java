package com.xuegao.luanqibazao_1.jdk8.io.aio;

public class AioClient {
 
 
    public static void main(String[] args) {
 
 
        try {
            new AioClientHandle().start();
 
            Thread.sleep(111111111111L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
// ————————————————
// 版权声明：本文为CSDN博主「fengyunhust」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/fengyunhust/article/details/51930754