package com.xuegao.luanqibazao_1.commonlang3.tuple.pair;

import org.apache.commons.lang3.tuple.Pair;

public class PairTest {
    public static void main(String[] args) {
        Pair<String, String> pair = Pair.of("a", "b");
        String key = pair.getKey();
        String value = pair.getValue();
        System.out.println("key = " + key);
        System.out.println("value = " + value);
    }
}
