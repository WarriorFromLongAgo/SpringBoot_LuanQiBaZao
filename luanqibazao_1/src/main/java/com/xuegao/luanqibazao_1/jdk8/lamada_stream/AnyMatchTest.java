package com.xuegao.luanqibazao_1.jdk8.lamada_stream;

import com.xuegao.luanqibazao_1.domain.UserInfo;
import lombok.SneakyThrows;
import org.springframework.util.ObjectUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @date 2021/11/25 21:08
 */
public class AnyMatchTest {
    public static void main(String[] args) {
        String str1 = "a,b,c";
        String str2 = "b,d";
        String[] split1 = str1.split(",");
        String[] split2 = str2.split(",");
        boolean anyMatch = Arrays.stream(split1).anyMatch(new Predicate<String>() {
            @Override
            public boolean test(String s1) {

                boolean b = Arrays.stream(split2).anyMatch(new Predicate<String>() {
                    @Override
                    public boolean test(String s2) {
                        System.out.println("s1 = " + s1 + ", s2 = " + s2);
                        System.out.println("s1.equals(s2) = " + s1.equals(s2));
                        return s1.equals(s2);
                    }
                });
                System.out.println("b == " + b);
                System.out.println(" ===================== ");
                return b;
            }
        });
        System.out.println("anyMatch = " + anyMatch);
    }

    private static void extracted() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId("1");
        userInfo.setBeginTime("2022-01-01 00:00:00");
        userInfo.setEndTime("2022-02-01 00:00:00");

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setId("2");
        userInfo2.setBeginTime("2022-02-02 00:00:00");
        userInfo2.setEndTime("2022-03-01 00:00:00");

        UserInfo db3 = new UserInfo();
        db3.setId("3");
        db3.setBeginTime("2022-02-02 00:00:00");
        db3.setEndTime("2022-03-01 00:00:00");

        List<UserInfo> userInfoList = Arrays.asList(userInfo, userInfo2, db3);
        int index = 0;
        for (UserInfo info : userInfoList) {
            info.setIndex(index++);
        }


        boolean b = userInfoList.stream()
                .anyMatch(new Predicate<UserInfo>() {
                    @SneakyThrows
                    @Override
                    public boolean test(UserInfo oneUserInfo) {
                        for (UserInfo twoUserInfo : userInfoList) {
                            if (oneUserInfo.getIndex().equals(twoUserInfo.getIndex())) {
                                continue;
                            }
                            if (!ObjectUtils.isEmpty(twoUserInfo.getId())
                                    && !ObjectUtils.isEmpty(oneUserInfo.getId())) {
                                if (twoUserInfo.getId().equals(oneUserInfo.getId())) {
                                    continue;
                                }
                            }
                            String oneBeginTime = oneUserInfo.getBeginTime();
                            String oneEndTime = oneUserInfo.getEndTime();
                            String twoBeginTime = twoUserInfo.getBeginTime();
                            String twoEndTime = twoUserInfo.getEndTime();
                            if (ObjectUtils.isEmpty(oneEndTime)) {
                                oneEndTime = "2099-12-31 12:59:59";
                            }
                            if (ObjectUtils.isEmpty(twoEndTime)) {
                                twoEndTime = "2099-12-31 12:59:59";
                            }
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date oneBeginTimeDate = dateFormat.parse(oneBeginTime);
                            long time1 = oneBeginTimeDate.getTime();
                            Date oneEndTimeDate = dateFormat.parse(oneEndTime);
                            long time11 = oneEndTimeDate.getTime();

                            Date twoBeginTimeDate = dateFormat.parse(twoBeginTime);
                            long time2 = twoBeginTimeDate.getTime();
                            Date twoEndTimeDate = dateFormat.parse(twoEndTime);
                            long time22 = twoEndTimeDate.getTime();

                            if (Math.max(time1, time2) <= Math.min(time11, time22)) {
                                return true;
                            }
                        }
                        return false;
                    }
                });
        System.out.println(b);
    }

    private static void test1() {
        String[] str1 = {"a", "c", "d", "e"};
        String[] str2 = {"f", "b"};
        Set<String> dbSet = Arrays.stream(str1).collect(Collectors.toSet());
        Set<String> dbSet2 = Arrays.stream(str2).collect(Collectors.toSet());
        boolean b = dbSet.stream().anyMatch(dbSet2::contains);
        System.out.println(b);
    }

    private static void test2() {
        String[] str1 = {"a", "c", "d", "e", "b"};
        String[] str2 = {"c", "f", "b"};
        Set<String> dbSet = Arrays.stream(str1).collect(Collectors.toSet());
        Set<String> dbSet2 = Arrays.stream(str2).collect(Collectors.toSet());
        // dbSet.retainAll(dbSet2);
        // System.out.println(dbSet);

        dbSet2.retainAll(dbSet);
        System.out.println(dbSet2);

        String collect = dbSet2.stream().collect(Collectors.joining("/"));
        System.out.println(collect);

        String collect2 = String.join("/", dbSet2);
        System.out.println(collect2);
    }
}