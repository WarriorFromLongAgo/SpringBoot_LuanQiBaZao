package com.xuegao.luanqibazao_1.jdk8.other;

/**
 *
 * @author xuegao
 * @version 1.0
 * @date 2021/12/22 13:31
 */
public class AsmDaiLiInterfaceImpl implements AsmDaiLiInterface {
    @Override
    public boolean login(String username, String password) {
        System.out.println("username:" + username + " password:" + password);
        return false;
    }
}