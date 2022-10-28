package com.xuegao.luanqibazao_1.utils.javers;

import com.xuegao.luanqibazao_1.domain.ObjectDiff;
import com.xuegao.luanqibazao_1.domain.UserInfo;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;

import java.util.ArrayList;
import java.util.List;

public class DiffTest {
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


        Javers javers = JaversBuilder.javers().build();


        Diff diff = javers.compare(workingObject, baseObject);
        boolean b = diff.hasChanges();
        System.out.println(diff);
        System.out.println(b);


    }
}
