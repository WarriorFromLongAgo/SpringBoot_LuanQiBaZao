package com.xuegao.luanqibazao_1.jdk8.lamada_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.lamada
 * <br/> @ClassName：foreach
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/20 11:18
 */
public class foreach {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("1", "2", "3"));
        stringList.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                if ("1".equals(s)) {
                    return;
                }
                System.out.println(s);
            }
        });
    }
}