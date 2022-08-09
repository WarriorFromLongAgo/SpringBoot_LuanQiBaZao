package com.xuegao.luanqibazao_1.jdk8.util.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListCast {
    public static void main(String[] args) {
        Object obj = new ArrayList<>(Collections.singletonList("str1"));
        List<?> stringList = (List<?>) obj;


    }

    public static <T> T cast(Object object) {
        return (T) object;
    }
}
