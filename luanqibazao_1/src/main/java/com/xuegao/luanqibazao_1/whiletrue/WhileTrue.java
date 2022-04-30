package com.xuegao.luanqibazao_1.whiletrue;

import com.xuegao.luanqibazao_1.domain.UserInfo;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.whiletrue
 * <br/> @ClassName：WhileTrue
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2022/4/29 22:35
 */
public class WhileTrue {
    private static final int NUM = 10;

    public static void main(String[] args) {
        int count = 0;
        while (count++ < 100) {
            System.out.println("count = " + count);
        }

        List<UserInfo> list = getList(23);
        System.out.println(list);

        int minId = 0;
        while (true) {
            System.out.println("minId = " + minId);
            List<UserInfo> tempIdList;
            if (NUM + minId < list.size()) {
                tempIdList = list.subList(minId, minId + NUM);
            } else {
                int tempIndex = list.size();
                tempIdList = list.subList(minId, tempIndex);
            }
            if (ObjectUtils.isEmpty(tempIdList)) {
                break;
            }
            // minId = tempIdList.get(tempIdList.size() - 1);
            minId = tempIdList.get(0).getAge();

            System.out.println("1111 left = " + tempIdList.get(0));
            System.out.println("11111 right = " + tempIdList.get(tempIdList.size() - 1));
            System.out.println(tempIdList);

            method();

            if (tempIdList.size() < NUM) {
                break;
            }
        }
        System.out.println("end");
    }

    public static void method() {
        System.out.println("111111111111");
        try {
            // TimeUnit.SECONDS.sleep(1);
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<UserInfo> getList(int size) {
        List<UserInfo> userInfoList = new ArrayList<>(200);
        for (int i = 1; i < size; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setAge(i);
            userInfoList.add(userInfo);
        }
        return userInfoList;
    }
}