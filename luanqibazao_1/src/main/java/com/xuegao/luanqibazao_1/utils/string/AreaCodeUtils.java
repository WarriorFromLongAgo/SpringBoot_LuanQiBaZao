package com.xuegao.luanqibazao_1.utils.string;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class AreaCodeUtils {
    /**
     * checkAreaCode
     * 检查区号，一个还是多个
     *
     * @param inputAreaCode:
     * @param numFlag:       true 一个 false 多个
     * @return void
     * @date 2022/5/13 16:44
     */
    public static void checkAreaCode(String inputAreaCode, String separator) {
        if (StringUtils.isBlank(inputAreaCode)) {
            throw new RuntimeException("区号不能为空");
        }

        String[] areaCodeArr = inputAreaCode.split(separator);
        for (String areaCode : areaCodeArr) {
            // 20220513,已经出现了，特殊的区号，指五位数的
            if (areaCode.length() > 5) {
                throw new RuntimeException(areaCode + "区号不合法");
            }
            boolean matchFlag = Pattern.matches("^0[0-9]{2,3}(-0[0-9]{2,3}){0,49}$", areaCode);
            if (!matchFlag) {
                throw new RuntimeException(areaCode + "区号不合法");
            }
        }
    }

    public static void main(String[] args) {
        checkAreaCode("0755-0755-0755-", "-");
    }
}
