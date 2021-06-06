package com.xuegao.luanqibazao_1.jdk8.lang.reflect;

import com.xuegao.luanqibazao_1.domain.UserInfo;

import java.lang.reflect.Field;

/**
 * <br/> @ClassName：FiedTest
 * <br/> @Description：
 * <br/> @date：2021/6/2 11:52
 */
public class FieldTest {
    public static void main(String[] args) throws IllegalAccessException {
        UserInfo userInfo = new UserInfo();
        userInfo.setId("id");
        userInfo.setSex("sex");
        userInfo.setName("name");
        // userInfo.setAge(18);
        userInfo.setAge(null);
        userInfo.setAddress("address");
        Field[] fields = userInfo.getClass().getDeclaredFields();
        for (Field field : fields) {
            if ("serialVersionUID".equals(field.getName())) {
                continue;
            }
            field.setAccessible(Boolean.TRUE);
            System.out.println("属性名：" + field.getName());
            System.out.println("属性类型：" + field.getGenericType());
            if (field.get(userInfo) == null) {
                continue;
            }

            System.out.println("属性值：" + field.get(userInfo).toString());
            System.out.println();
        }
    }

}