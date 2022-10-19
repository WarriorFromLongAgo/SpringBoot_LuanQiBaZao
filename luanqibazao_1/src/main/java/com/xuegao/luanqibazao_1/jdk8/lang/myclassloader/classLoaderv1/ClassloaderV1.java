package com.xuegao.luanqibazao_1.jdk8.lang.myclassloader.classLoaderv1;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassloaderV1 {
    public static void main(String[] args) throws Exception {
        MyClassLoader loader = new MyClassLoader();

        //使用MyClassLoader加载cl.test.A
        Class aClazz = loader.loadClass("com.xuegao.luanqibazao_1.jdk8.lang.myclassloader.classLoaderv1.A");
        Object a = aClazz.newInstance();

        Method getB = aClazz.getMethod("getB", null);
        Object b = getB.invoke(a, null);

        System.out.println(a.getClass().getClassLoader());
        System.out.println(b.getClass().getClassLoader());

    }
}

class MyClassLoader extends URLClassLoader {
    //该路径是一个非classpath路径
    public static File file = new File("D:\\git\\my\\SpringBoot_LuanQiBaZao\\luanqibazao_1\\src\\main\\java\\com\\xuegao\\luanqibazao_1\\jdk8\\lang\\myclassloader\\classLoaderv1");

    //MyClassLoader从上面的非classpath路径加载类
    public MyClassLoader() throws Exception {
        super(new URL[]{file.toURL()}, null, null);
    }
}
