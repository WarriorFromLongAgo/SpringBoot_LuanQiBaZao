package com.xuegao.luanqibazao_1.utils;

import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class RangeUtil {

    public static <T> T get(Map<String, T> map, BigDecimal inputValue) {
        if (ObjectUtils.isEmpty(map)) {
            return null;
        }
        for (Map.Entry<String, T> entry : map.entrySet()) {
            String key = entry.getKey();
            // false = (, true = [
            boolean leftFlag = false;
            // false = (, true = [
            boolean rightFlag = false;
            if (key.startsWith("[")) {
                leftFlag = true;
            }
            if (key.endsWith("]")) {
                rightFlag = true;
            }
            String newKey = key.replace("(", "")
                    .replace("[", "")
                    .replace(")", "")
                    .replace("]", "");
            String[] split = newKey.split(",");
            if (split.length < 2) {
                continue;
            }
            BigDecimal beginKey = new BigDecimal(split[0]);
            BigDecimal endKey = BigDecimal.ZERO;
            if ("+∞".equals(split[1])) {
                endKey = BigDecimal.valueOf(10000000);
            } else {
                endKey = new BigDecimal(split[1]);
            }
            Range<BigDecimal> range;
            if (leftFlag && rightFlag) {
                // [a,b] = { x | a <= x <= b}
                range = Range.closed(beginKey, endKey);
            } else if (!leftFlag && !rightFlag) {
                // (a,b) = { x | a < x < b}
                range = Range.open(beginKey, endKey);
            } else if (!leftFlag) {
                // (a,b] = { x | a < x <= b}
                range = Range.openClosed(beginKey, endKey);
            } else {
                // [a,b) = { x | a <= x < b}
                range = Range.closedOpen(beginKey, endKey);
            }
            if (range.contains(inputValue)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("(0,7]", "1");
        map.put("(7,10]", "2");
        map.put("(10,+∞)", "3");
        String s1 = get(map, new BigDecimal("7"));
        System.out.println("7 = " + s1);
        String s2 = get(map, new BigDecimal("10"));
        System.out.println("10 = " + s2);
        String s3 = get(map, new BigDecimal("11"));
        System.out.println("11 = " + s3);
    }
}
