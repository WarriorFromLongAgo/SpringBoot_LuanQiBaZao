package com.xuegao.luanqibazao_1.utils;

import com.xuegao.luanqibazao_1.common.Constants;
import org.apache.commons.lang3.StringUtils;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/1/14 20:30
 */
public class SectionKeyContain {
    public static void main(String[] args) {
        boolean flag1 = filterSectionValueListByInput("(1,2)", 1.0);
        boolean flag2 = filterSectionValueListByInput("[1,2)", 1.0);
        boolean flag3 = filterSectionValueListByInput("[1,2)", 2.0);
        boolean flag4 = filterSectionValueListByInput("[1,2]", 2.0);
        boolean flag5 = filterSectionValueListByInput("[1,2]", 3.0);
        boolean flag6 = filterSectionValueListByInput("(1,2]", 3.0);
        boolean flag7 = filterSectionValueListByInput("(2,+∞]", 3.0);

        System.out.println("flag1:" + flag1);
        System.out.println("flag2:" + flag2);
        System.out.println("flag3:" + flag3);
        System.out.println("flag4:" + flag4);
        System.out.println("flag5:" + flag5);
        System.out.println("flag6:" + flag6);
        System.out.println("flag7:" + flag7);
    }

    /**
     * 根据入参的重量和方数，过滤传入的 sectionValueList
     *
     * @param sectionKey:
     * @param input:      重量或者方数
     * @return boolean: true filter的时候需要留下来的
     * @author xuegao
     * @date 2022/1/14 19:33
     */
    public static boolean filterSectionValueListByInput(String sectionKey, Double input) {
        if (StringUtils.isBlank(sectionKey) || input == null) {
            return false;
        }
        boolean startsWith = sectionKey.startsWith(Constants.ARRAY_BEGIN_STR);
        boolean endsWith = sectionKey.endsWith(Constants.ARRAY_END_STR);
        sectionKey = sectionKey.replace(Constants.ARRAY_BEGIN_STR, "")
                .replace(Constants.ARRAY_END_STR, "")
                .replace(Constants.LEFT_PARENTHESIS, "")
                .replace(Constants.RIGHT_PARENTHESIS, "")
                .replace(Constants.DEFAULT_DEFINE_MAX, String.valueOf(Constants.COMMON_INT_1000_0000));
        String[] split = sectionKey.split(Constants.COMMA_SEPARATOR);
        if (split.length != 2) {
            return false;
        }
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);
        if (startsWith && endsWith) {
            return input >= start && input <= end;
        } else if (startsWith && !endsWith) {
            return input >= start && input < end;
        } else if (!startsWith && endsWith) {
            return input > start && input <= end;
        } else /*if (!startsWith && !endsWith)*/ {
            return input > start && input < end;
        }
    }
}