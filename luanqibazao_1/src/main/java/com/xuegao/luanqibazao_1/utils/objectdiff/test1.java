package com.xuegao.luanqibazao_1.utils.objectdiff;

import com.xuegao.luanqibazao_1.domain.ObjectDiff;
import com.xuegao.luanqibazao_1.domain.UserInfo;
import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class test1 {

    // <dependency>
    //         <groupId>de.danielbechler</groupId>
    //         <artifactId>java-object-diff</artifactId>
    //         <version>0.95</version>
    //     </dependency>


    public static void main(String[] args) {
        ObjectDiff workingObject = new ObjectDiff();
        workingObject.setId(1);
        workingObject.setName("1");
        UserInfo userInfo = new UserInfo();
        userInfo.setBeginTime("work beginTime");
        workingObject.setUserInfo(userInfo);
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(userInfo);
        workingObject.setUserInfoList(userInfoList);

        ObjectDiff baseObject = new ObjectDiff();
        baseObject.setId(1);
        baseObject.setName("2");
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setBeginTime("base beginTime");
        baseObject.setUserInfo(userInfo2);
        List<UserInfo> userInfoList2 = new ArrayList<>();
        userInfoList2.add(userInfo2);
        baseObject.setUserInfoList(userInfoList2);

        DiffNode root = ObjectDifferBuilder.buildDefault().compare(workingObject, baseObject);
        Set<String> categories = root.getCategories();
        System.out.println(root);

    }


}
