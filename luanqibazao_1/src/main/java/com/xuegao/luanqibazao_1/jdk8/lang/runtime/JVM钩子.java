package com.xuegao.luanqibazao_1.jdk8.lang.runtime;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.lang.runtime
 * <br/> @ClassName：JVM钩子
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/12/03 12:49
 */
public class JVM钩子 {
    public static void main(String[] args) throws InterruptedException {
        // 自己实现的钩子
        StudyShutdownHook instance = StudyShutdownHook.getInstance();
        // 将需要关闭的资源，放到钩子里面
        StudyResource studyResource = new StudyResource();
        instance.registerAutoClose(studyResource);

        // 向JVM注册钩子
        Runtime.getRuntime().addShutdownHook(instance);

        System.out.println("执行业务逻辑");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("业务逻辑执行完毕");

        // 执行业务逻辑
        // 业务逻辑执行完毕
        // 学习资源的关闭
    }
}

class StudyShutdownHook extends Thread {
    private static final StudyShutdownHook INSTANCE = new StudyShutdownHook();
    // 需要关闭的钩子集合，可以将项目中的资源关闭操作都放在里面
    private final Set<AutoCloseable> autoCloseableSet = new HashSet<>();

    private StudyShutdownHook() {

    }

    public static StudyShutdownHook getInstance() {
        return INSTANCE;
    }

    public void registerAutoClose(final AutoCloseable autoCloseable) {
        autoCloseableSet.add(autoCloseable);
    }

    @Override
    public void run() {
        this.closeAll();
    }

    private void closeAll() {
        try {
            for (AutoCloseable autoCloseable : autoCloseableSet) {
                autoCloseable.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class StudyResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("学习资源的关闭");
    }
}