package com.xuegao.luanqibazao_1.utils.ditu;

import cn.hutool.core.collection.CollectionUtil;

import java.util.*;

/**
 * <br/> @ClassName：ditu4
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/6/15 20:21
 */
public class ditu4 {
    public static void main(String[] args) {
        List<Object> mapList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        // 鹅圣宫(兴华店) 455.136米
        map.put("startLon", 113.82926);
        map.put("startLat", 22.64073);
        map.put("endLon", 113.833674);
        map.put("endLat", 22.641127);
        mapList.add(map);
        map = new HashMap<>();
        // 立邦(雅洲涂料行) 321米
        map.put("startLon", 113.82926);
        map.put("startLat", 22.64073);
        map.put("endLon", 113.832969);
        map.put("endLat", 22.643052);
        mapList.add(map);
        map = new HashMap<>();
        // 湘遇洞庭(福永店) 321米
        map.put("startLon", 113.82926);
        map.put("startLat", 22.64073);
        map.put("endLon", 113.83191954812);
        map.put("endLat", 22.641523225797);
        mapList.add(map);
        map = new HashMap<>();
        // 宇宏玻璃 636米
        map.put("startLon", 113.82926);
        map.put("startLat", 22.64073);
        map.put("endLon", 113.833674);
        map.put("endLat", 22.641127);
        mapList.add(map);
        map = new HashMap<>();
        // 盛兴源编制袋 455.136851米
        map.put("startLon", 113.82926);
        map.put("startLat", 22.64073);
        map.put("endLon", 113.833674);
        map.put("endLat", 22.641127);
        mapList.add(map);
        map = new HashMap<>();
        // 庐陵汽修美容中心 563米
        map.put("startLon", 113.82926);
        map.put("startLat", 22.64073);
        map.put("endLon", 113.83242);
        map.put("endLat", 22.64348);
        mapList.add(map);
        List<Integer> straightLine = getStraightLine(mapList);
        System.out.println(straightLine);
    }

    private static List<Integer> getStraightLine(List<Object> requestParameters){
        List<Integer> result = new ArrayList<>();
        if(CollectionUtil.isEmpty(requestParameters)) {
            return result;
        }
        Integer straightLine = Integer.MAX_VALUE;
        for(Object ob : requestParameters) {
            Map<String, Object> addressMap = (Map<String, Object>) ob;
            if( Objects.isNull(addressMap.get("endLon")) || Objects.isNull(addressMap.get("endLat"))){
                result.add(straightLine);
                continue;
            }
            Double startLon = (Double)addressMap.get("startLon");
            Double startLat = (Double)addressMap.get("startLat");
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

