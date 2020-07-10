package com.xuegao.luanqibazao_1.serialization;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.xuegao.luanqibazao_1.domain.UserInfo;
import com.xuegao.luanqibazao_1.domain.UserVo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.serialization
 * <br/> @ClassName：ObjectToMap
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/7/10 15:09
 */
public class ObjectToMap {
    // {address=d162d2c3-efb7-41d3-8296-9cfab56deac5, sex=d162d2c3-efb7-41d3-8296-9cfab56deac5, name=d162d2c3-efb7-41d3-8296-9cfab56deac5, id=d162d2c3-efb7-41d3-8296-9cfab56deac5, age=0}
    // {address=d162d2c3-efb7-41d3-8296-9cfab56deac5, sex=d162d2c3-efb7-41d3-8296-9cfab56deac5, name=d162d2c3-efb7-41d3-8296-9cfab56deac5, id=d162d2c3-efb7-41d3-8296-9cfab56deac5, age=999999}
    // 集合大小参数验证 1000000 testFastJson 耗时：5788 ms

    public static void main(String[] args) {
        //  这里拿100w数据做数据初始化
        List<UserInfo> userList = new ArrayList<>();
        String uuid = UUID.randomUUID().toString();
        for (int i = 0; i < 1000000; i++) {
            userList.add(new UserInfo(uuid, uuid, i, uuid, uuid));
        }
        System.out.println(userList.get(0));

        testFastJson(userList);
    }

    public static void testFastJson(List<UserInfo> userList) {
        long start = System.currentTimeMillis();
        List<Map<String, Object>> list2 = JSON.parseObject(JSONObject.toJSONString(userList), new TypeReference<List<Map<String, Object>>>() {
        });
        long end = System.currentTimeMillis();
        System.out.println(list2.get(0));
        System.out.println(list2.get(list2.size() - 1));
        System.out.println("集合大小参数验证 " + list2.size() + " testFastJson 耗时：" + (end - start) + " ms");
    }
}