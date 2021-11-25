package com.xuegao.luanqibazao_1.jdk8.lamada_stream.group;

import com.alibaba.fastjson.JSON;
import com.xuegao.luanqibazao_1.domain.UserInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @date 2021/11/25 17:58
 */
public class GroupByTest {
    public static void main(String[] args) {
        List<UserInfo> list = new ArrayList<>(10);
        for (int i = 0; i < 5; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId("1");
            userInfo.setName("name" + i);
            userInfo.setSex("1");
            list.add(userInfo);
        }
        for (int i = 10; i < 15; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId("2");
            userInfo.setName("name" + i);
            userInfo.setSex("2");
            list.add(userInfo);
        }
        Map<String, List<UserInfo>> collect = list.stream().collect(Collectors.groupingBy(new Function<UserInfo, String>() {
            @Override
            public String apply(UserInfo userInfo) {
                return userInfo.getId() + "-" + userInfo.getSex();
            }
        }));
        for (Map.Entry<String, List<UserInfo>> userInfoListEntry : collect.entrySet()) {
            System.out.println(JSON.toJSONString(userInfoListEntry));
        }
    }
}