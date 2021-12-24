package com.xuegao.luanqibazao_1.ali.ttl;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import com.xuegao.luanqibazao_1.common.ThreadPoolBusiness;
import com.xuegao.luanqibazao_1.common.ThreadPoolSpring;
import com.xuegao.luanqibazao_1.domain.UserInfo;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ttl 和 Inheritable 的区别
 * <p>
 * 1，运费预测context使用的是jdk的in，如果在某个线程池里面修改了context的值，那么上下文traceId就会被修改了
 *
 * @author xuegao
 * @version 1.0
 * @date 2021/12/18 14:04
 */
public class TtlCompare1_yunfeiyuce {
    private static final Logger log = LoggerFactory.getLogger(TtlCompare1_yunfeiyuce.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        inheritable1000();
        // ttl1000();
    }

    private static void enter() {
        System.out.println("===========================");
    }

    public static void ttl1000() throws ExecutionException, InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 3; i++) {
            int count = atomicInteger.incrementAndGet();
            System.out.println("==============" + count + "主线程开始===============");
            Future<Object> submit = ThreadPoolSpring.getInstance().submit(new Callable<Object>() {
                @SneakyThrows
                @Override
                public Object call() {
                    ThreadLocal<UserInfo> context = new TransmittableThreadLocal<>();
                    ExecutorService ttlExecutor = TtlExecutors.getTtlExecutorService(ThreadPoolBusiness.getInstance());
                    UserInfo userInfo = new UserInfo();
                    userInfo.setAge(count);
                    context.set(userInfo);
                    System.out.println(Thread.currentThread().getName() + " - " + context.get() + " - " + context.get().getAge());
                    ttlExecutor.submit(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("=============子线程开始================");
                            System.out.println(Thread.currentThread().getName() + context.get() + " - " + context.get().getAge());
                            UserInfo temp = context.get();
                            temp.setAge(temp.getAge() * 100);
                            context.set(temp);
                            System.out.println(Thread.currentThread().getName() + context.get() + " - " + context.get().getAge());
                            System.out.println("==============子线程结束===============");
                        }
                    });
                    System.out.println(Thread.currentThread().getName() + context.get() + " - " + context.get().getAge());
                    return new Object();
                }
            });
            submit.get();
            System.out.println("==============" + count + "主线程结束===============");
        }
    }

    /**
     * 第一个线程在使用的时候，会获取到这个值，然后进行了修改，
     * 就会影响这个线程在其他地方的使用，也就是context被修改了，导致其他线程在用的时候，出现了不一样的地方
     *
     * @author xuegao
     * @date 2021/12/18 19:34
     */
    public static void inheritable1000() throws InterruptedException, ExecutionException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 3; i++) {
            int count = atomicInteger.incrementAndGet();
            System.out.println("==============" + count + "主线程开始===============");
            Future<Object> submit = ThreadPoolSpring.getInstance().submit(new Callable<Object>() {
                @SneakyThrows
                @Override
                public Object call() {
                    ThreadLocal<UserInfo> context = new InheritableThreadLocal<>();
                    ThreadPoolExecutor threadPoolBusiness = ThreadPoolBusiness.getInstance();
                    UserInfo userInfo = new UserInfo();
                    userInfo.setAge(count);
                    context.set(userInfo);
                    System.out.println(Thread.currentThread().getName() + " - " + context.get() + " - " + context.get().getAge());
                    threadPoolBusiness.submit(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("=============子线程开始================");
                            System.out.println(Thread.currentThread().getName() + context.get() + " - " + context.get().getAge());
                            UserInfo temp = context.get();
                            temp.setAge(temp.getAge() * 100);
                            context.set(temp);
                            System.out.println(Thread.currentThread().getName() + context.get() + " - " + context.get().getAge());
                            System.out.println("==============子线程结束===============");
                        }
                    });
                    System.out.println(Thread.currentThread().getName() + context.get() + " - " + context.get().getAge());
                    return new Object();
                }
            });
            submit.get();
            System.out.println("==============" + count + "主线程结束===============");
        }
    }

}