package com.xuegao.luanqibazao_1.基础类型;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.基础类型
 * <br/> @ClassName：泛型
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/9/6 13:54
 */
public class 泛型<T> {

    public static <T> T[] test1(T... a) {

        return a;
    }
}