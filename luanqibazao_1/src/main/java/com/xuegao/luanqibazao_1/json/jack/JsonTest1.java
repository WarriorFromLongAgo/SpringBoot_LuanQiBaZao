package com.xuegao.luanqibazao_1.json.jack;

import com.xuegao.luanqibazao_1.domain.UserInfo;

import java.util.ArrayList;

public class JsonTest1 {
    public static void main(String[] args) {


    }

    private static UserInfo getAccountByCardId(String cardId, ArrayList<UserInfo> userInfoList) {
        System.out.println("cardId = " + cardId);
        System.out.println("userInfoList = " + userInfoList);

        for (int i = 0; i < userInfoList.size(); i++) {
            UserInfo userInfo = userInfoList.get(i);
            System.out.println("i = " + i + ", userInfo" + userInfo);
            if (userInfo.getCardId().equals(cardId)) {
                return userInfo;
            }
        }
        return null;
    }
}
