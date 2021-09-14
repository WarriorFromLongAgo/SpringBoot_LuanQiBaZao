package com.xuegao.luanqibazao_1;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * <br/> @ClassName：WhileUse
 * <br/> @Description：
 * <br/> @date：2021/9/14 19:04
 */
public class WhileUse {
    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList("1", "2", "3");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            System.out.println("aaaaaa = " + string);
            if ("2".equals(string)) {
                continue;
            }
        }
    }
}