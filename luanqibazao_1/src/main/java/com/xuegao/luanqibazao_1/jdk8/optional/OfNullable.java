package com.xuegao.luanqibazao_1.jdk8.optional;

import java.util.Optional;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.optional
 * <br/> @ClassName：OfNullable
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/9/7 14:00
 */
public class OfNullable {
    public static void main(String[] args) {
        Object oo = "dsaad";
        Optional<Object> oo1 = Optional.ofNullable(oo);
        System.out.println(oo1);
        Optional<Object> oo11 = Optional.of(oo);
        System.out.println(oo11);
        oo = null;
        Optional<Object> oo2 = Optional.ofNullable(oo);
        System.out.println(oo2);
        Optional<Object> oo22 = Optional.of(oo);
        System.out.println(oo22);

    }
}