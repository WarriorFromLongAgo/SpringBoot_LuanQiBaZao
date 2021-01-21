package com.xuegao.luanqibazao_1.jdk8.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.util
 * <br/> @ClassName：并集
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/20 15:45
 */
public class 并集 {
    public static void main(String[] args) {
        List<String> stringList1 =  new ArrayList<>(Arrays.asList("a,b,c,d,e,f,g,h".split(",")));
        List<String> stringList2 =  new ArrayList<>(Arrays.asList("a,b,c,d,e,f,g,h".split(",")));
        stringList1.removeAll(stringList2);

    }
}