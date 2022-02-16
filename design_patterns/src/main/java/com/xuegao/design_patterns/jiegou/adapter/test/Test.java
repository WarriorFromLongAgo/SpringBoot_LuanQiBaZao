package com.xuegao.design_patterns.jiegou.adapter.test;

import com.xuegao.design_patterns.domain.UserInfo;

import java.util.*;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/2/16 19:14
 */
public class Test {
    public static void main(String[] args) {
        Hashtable<String, String> set = new Hashtable<>();

        List<UserInfo> userInfoList = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            UserInfo userInfo = new UserInfo();
            userInfoList.add(userInfo);
        }


        Collections.list(set.elements());
        Arrays.asList(userInfoList);


    }
}