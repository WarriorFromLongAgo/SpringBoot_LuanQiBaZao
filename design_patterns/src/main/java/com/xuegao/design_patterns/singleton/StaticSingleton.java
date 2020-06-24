package com.xuegao.design_patterns.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.singleton
 * <br/> @ClassName：StaticSingleton
 * <br/> @Description：静态内部类的单例
 * <br/> @Description：
 * <br/> @Description：不会像饿汉式那样，马上加载，只有真正调用getInstance()，才会加载内部类，且加载时是线程安全的
 * <br/> @Description：兼备了并发高效调用 和 延迟加载的目的
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/23 19:28
 */
@SuppressWarnings("all")
public class StaticSingleton implements Serializable {

    private static final long serialVersionUID = 1384237620961892788L;

    private StaticSingleton() {
        if (null != SingletonInstance.instance) {
            throw new RuntimeException();
        }
    }

    private static class SingletonInstance {
        private static final StaticSingleton instance = new StaticSingleton();
    }

    public StaticSingleton getInstance() {
        return SingletonInstance.instance;
    }

    /**
     * 如果通过反射（绕过检查，通过反射可以调用私有的），那么单例模式其实是失效了
     * <p>
     * 解决反射问题
     * if (null != SingletonInstance.instance){
     * throw new RuntimeException();
     * }
     */

    // 防止反序列化获取多个对象的漏洞。
    // 无论是实现Serializable接口，或是Externalizable接口，当从I/O流中读取对象时，readResolve()方法都会被调用到。
    // 实际上就是用readResolve()中返回的对象直接替换在反序列化过程中创建的对象
    private Object readResolve() throws ObjectStreamException {
        return SingletonInstance.instance;
    }
}