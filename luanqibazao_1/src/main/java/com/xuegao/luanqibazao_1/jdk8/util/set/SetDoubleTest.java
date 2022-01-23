package com.xuegao.luanqibazao_1.jdk8.util.set;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.util.set
 * <br/> @ClassName：SetTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/19 11:49
 */
public class SetDoubleTest {
    public static void main(String[] args) {
        Set<Double> set = Sets.newHashSet(1.0, 2.0, 3.0, 4.0, 5.0);
        if (set.contains(1.0)) {
            System.out.println("1.0 is in the set");
        }

    }


}