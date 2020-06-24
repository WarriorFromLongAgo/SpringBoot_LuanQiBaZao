package com.xuegao.design_patterns.singleton;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.singleton
 * <br/> @ClassName：EnumSingleton
 * <br/> @Description：
 * <br/> @Description：缺点，无延迟加载
 * <br/> @Description：优点；实现简单，本身就是单例的
 * <br/> @Description：
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/23 19:36
 */
public enum EnumSingleton {
    SINGLETON;

    private Singleton instance;

    EnumSingleton() {
        instance = new Singleton();
    }

    public Singleton getInstance() {
        return instance;
    }

}

class Singleton {
}