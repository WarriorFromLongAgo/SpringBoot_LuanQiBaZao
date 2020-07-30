package com.xuegao.luanqibazao_1.fasnhe;

import com.xuegao.luanqibazao_1.domain.UserInfo;

import java.lang.reflect.Field;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.fasnhe
 * <br/> @ClassName：反射判断对象属性是否为空
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/7/30 16:10
 */
public class 反射判断对象属性是否为空 {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId("20");
        userInfo.setName("22222");

        // Field[] userInfoField = userInfo.getClass().getDeclaredFields();
        // for (Field field : userInfoField) {
        //     field.setAccessible(true);
        //     System.out.println(field.getName() + "===" + field.get);
        //
        // }
    }
}