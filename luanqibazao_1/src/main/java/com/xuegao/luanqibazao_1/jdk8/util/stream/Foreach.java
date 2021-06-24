package com.xuegao.luanqibazao_1.jdk8.util.stream;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Consumer;

/**
 * <br/> @ClassName：Foreach
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/6/8 13:25
 */
public class Foreach {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("1", "2", "3", "4", "5");
        boolean flag = false;
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                if("3".equals(s)){
                    return;
                }
                System.out.println(s);
            }
        });
    }
}