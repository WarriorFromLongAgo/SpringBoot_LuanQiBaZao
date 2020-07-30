package com.xuegao.luanqibazao_1.AToB;

import com.alibaba.fastjson.JSONObject;
import com.xuegao.luanqibazao_1.domain.UserInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.util.StopWatch;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.AToB
 * <br/> @ClassName：MapToBean
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/7/30 16:18
 */
public class MapToBean {
    public static void main(String[] args) {
        List<UserInfo> userInfoList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(i + "");
            userInfo.setName(i + "");
            userInfo.setAge(i);
            userInfo.setSex(i + "");
            userInfo.setAddress(i + "");
            userInfoList.add(userInfo);
        }
        System.out.println(userInfoList.size());
        // List<Map<String, String>> mapList = mapKeyset(userInfoList);
        // mapList.get(0).forEach((key, value) -> System.out.println(key + "===" + value));

        // List<Map<String, String>> mapList1 = apacheBeanUtils(userInfoList);
        // mapList1.get(0).forEach((key, value) -> System.out.println(key + "===" + value));

        // List<Map<String, String>> mapList = apacheBeanUtils2(userInfoList);
        // mapList.get(0).forEach((key, value) -> System.out.println(key + "===" + value));

        List<Map<String, String>> mapList = fastJson(userInfoList);
        mapList.get(0).forEach((key, value) -> System.out.println(key + "===" + value));
    }

    // 80-100w ns
    public static List<Map<String, String>> mapKeyset(List<UserInfo> userInfoList) {
        List<Map<String, String>> mapList = new ArrayList<>();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (UserInfo userInfo : userInfoList) {
            Map<String, String> map = new HashMap<>();
            Field[] declaredFields = userInfo.getClass().getDeclaredFields();
            try {
                for (Field field : declaredFields) {
                    // （此处如果不设置 无法获取对象的私有属性）
                    field.setAccessible(true);
                    map.put(field.getName(), String.valueOf(field.get(userInfo)));
                    mapList.add(map);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        stopWatch.stop();
        System.out.println("stopWatch.prettyPrint():" + stopWatch.prettyPrint());
        System.out.println("stopWatch.getTotalTimeMillis():" + stopWatch.getTotalTimeMillis());
        System.out.println("stopWatch.getLastTaskName():" + stopWatch.getLastTaskName());
        System.out.println("stopWatch.getLastTaskInfo():" + stopWatch.getLastTaskInfo());
        System.out.println("stopWatch.getTaskCount():" + stopWatch.getTaskCount());
        return mapList;
    }

    // 106870500 1e ns
    public static List<Map<String, String>> apacheBeanUtils(List<UserInfo> userInfoList) {
        List<Map<String, String>> mapList = new ArrayList<>();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        try {
            for (UserInfo userInfo : userInfoList) {
                Map<String, String> map = BeanUtils.describe(userInfo);
                mapList.add(map);
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        stopWatch.stop();
        System.out.println("stopWatch.prettyPrint():" + stopWatch.prettyPrint());
        System.out.println("stopWatch.getTotalTimeMillis():" + stopWatch.getTotalTimeMillis());
        System.out.println("stopWatch.getLastTaskName():" + stopWatch.getLastTaskName());
        System.out.println("stopWatch.getLastTaskInfo():" + stopWatch.getLastTaskInfo());
        System.out.println("stopWatch.getTaskCount():" + stopWatch.getTaskCount());
        return mapList;
    }

    // 112712700 1e ns
    public static List<Map<String, String>> apacheBeanUtils2(List<UserInfo> userInfoList) {
        List<Map<String, String>> mapList = new ArrayList<>();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        try {
            for (UserInfo userInfo : userInfoList) {
                Map<String, String> map = new HashMap<>();
                BeanUtils.populate(userInfo, map);
                mapList.add(map);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        stopWatch.stop();
        System.out.println("stopWatch.prettyPrint():" + stopWatch.prettyPrint());
        System.out.println("stopWatch.getTotalTimeMillis():" + stopWatch.getTotalTimeMillis());
        System.out.println("stopWatch.getLastTaskName():" + stopWatch.getLastTaskName());
        System.out.println("stopWatch.getLastTaskInfo():" + stopWatch.getLastTaskInfo());
        System.out.println("stopWatch.getTaskCount():" + stopWatch.getTaskCount());
        return mapList;
    }

    // 95191700 1e ns
    public static List<Map<String, String>> fastJson(List<UserInfo> userInfoList) {
        List<Map<String, String>> mapList = new ArrayList<>();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (UserInfo userInfo : userInfoList) {
            Map map = JSONObject.parseObject(JSONObject.toJSONString(userInfo), Map.class);
            mapList.add(map);
        }
        stopWatch.stop();
        System.out.println("stopWatch.prettyPrint():" + stopWatch.prettyPrint());
        System.out.println("stopWatch.getTotalTimeMillis():" + stopWatch.getTotalTimeMillis());
        System.out.println("stopWatch.getLastTaskName():" + stopWatch.getLastTaskName());
        System.out.println("stopWatch.getLastTaskInfo():" + stopWatch.getLastTaskInfo());
        System.out.println("stopWatch.getTaskCount():" + stopWatch.getTaskCount());
        return mapList;
    }
}