package com.xuegao.luanqibazao_1.utils.ditu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <br/> @ClassName：ditu5
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/6/22 17:33
 */
public class ditu5 {
    public static void main(String[] args) {
        List<Object> mapList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        // 974
        // map.put("startLon", 113.03826);
        // map.put("startLat", 22.93673);
        // 1077
        map.put("startLon", 116.352677);
        map.put("startLat", 39.409199);
        map.put("endLon", 116.350393);
        map.put("endLat", 39.409042);
        mapList.add(map);
        List<Integer> straightLine = getStraightLine(mapList);
        System.out.println(straightLine);
    }

    private static List<Integer> getStraightLine(List<Object> requestParameters) {
        List<Integer> result = new ArrayList<>();
        Integer straightLine = Integer.MAX_VALUE;
        for (Object ob : requestParameters) {
            Map<String, Object> addressMap = (Map<String, Object>) ob;
            if (Objects.isNull(addressMap.get("endLon")) || Objects.isNull(addressMap.get("endLat"))) {
                result.add(straightLine);
                continue;
            }
            Double startLon = (Double) addressMap.get("startLon");
            Double startLat = (Double) addressMap.get("startLat");
            Double endLon = Double.parseDouble(addressMap.get("endLon").toString());
            Double endLat = Double.parseDouble(addressMap.get("endLat").toString());
            int totallength = (int) MM_GetMapDistance(startLon, startLat, endLon, endLat);
            result.add(totallength);
        }
        return result;
    }

    public static double MM_GetMapDistance(double dx1, double dy1, double dx2, double dy2) {
        double dx = dx2 - dx1;
        double dy = dy2 - dy1;
        double sx = Math.cos(dy1 * 0.01745329252);
        double length = Math.sqrt(dx * dx * sx * sx + dy * dy) * 111195.0;
        return length;
    }
}