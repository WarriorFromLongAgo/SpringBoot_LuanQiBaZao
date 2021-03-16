package com.xuegao.multi_thread2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2
 * <br/> @ClassName：thread1
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/7/28 23:42
 */
public class thread1 {
    private static List<String> stringList = new ArrayList<>();

    @Test
    public void Test() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(this::doAction, "func").start();
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(stringList);
    }

    public void doAction() {
        setStr();
    }

    public void setStr() {
        stringList.add("1-2");
    }
}