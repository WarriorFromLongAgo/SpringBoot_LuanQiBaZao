package com.xuegao.luanqibazao_1.jdk8.util.stream;

import com.xuegao.luanqibazao_1.domain.UserInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <br/> @ClassName：CollectorsTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/5/22 19:20
 */
public class CollectorsTest {
    public static void main(String[] args) {
        List<UserInfo> userInfoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserInfo userInfo = new UserInfo();
            String s = String.valueOf(i);
            userInfo.setId(s + "id");
            userInfo.setAddress(s + "add");
            userInfo.setName(s + "name");
            userInfo.setSex(s + "sex");
            userInfo.setAge(i);
            userInfoList.add(userInfo);
        }
        for (int i = 0; i < 10; i++) {
            UserInfo userInfo = new UserInfo();
            String s = String.valueOf(i);
            userInfo.setId(s + "id");
            userInfo.setAddress(s + "add");
            userInfo.setName(s + "name");
            userInfo.setSex(s + "sex");
            userInfo.setAge(i);
            userInfoList.add(userInfo);
        }
        Map<String, List<UserInfo>> collect = userInfoList.stream().collect(Collectors.groupingBy(userInfo -> userInfo.getName()));
        collect.forEach((s, userInfos) -> System.out.println(s + "===========" + userInfos));
    }
}