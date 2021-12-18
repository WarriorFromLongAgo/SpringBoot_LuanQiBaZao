package com.xuegao.luanqibazao_1.jdk8.lang.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuegao
 * @version 1.0
 * @date 2021/12/6 23:17
 */
public class InheritableThreadLocalTest {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(3);

    private static final ExecutorService PUSH_EXECUTOR_SERVICE = Executors.newFixedThreadPool(3);

    private static final ThreadLocal<String> THREAD_LOCAL = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        THREAD_LOCAL.set("李四");
        System.out.println(Thread.currentThread().getName() + "当前登陆用户：" + THREAD_LOCAL.get());

        EXECUTOR_SERVICE.submit(() -> {
            //请求进来时，初始化用户信息
            System.out.println(Thread.currentThread().getName() + "当前登陆用户：" + THREAD_LOCAL.get());

            // 接着异步发送短信
            System.out.println("开始异步发送短信");
            PUSH_EXECUTOR_SERVICE.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "发送短信给：" + THREAD_LOCAL.get());
            });
        });
        EXECUTOR_SERVICE.shutdown();
    }
    // 打印结果

    // main当前登陆用户：李四
    // pool-1-thread-1当前登陆用户：李四
    // 开始异步发送短信
    // pool-2-thread-1发送短信给：李四

    // 作者：我有一只喵喵
    // 链接：https://juejin.cn/post/7022529092519985160
    // 来源：稀土掘金
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}