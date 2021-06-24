package com.xuegao.luanqibazao_1.jdk8.util.stream;

import com.google.common.collect.Lists;
import com.xuegao.luanqibazao_1.domain.UserInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <br/> @ClassName：ListToMap
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/6/21 13:03
 */
public class ListToMap {
    public static void main(String[] args) {
        List<UserInfo> userInfoList = Lists.newArrayList();
        for (int i = 0; i < 3; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(String.valueOf(i));
            userInfoList.add(userInfo);
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setId("1");
        userInfoList.add(userInfo);
        System.out.println(userInfoList);
        Map<String, UserInfo> collect = userInfoList.stream().collect(Collectors.toMap(UserInfo::getId, a -> a, (k1, k2) -> k1));
        System.out.println(collect);
    }
}