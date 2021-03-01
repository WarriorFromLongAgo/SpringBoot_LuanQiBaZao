package com.xuegao.luanqibazao_1.jdk8.lang.myclassloader;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.lang.classloader
 * <br/> @ClassName：ClassLoaderTest1
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/02/28 14:28
 */
public class MyClassLoaderTest1 {
    public static void main(String[] args) {
        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println(classLoader);

        // sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader classLoader1 = MyClassLoaderTest1.class.getClassLoader();
        System.out.println(classLoader1);


    }
}