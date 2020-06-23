package com.xuegao.design_patterns.singleton;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.singleton
 * <br/> @ClassName：HungrySingleton
 * <br/> @Description：饿汉式
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/23 18:30
 */
public class HungrySingleton {
    private HungrySingleton() {
    }

    private static HungrySingleton instance = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return instance;
    }
}