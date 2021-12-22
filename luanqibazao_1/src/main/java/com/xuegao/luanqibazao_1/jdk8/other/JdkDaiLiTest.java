package com.xuegao.luanqibazao_1.jdk8.other;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xuegao
 * @version 1.0
 * @date 2021/12/21 13:13
 */
public class JdkDaiLiTest {
    public static void main(String[] args) {
        // 保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // jdk动态代理测试
        JdkDaiLiInterface jdkDaiLiInterface = new JdkDaiLiInterfaceInvocationHandler(new JdkDaiLiInterfaceImpl()).getProxy();
        System.out.println(jdkDaiLiInterface.getClass());
        System.out.println(jdkDaiLiInterface.login("admin", "admin"));
        System.out.println(jdkDaiLiInterface.login("admin", "admin1"));
    }
}

interface JdkDaiLiInterface {

    boolean login(String username, String password);
}

class JdkDaiLiInterfaceImpl implements JdkDaiLiInterface {

    @Override
    public boolean login(String username, String password) {
        System.out.println("username:" + username + " password:" + password);
        return false;
    }
}

class JdkDaiLiInterfaceInvocationHandler implements InvocationHandler {
    private Object target;

    public JdkDaiLiInterfaceInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 获取被代理接口实例对象
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Before invocation");
        Object retVal = method.invoke(target, args);
        System.out.println("After invocation");
        return retVal;
    }
}

// 作者：MinXie
// 链接：https://juejin.cn/post/7043401155753279524
// 来源：稀土掘金
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。