package com.xuegao.luanqibazao_1.jdk8.lang.system;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.ObjectUtils;
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

        String[] strings8 = new String[]{null, "1"};
        String[] strings7 = copyOf(strings8, 2);
        System.out.println(Lists.newArrayList(strings7));

        Object[] object1 = new Object[]{"1"};
        Object[] object2 = copyOf(object1, 2);
        System.out.println(Lists.newArrayList(object2));

        Object[] object3 = new Object[]{null, "1"};
        Object[] object4 = copyOf(object3, 2);
        System.out.println(Lists.newArrayList(object4));

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

    private static Object[] copyOf(Object[] original, int newLength) {
        Object[] returnObj = new Object[newLength];
        System.arraycopy(original, 0, returnObj, 0, original.length);
        System.out.println(Lists.newArrayList(returnObj));

        for (int i = 0; i < returnObj.length; i++) {
            Object s = returnObj[i];
            if (ObjectUtils.isEmpty(s)) {
                returnObj[i] = "";
            }
        }
        return returnObj;
    }
}