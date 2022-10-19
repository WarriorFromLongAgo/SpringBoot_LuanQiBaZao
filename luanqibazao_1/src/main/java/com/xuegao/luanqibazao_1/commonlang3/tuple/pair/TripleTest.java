package com.xuegao.luanqibazao_1.commonlang3.tuple.pair;

import org.apache.commons.lang3.tuple.Triple;

public class TripleTest {
    public static void main(String[] args) {
        Triple<String, String, String> triple = Triple.of("a", "b", "c");
        String left = triple.getLeft();
        String middle = triple.getMiddle();
        String right = triple.getRight();
        System.out.println("left = " + left);
        System.out.println("middle = " + middle);
        System.out.println("right = " + right);

    }
}
