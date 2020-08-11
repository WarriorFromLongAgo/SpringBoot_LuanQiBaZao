package com.xuegao.luanqibazao_1;

import java.util.Collections;
import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1
 * <br/> @ClassName：object
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/7/31 11:55
 */
public class object {
    public static void main(String[] args) {
        Object a = "1";
        Object b = 1;
        Integer ccc = 1;
        boolean equals = ccc.equals(a);
        System.out.println(equals);
        boolean equals1 = ccc.equals(b);
        System.out.println(equals1);

        List<Integer> COURSES_STATUS_LIST = Collections.singletonList(1);
        boolean contains = COURSES_STATUS_LIST.contains(b);
        System.out.println(contains);

        String sq = "11";
        String sq2 = "11";
        if (!sq.equals(sq2) || !(true)) {
            throw new RuntimeException("aksjdkasjd0");
        }
        System.out.println("yiqiezhengc");
    }
}