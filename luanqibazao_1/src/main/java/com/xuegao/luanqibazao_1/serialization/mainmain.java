package com.xuegao.luanqibazao_1.serialization;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.xuegao.luanqibazao_1.domain.UserInfo;
import com.xuegao.luanqibazao_1.domain.UserVo;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.serialization
 * <br/> @ClassName：mainmain
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/7/10 14:31
 */
public class mainmain {

    // UserVo{id='null', name='null', age=null, address='null', sex='null'}
    // 集合大小参数验证1000000Apache的BeanUtils耗时：427ms

    // UserVo{id='b5e0ae58-b213-43a4-a95c-ec9aad8c3f24', name='b5e0ae58-b213-43a4-a95c-ec9aad8c3f24', age=0, address='b5e0ae58-b213-43a4-a95c-ec9aad8c3f24', sex='b5e0ae58-b213-43a4-a95c-ec9aad8c3f24'}
    // 集合大小参数验证1000000Spring的BeanUtils耗时：404ms

    // UserVo{id='695b3581-4f92-4a15-9817-462e538a101c', name='695b3581-4f92-4a15-9817-462e538a101c', age=0, address='695b3581-4f92-4a15-9817-462e538a101c', sex='695b3581-4f92-4a15-9817-462e538a101c'}
    // 集合大小参数验证1000000mapStruct耗时：18ms

    // UserVo{id='d8b48051-6033-4a64-a32d-54c82eeca1ab', name='d8b48051-6033-4a64-a32d-54c82eeca1ab', age=0, address='d8b48051-6033-4a64-a32d-54c82eeca1ab', sex='d8b48051-6033-4a64-a32d-54c82eeca1ab'}
    // 集合大小参数验证 1000000 testFastJson 耗时：2962 ms

    public static void main(String[] args) {
        //这里拿100w数据做数据初始化
        List<UserInfo> userList = new ArrayList<>();
        String uuid = UUID.randomUUID().toString();
        for (int i = 0; i < 1000000; i++) {
            userList.add(new UserInfo(uuid, uuid, i, uuid, uuid));
        }
        System.out.println(userList.get(0));
        // testBeanUtils(userList);
        // testSpringBeanUtils(userList);
        // testMapStruct(userList);
        testFastJson(userList);
    }

    /**
     * Apache的BeanUtils
     *
     * @param userList
     */
    public static void testBeanUtils(List<UserInfo> userList) {
        long start = System.currentTimeMillis();
        List<UserVo> userVos = new ArrayList<>();
        userList.forEach(item -> {
            UserVo userVo = new UserVo();
            try {
                BeanUtils.copyProperties(userVo, item);
                userVos.add(userVo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println(userVos.get(0));
        System.out.println("集合大小参数验证" + userVos.size() + "Apache的BeanUtils耗时：" + (end - start) + "ms");
    }

    /**
     * Spring的BeanUtils
     *
     * @param userList
     */
    public static void testSpringBeanUtils(List<UserInfo> userList) {
        long start = System.currentTimeMillis();
        List<UserVo> userVos = new ArrayList<>();
        userList.forEach(item -> {
            UserVo userVo = new UserVo();
            try {
                org.springframework.beans.BeanUtils.copyProperties(item, userVo);
                userVos.add(userVo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println(userVos.get(0));
        System.out.println("集合大小参数验证" + userVos.size() + "Spring的BeanUtils耗时：" + (end - start) + "ms");
    }

    /**
     * mapStruct拷贝
     *
     * @param userList
     */
    public static void testMapStruct(List<UserInfo> userList) {
        long start = System.currentTimeMillis();
        List<UserVo> userVos = Mappers.getMapper(UserTransfer.class).entityToVo(userList);
        long end = System.currentTimeMillis();
        System.out.println(userVos.get(0));
        System.out.println("集合大小参数验证" + userVos.size() + "mapStruct耗时：" + (end - start) + "ms");
    }

    public static void testFastJson(List<UserInfo> userList) {
        Type type = new TypeReference<List<UserVo>>() {
        }.getType();
        long start = System.currentTimeMillis();
        List<UserVo> userVos = JSONObject.parseObject(JSONObject.toJSONString(userList), type);
        // List<UserVo> userVos = JSON.parseObject(JSONObject.toJSONString(userList), new TypeReference<List<UserInfo>>() {
        // });
        // List<UserVo> userVos = JSONObject.parseObject(JSONObject.toJSONString(userList), new TypeReference<>(UserVo.class));
        long end = System.currentTimeMillis();
        System.out.println(userVos.get(0));
        System.out.println("集合大小参数验证 " + userVos.size() + " testFastJson 耗时：" + (end - start) + " ms");

    }

}