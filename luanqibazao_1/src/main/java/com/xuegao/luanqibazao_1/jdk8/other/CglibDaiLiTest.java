package com.xuegao.luanqibazao_1.jdk8.other;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xuegao
 * @version 1.0
 * @date 2021/12/21 13:26
 */
public class CglibDaiLiTest {

    public static void main(String[] args) {
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(AsmDaiLiClass.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new CglibProxy());
        // 创建代理对象
        AsmDaiLiClass proxy = (AsmDaiLiClass) enhancer.create();
        // 通过代理对象调用目标方法
        proxy.login("aaa", "bbb");
    }
}

class CglibProxy implements MethodInterceptor {

    /**
     * @param o:           代理对象
     * @param method:      被代理方法
     * @param params:      方法入参
     * @param methodProxy: CGLIB方法
     **/
    @Override
    public Object intercept(Object o, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置：" + method.getName());
        Object result = methodProxy.invokeSuper(o, params);
        System.out.println("后置：" + method.getName());
        return result;
    }
}


class AsmDaiLiClass {
    public boolean login(String username, String password) {
        System.out.println(false);
        return false;
    }
}

// ————————————————
// 版权声明：本文为CSDN博主「sco5282」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/sco5282/article/details/121866799