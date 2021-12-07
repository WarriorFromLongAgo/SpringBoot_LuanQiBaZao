package com.xuegao.luanqibazao_1;

import com.alibaba.fastjson.JSON;
import com.xuegao.luanqibazao_1.domain.UserInfo;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.ObjectUtils;


public class commonslang {

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        UserInfoUtils.set(userInfo);

        new Thread(new Runnable() {
            @Override
            public void run() {
                UserInfo userInfo = UserInfoUtils.get();
                if (ObjectUtils.isEmpty(userInfo)) {
                    userInfo = new UserInfo();
                }
                System.out.println("aaaa11 = " + JSON.toJSONString(userInfo));
                userInfo.setAddress(RandomStringUtils.randomAlphanumeric(16));
                System.out.println("aaaa22 = " + JSON.toJSONString(userInfo));
                UserInfoUtils.unset();
            }
        }).run();

        new Thread(new Runnable() {
            @Override
            public void run() {
                UserInfo userInfo = UserInfoUtils.get();
                if (ObjectUtils.isEmpty(userInfo)) {
                    userInfo = new UserInfo();
                }
                System.out.println("bbbb11 = " + JSON.toJSONString(userInfo));
                userInfo.setAddress(RandomStringUtils.randomAlphanumeric(16));
                System.out.println("bbbb22 = " + JSON.toJSONString(userInfo));
                UserInfoUtils.unset();
            }
        }).run();
    }
}

class UserInfoUtils {
    private static ThreadLocal<UserInfo> currentLocalContext = new InheritableThreadLocal<>();

    public static UserInfo get() {
        return currentLocalContext.get();
    }

    public static void set(UserInfo context) {
        currentLocalContext.set(context);
    }

    public static void unset() {
        currentLocalContext.remove();
    }
}