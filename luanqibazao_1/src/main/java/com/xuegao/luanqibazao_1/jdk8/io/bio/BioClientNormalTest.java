package com.xuegao.luanqibazao_1.jdk8.io.bio;

import java.io.IOException;
import java.util.Random;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.io.bio
 * <br/> @ClassName：BioClientNormalTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/03/02 15:25
 */
public class BioClientNormalTest {

    //测试主方法
    public static void main(String[] args) throws InterruptedException {
        //运行服务器
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BioServerNormal.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        //运行客户端
        char operators[] = {'+', '-', '*', '/'};
        Random random = new Random(System.currentTimeMillis());
        new Thread(new Runnable() {
            @SuppressWarnings("static-access")
            @Override
            public void run() {
                while (true) {
                    //随机产生算术表达式
                    String expression = random.nextInt(10) + "" + operators[random.nextInt(4)] + (random.nextInt(10) + 1);
                    BioClientNormal.send(expression);
                    try {
                        Thread.currentThread().sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

// ————————————————
//         版权声明：本文为CSDN博主「anxpp」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//         原文链接：https://blog.csdn.net/anxpp/article/details/51512200
    }
}