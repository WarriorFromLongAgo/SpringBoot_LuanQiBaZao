package com.xuegao.luanqibazao_1.jdk8.lang.myclassloader;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.lang.myclassloader
 * <br/> @ClassName：MyClassLoader
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/02/28 16:04
 */
public class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}