package com.xuegao.luanqibazao_1.ali.ttl;

import com.xuegao.luanqibazao_1.common.ThreadPoolSpring;
import com.xuegao.luanqibazao_1.domain.UserInfo;

import java.util.concurrent.TimeUnit;

/**
 * @author xuegao
 * @version 1.0
 * @date 2021/12/24 11:20
 */
public class KyBusinessTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            // 模拟一直有外部请求，那么spring的线程池一直在运行，max20
            int finalI = i;
            ThreadPoolSpring.getInstance()
                    .execute(new Runnable() {
                                 @Override
                                 public void run() {
                                     ThreadLocal<UserInfo> userInfoThreadLocal = new InheritableThreadLocal<>();
                                     UserInfo userInfo = new UserInfo();
                                     userInfo.setAge(finalI);
                                     userInfoThreadLocal.set(userInfo);

                                 }
                             }
                    );
            // 每次睡眠1秒
            TimeUnit.SECONDS.sleep(1);
        }

        ThreadLocal<UserInfo> userInfoThreadLocal = new InheritableThreadLocal<>();


    }
}