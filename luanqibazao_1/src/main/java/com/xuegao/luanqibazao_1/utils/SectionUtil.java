package com.xuegao.luanqibazao_1.utils;

import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SectionUtil {
    public static void main(String[] args) {
        List<CheckSectionDefine> sectionDefineList = new ArrayList<>(10);
        CheckSectionDefine sectionDefine1 = new CheckSectionDefine();
        sectionDefine1.setBeginKey(BigDecimal.valueOf(0));
        sectionDefine1.setEndKey(BigDecimal.valueOf(5000));
        sectionDefine1.setSectionKey("(0,5000]");
        sectionDefine1.setSectionValue(new BigDecimal("100"));

        CheckSectionDefine sectionDefine2 = new CheckSectionDefine();
        sectionDefine2.setBeginKey(BigDecimal.valueOf(5000));
        sectionDefine2.setEndKey(BigDecimal.valueOf(1_0000));
        sectionDefine2.setSectionKey("(5000,10000)");
        sectionDefine2.setSectionValue(new BigDecimal("200"));

        CheckSectionDefine sectionDefine3 = new CheckSectionDefine();
        sectionDefine3.setBeginKey(BigDecimal.valueOf(1_0000));
        sectionDefine3.setEndKey(BigDecimal.valueOf(1000_0000));
        sectionDefine3.setSectionKey("[10000,+∞]");
        sectionDefine3.setSectionValue(new BigDecimal("300"));

        sectionDefineList.add(sectionDefine1);
        sectionDefineList.add(sectionDefine2);
        sectionDefineList.add(sectionDefine3);

        BigDecimal sectionValue = getSectionValue(sectionDefineList, new BigDecimal(10000));
        System.out.println("resp = " + sectionValue);
    }

    public static BigDecimal getSectionValue(List<CheckSectionDefine> sectionDefineList, BigDecimal inputValue) {
        for (CheckSectionDefine sectionDefine : sectionDefineList) {
            BigDecimal sectionValue = sectionDefine.getSectionValue();
            String sectionKey = sectionDefine.getSectionKey();
            // false = (, true = [
            boolean leftFlag = false;
            // false = (, true = [
            boolean rightFlag = false;
            if (sectionKey.startsWith("[")) {
                leftFlag = true;
            }
            if (sectionKey.endsWith("]")) {
                rightFlag = true;
            }

            BigDecimal beginKey = sectionDefine.getBeginKey();
            BigDecimal endKey = sectionDefine.getEndKey();
            Range<BigDecimal> range = null;
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
                // log.info("[SectionUtil][getSectionValue][inputValue={}][sectionValue={}]", inputValue, JsonUtils.deserializer(sectionValue));
                return sectionValue;
            }
        }
        // log.info("[SectionUtil][getSectionValue][没有匹配到数据][inputValue={}][sectionDefineList={}]", inputValue, JsonUtils.deserializer(sectionDefineList));
        return BigDecimal.ZERO;
    }


    /**
     * toRangeList
     *
     * @param sectionDefineList:
     * @return java.util.List<com.google.common.collect.Range < java.math.BigDecimal>>
     * @author xuegao
     * @date 2022/9/22 19:34
     */
    public static Map<String, Range<BigDecimal>> toRangeMap(List<CheckSectionDefine> sectionDefineList) {
        if (ObjectUtils.isEmpty(sectionDefineList)) {
            return Maps.newHashMap();
        }
        Map<String, Range<BigDecimal>> rangeMap = new HashMap<>(sectionDefineList.size());
        for (CheckSectionDefine sectionDefine : sectionDefineList) {
            String sectionKey = sectionDefine.getSectionKey();
            // false = (, true = [
            boolean leftFlag = false;
            // false = (, true = [
            boolean rightFlag = false;
            if (sectionKey.startsWith("[")) {
                leftFlag = true;
            }
            if (sectionKey.endsWith("]")) {
                rightFlag = true;
            }

            BigDecimal beginKey = sectionDefine.getBeginKey();
            BigDecimal endKey = sectionDefine.getEndKey();
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
            rangeMap.put(sectionKey, range);
        }
        return rangeMap;
    }

    @Getter
    @Setter
    public static class CheckSectionDefine implements Serializable {
        private static final long serialVersionUID = 1L;
        /**
         * 开始值
         * 0
         * 100
         * 200
         */
        private BigDecimal beginKey;
        /**
         * 结束值
         * 100
         * 200
         * 10000000
         */
        private BigDecimal endKey;
        /**
         * (0,100]
         * (100,200]
         * (200,10000000)
         */
        private String sectionKey;

        private BigDecimal sectionValue;
    }
}
