package com.xuegao.luanqibazao_1.jdk8.optional;

import com.xuegao.luanqibazao_1.domain.UserInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.util.optional
 * <br/> @ClassName：Optional
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/12/28 10:18
 */
public class OptionalTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        getXXX(map);

        Map<String, String> map2 = null;
        getXXX(map2);

        UserInfo userInfo = new UserInfo();
        getXXX(userInfo);

        UserInfo userInfo2 = null;
        getXXX(userInfo2);
    }

    private static void getXXX(Map<String, String> params) {
        Map<String, String> map = Optional.ofNullable(params).orElse(new HashMap<>());
        System.out.println(map);
    }

    private static void getXXX(UserInfo userInfo) {

    }
}