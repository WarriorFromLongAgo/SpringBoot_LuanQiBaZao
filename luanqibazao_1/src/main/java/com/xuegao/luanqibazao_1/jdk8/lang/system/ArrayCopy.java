package com.xuegao.luanqibazao_1.jdk8.lang.system;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.lang.system
 * <br/> @ClassName：ArrayCopy
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/02/04 11:45
 */
public class ArrayCopy {
    public static void main(String[] args) {
        String[] strings = new String[]{"1"};
        String[] strings1 = Arrays.copyOf(strings, 2);
        System.out.println(Lists.newArrayList(strings1));

        String[] strings2 = new String[]{"1", "2", "3"};
        String[] strings3 = Arrays.copyOf(strings2, 4);
        System.out.println(Lists.newArrayList(strings3));

        String[] strings6 = Arrays.copyOf(strings, 2, String[].class);
        System.out.println(Lists.newArrayList(strings6));

        String[] strings5 = copyOf(strings, 2);
        System.out.println(Lists.newArrayList(strings5));

    }

    private static String[] copyOf(String[] original, int newLength) {
        String[] returnStr = new String[newLength];
        System.arraycopy(original, 0, returnStr, 0, original.length);
        System.out.println(Lists.newArrayList(returnStr));

        for (int i = 0; i < returnStr.length; i++) {
            String s = returnStr[i];
            if (StringUtils.isEmpty(s)) {
                returnStr[i] = "";
            }
        }
        return returnStr;
    }
}