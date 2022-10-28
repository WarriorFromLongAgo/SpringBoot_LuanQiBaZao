package com.xuegao.luanqibazao_1.jdk8.util.stream;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.xuegao.luanqibazao_1.domain.UserInfo;
import io.micrometer.core.instrument.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger log = LoggerFactory.getLogger(ListToMap.class);

    public static void main(String[] args) {
        extracted();
    }

    private static void extracted() {
        List<UserInfo> userInfoList = Lists.newArrayList();
        for (int i = 0; i < 3; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(String.valueOf(i));
            userInfoList.add(userInfo);
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setId("1");
        userInfoList.add(userInfo);
        System.out.println(JSON.toJSONString(userInfoList));
        Map<String, UserInfo> collect = userInfoList.stream().collect(Collectors.toMap(UserInfo::getId, a -> a, (k1, k2) -> k1));
        System.out.println(JSON.toJSONString(collect));
        // Exception in thread "main" java.lang.IllegalStateException: Duplicate key com.xuegao.luanqibazao_1.domain.UserInfo@6e3c1e69
        Map<String, UserInfo> collect2 = userInfoList.stream().collect(Collectors.toMap(UserInfo::getId, Function.identity()));
        System.out.println(JSON.toJSONString(collect2));
    }

    public static void listToMap2() {
        List<UserInfo> userInfoList = Lists.newArrayList();
        for (int i = 0; i < 3; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(i + "/" + (i + 10));
            userInfoList.add(userInfo);
        }
        log.info("[SpringBoot_LuanQiBaZao][ListToMap][listToMap2][={}]", JSON.toJSONString(userInfoList));
    }


}