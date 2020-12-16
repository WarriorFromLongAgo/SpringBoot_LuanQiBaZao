package com.xuegao.luanqibazao_1.convert.serialization;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.xuegao.luanqibazao_1.domain.UserInfo;
import com.xuegao.luanqibazao_1.domain.UserVO;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.serialization
 * <br/> @ClassName：mainmain
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/7/10 14:31
 */
public class mainmain {

    // UserInfo{id='327cb8ec-f688-497c-994a-495d60c8a55f', name='327cb8ec-f688-497c-994a-495d60c8a55f', age=0, address='327cb8ec-f688-497c-994a-495d60c8a55f', sex='327cb8ec-f688-497c-994a-495d60c8a55f'}
    // UserVo{id='327cb8ec-f688-497c-994a-495d60c8a55f', name='327cb8ec-f688-497c-994a-495d60c8a55f', age=0, address='327cb8ec-f688-497c-994a-495d60c8a55f', sex='327cb8ec-f688-497c-994a-495d60c8a55f'}
    // 集合大小参数验证1000000Apache的BeanUtils耗时：559ms

    // UserInfo{id='04782ea5-dbc1-4dfb-a06d-9c474a0e87cf', name='04782ea5-dbc1-4dfb-a06d-9c474a0e87cf', age=0, address='04782ea5-dbc1-4dfb-a06d-9c474a0e87cf', sex='04782ea5-dbc1-4dfb-a06d-9c474a0e87cf'}
    // UserVo{id='04782ea5-dbc1-4dfb-a06d-9c474a0e87cf', name='04782ea5-dbc1-4dfb-a06d-9c474a0e87cf', age=0, address='04782ea5-dbc1-4dfb-a06d-9c474a0e87cf', sex='04782ea5-dbc1-4dfb-a06d-9c474a0e87cf'}
    // 集合大小参数验证1000000Spring的BeanUtils耗时：571ms

    // UserInfo{id='a653ace2-3c3c-4bc5-ac23-0a19171e9798', name='a653ace2-3c3c-4bc5-ac23-0a19171e9798', age=0, address='a653ace2-3c3c-4bc5-ac23-0a19171e9798', sex='a653ace2-3c3c-4bc5-ac23-0a19171e9798'}
    // UserVo{id='a653ace2-3c3c-4bc5-ac23-0a19171e9798', name='a653ace2-3c3c-4bc5-ac23-0a19171e9798', age=0, address='a653ace2-3c3c-4bc5-ac23-0a19171e9798', sex='a653ace2-3c3c-4bc5-ac23-0a19171e9798'}
    // 集合大小参数验证1000000 mapStruct 耗时：90ms

    // UserInfo{id='d703eaa5-8b37-4223-a809-3744193ff4c0', name='d703eaa5-8b37-4223-a809-3744193ff4c0', age=0, address='d703eaa5-8b37-4223-a809-3744193ff4c0', sex='d703eaa5-8b37-4223-a809-3744193ff4c0'}
    // UserVo{id='d703eaa5-8b37-4223-a809-3744193ff4c0', name='d703eaa5-8b37-4223-a809-3744193ff4c0', age=0, address='d703eaa5-8b37-4223-a809-3744193ff4c0', sex='d703eaa5-8b37-4223-a809-3744193ff4c0'}
    // 集合大小参数验证 1000000 testFastJson 耗时：4350 ms

    // UserInfo{id='bd6f06b2-f5be-47c7-bc9d-544da08bafa6', name='bd6f06b2-f5be-47c7-bc9d-544da08bafa6', age=0, address='bd6f06b2-f5be-47c7-bc9d-544da08bafa6', sex='bd6f06b2-f5be-47c7-bc9d-544da08bafa6'}
    // UserVo{id='bd6f06b2-f5be-47c7-bc9d-544da08bafa6', name='bd6f06b2-f5be-47c7-bc9d-544da08bafa6', age=0, address='bd6f06b2-f5be-47c7-bc9d-544da08bafa6', sex='bd6f06b2-f5be-47c7-bc9d-544da08bafa6'}
    // 集合大小参数验证 1000000 testHutool 耗时：3291 ms

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
        // testFastJson(userList);
        // testHutool(userList);
        testsout();
    }

    /**
     * Apache的BeanUtils
     *
     * @param userList
     */
    public static void testBeanUtils(List<UserInfo> userList) {
        long start = System.currentTimeMillis();
        List<UserVO> userVOS = new ArrayList<>();
        userList.forEach(item -> {
            UserVO userVo = new UserVO();
            try {
                BeanUtils.copyProperties(item, userVo);
                userVOS.add(userVo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println(userVOS.get(0));
        System.out.println("集合大小参数验证" + userVOS.size() + "Apache的BeanUtils耗时：" + (end - start) + "ms");
    }

    /**
     * Spring的BeanUtils
     *
     * @param userList
     */
    public static void testSpringBeanUtils(List<UserInfo> userList) {
        long start = System.currentTimeMillis();
        List<UserVO> userVOS = new ArrayList<>();
        userList.forEach(item -> {
            UserVO userVo = new UserVO();
            try {
                org.springframework.beans.BeanUtils.copyProperties(item, userVo);
                userVOS.add(userVo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println(userVOS.get(0));
        System.out.println("集合大小参数验证" + userVOS.size() + "Spring的BeanUtils耗时：" + (end - start) + "ms");
    }

    /**
     * mapStruct拷贝
     *
     * @param userList
     */
    public static void testMapStruct(List<UserInfo> userList) {
        long start = System.currentTimeMillis();
        List<UserVO> userVOS = Mappers.getMapper(UserTransfer.class).entityToVo(userList);
        long end = System.currentTimeMillis();
        System.out.println(userVOS.get(0));
        System.out.println("集合大小参数验证" + userVOS.size() + "mapStruct耗时：" + (end - start) + "ms");
    }

    public static void testFastJson(List<UserInfo> userList) {
        Type type = new TypeReference<List<UserVO>>() {
        }.getType();
        long start = System.currentTimeMillis();
        List<UserVO> userVOS = JSONObject.parseObject(JSONObject.toJSONString(userList), type);
        // List<UserVo> userVos = JSON.parseObject(JSONObject.toJSONString(userList), new TypeReference<List<UserInfo>>() {
        // });
        // List<UserVo> userVos = JSONObject.parseObject(JSONObject.toJSONString(userList), new TypeReference<>(UserVo.class));
        long end = System.currentTimeMillis();
        System.out.println(userVOS.get(0));
        System.out.println("集合大小参数验证 " + userVOS.size() + " testFastJson 耗时：" + (end - start) + " ms");

    }

    public static void testHutool(List<UserInfo> userList) {

        long start = System.currentTimeMillis();
        List<UserVO> userVOS = Convert.convert(new cn.hutool.core.lang.TypeReference<List<UserVO>>() {
        }, userList);

        long end = System.currentTimeMillis();
        System.out.println(userVOS.get(0));
        System.out.println("集合大小参数验证 " + userVOS.size() + " testHutool 耗时：" + (end - start) + " ms");

    }

    public static void testsout() {
        System.out.println("-----------------------------------");
    }

}