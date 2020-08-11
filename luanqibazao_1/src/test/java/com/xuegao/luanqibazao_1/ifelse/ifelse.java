package com.xuegao.luanqibazao_1.ifelse;

import org.apache.commons.lang3.StringUtils;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1
 * <br/> @ClassName：ifelse
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/3 14:00
 */
public class ifelse {
    public static void main(String[] args) {
        String aaa = "";
        String bbb = "";
        if (StringUtils.isBlank(aaa) && StringUtils.isBlank(bbb)) {
            System.out.println("都为空");
        }
        aaa = "";
        bbb = "aaa";
        if (StringUtils.isBlank(aaa) || StringUtils.isBlank(bbb)) {
            System.out.println("仅一个为空");
        }
        aaa = "aaa";
        bbb = "bbb";
        if (!StringUtils.isBlank(aaa) && !StringUtils.isBlank(bbb)) {
            System.out.println("都不为空1");
        }
        aaa = "aaa";
        bbb = "bbb";
        if (!(StringUtils.isBlank(aaa) && StringUtils.isBlank(bbb))) {
            System.out.println("都不为空2");
        }
        aaa = "aaa";
        bbb = "";
        if (!StringUtils.isBlank(aaa) && !StringUtils.isBlank(bbb)) {
            System.out.println("都不为空3");
        }

    }
}