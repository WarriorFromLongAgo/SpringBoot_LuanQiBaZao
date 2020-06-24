package com.xuegao.design_patterns.singleton;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.singleton
 * <br/> @ClassName：LazySingleton2
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/23 20:38
 */
@SuppressWarnings("all")
public class LazySingleton2 {
    private LazySingleton2() {
    }

    private volatile static LazySingleton2 instance;

    public static LazySingleton2 getInstance() {
        if (instance == null) {
            LazySingleton2 singleton;
            synchronized (LazySingleton2.class) {
                singleton = instance;
                if (singleton == null) {
                    synchronized (LazySingleton2.class) {
                        if (singleton == null) {
                            singleton = new LazySingleton2();
                        }
                    }
                    instance = singleton;
                }
            }

        }

        return instance;
    }
}