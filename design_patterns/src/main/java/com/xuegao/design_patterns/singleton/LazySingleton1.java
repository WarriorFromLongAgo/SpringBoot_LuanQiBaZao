package com.xuegao.design_patterns.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.singleton
 * <br/> @ClassName：LazySingleton1
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/23 18:41
 */
@SuppressWarnings("all")
public class LazySingleton1 implements Serializable {

    private static final long serialVersionUID = -8569390962627788696L;

    private LazySingleton1() {
        // synchronized (LazySingleton1.class) {
        //     if (instance != null) {
        //         throw new RuntimeException("不要试图用反射破坏单例模式");
        //     }
        // }

        if (instance != null) {
            throw new RuntimeException();
        }
    }

    private volatile static LazySingleton1 instance;

    public static LazySingleton1 getInstance() {
        if (instance == null) {
            synchronized (LazySingleton1.class) {
                if (instance == null) {
                    instance = new LazySingleton1();
                }
            }
        }
        return instance;
    }

    // 防止反序列化获取多个对象的漏洞。
    // 无论是实现Serializable接口，或是Externalizable接口，当从I/O流中读取对象时，readResolve()方法都会被调用到。
    // 实际上就是用readResolve()中返回的对象直接替换在反序列化过程中创建的对象
    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
}