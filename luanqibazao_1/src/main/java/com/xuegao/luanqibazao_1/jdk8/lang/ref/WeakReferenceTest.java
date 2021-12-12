package com.xuegao.luanqibazao_1.jdk8.lang.ref;

import com.xuegao.luanqibazao_1.domain.UserInfo;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @author xuegao
 * @version 1.0
 * @date 2021/12/11 15:20
 */
public class WeakReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        UserInfo userInfo = new UserInfo();
        userInfo.setAddress("address");
        userInfo.setName("name");
        WeakReference<UserInfo> weakReference = new WeakReference<>(userInfo);
        System.out.println(weakReference.get());
        System.gc();
        System.runFinalization();
        int i = 0;
        while (true) {
            System.gc();
            System.runFinalization();
            if (weakReference.get() != null) {
                i++;
                System.out.println("Object is alive for " + i + " userInfo - " + userInfo + " - " + weakReference.get());
            } else {
                System.out.println("Object has been collected.");
                break;
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }
}