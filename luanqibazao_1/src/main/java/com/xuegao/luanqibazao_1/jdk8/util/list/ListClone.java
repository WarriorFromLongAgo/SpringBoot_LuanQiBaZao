// package com.xuegao.luanqibazao_1.jdk8.util.list;
//
// import com.alibaba.fastjson.JSON;
// import com.google.common.collect.Lists;
// import com.xuegao.luanqibazao_1.domain.UserInfo;
//
// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.Collections;
// import java.util.List;
//
// /**
//  * @author xuegao
//  * @version 1.0
//  * @date 2022/2/15 19:38
//  */
// public class ListClone {
//     public static void main(String[] args) {
//         List<UserInfo> userInfoList = new ArrayList<>(3);
//         for (int i = 0; i < 3; i++) {
//             UserInfo userInfo = new UserInfo();
//             userInfo.setId(String.valueOf(i + 1));
//             userInfo.setName("name" + i);
//             userInfo.setAge(i + 1);
//             userInfo.setSex(i % 2 == 0 ? "男" : "女");
//             userInfoList.add(userInfo);
//         }
//         System.out.println("1 = " + JSON.toJSONString(userInfoList));
//         for (UserInfo userInfo : userInfoList) {
//             userInfo.setAge(userInfo.getAge() * 10);
//         }
//         System.out.println("2 = " + JSON.toJSONString(userInfoList));
//
//         List<UserInfo> userInfoListCopy = new ArrayList<>();
//         Collections.addAll(userInfoListCopy, userInfoList.toArray());
//         System.out.println("3 = " + JSON.toJSONString(userInfoListCopy));
//         for (UserInfo userInfo : userInfoListCopy) {
//             userInfo.setId(userInfo.getId() + 10);
//         }
//         System.out.println("4 = " + JSON.toJSONString(userInfoListCopy));
//         System.out.println("5 = " + JSON.toJSONString(userInfoList));
//     }
//
//     private static void extracted() {
//         ArrayList<String> strings = Lists.newArrayList("a", "b", "c");
//         System.out.println("1 = " + strings);
//         List<String> strList1 = new ArrayList<>(strings);
//         System.out.println("2 = " + strList1);
//         for (String s : strList1) {
//             if ("b".equals(s)) {
//                 s = "bb";
//             }
//         }
//         System.out.println("1 = " + strings);
//         System.out.println("2 = " + strList1);
//     }
// }