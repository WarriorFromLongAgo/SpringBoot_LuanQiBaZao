package com.xuegao.luanqibazao_1.jdk8.util.spliterators;


import com.xuegao.luanqibazao_1.domain.UserInfo;

import java.util.Arrays;
import java.util.Spliterator;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.util.spliterators
 * <br/> @ClassName：SpliteratorsTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2022/5/2 22:23
 */
public class SpliteratorsTest {
    public static void main(String[] args) {
        String[] stringArr = {"1", "2", "3"};
        Spliterator<String> stringSpliterator = Arrays.spliterator(stringArr);
        Spliterator<String> stringSpliterator1 = stringSpliterator.trySplit();

        UserInfo[] userInfos = new UserInfo[3];
        for (int i = 0; i < 3; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setAge(i);
            userInfos[i] = userInfo;
        }
        Spliterator<UserInfo> userSpliterator = Arrays.spliterator(userInfos);


    }
}