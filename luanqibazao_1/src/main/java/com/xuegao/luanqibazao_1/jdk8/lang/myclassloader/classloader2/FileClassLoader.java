package com.xuegao.luanqibazao_1.jdk8.lang.myclassloader.classloader2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileClassLoader extends ClassLoader {

    // class文件的目录
    private String rootDir;

    public FileClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getClassData(String className) {

        String path = rootDir + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        String rootDir = "D:\\git\\my\\SpringBoot_LuanQiBaZao\\luanqibazao_1\\src\\main\\java";
        FileClassLoader loader1 = new FileClassLoader(rootDir);
        FileClassLoader loader2 = new FileClassLoader(rootDir);

        try {
            // 传入class文件的全限定名
            Class<?> clazz1 = loader1.findClass("com.xuegao.luanqibazao_1.jdk8.lang.myclassloader.classloader2.DemoObj");
            // com.javashitang.classloader.FileClassLoader@1b28cdfa
            System.out.println(clazz1.getClassLoader());
            // I am DemoObj
            System.out.println(clazz1.newInstance().toString());

            Class<?> clazz2 = loader2.findClass("com.xuegao.luanqibazao_1.jdk8.lang.myclassloader.classloader2.DemoObj");
            System.out.println(clazz2.getClassLoader());
            System.out.println(clazz2.newInstance().toString());

            // false
            System.out.println(clazz1 == clazz2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
// -----------------------------------
// ©著作权归作者所有：来自51CTO博客作者wx6289ced28e34b的原创作品，请联系作者获取转载授权，否则将追究法律责任
// 面试官：ClassLoader的原理及应用
// https://blog.51cto.com/u_15651175/5547458