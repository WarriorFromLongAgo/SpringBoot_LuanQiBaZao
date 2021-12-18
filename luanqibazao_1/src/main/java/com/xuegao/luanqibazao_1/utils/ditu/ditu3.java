package com.xuegao.luanqibazao_1.utils.ditu;

import cn.hutool.core.collection.CollectionUtil;

import java.util.*;

/**
 * <br/> @ClassName：ditu
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/6/11 17:51
 */
public class ditu3 {

    public static void main(String[] args) {
        MapPoint start = new MapPoint(22.64073, 113.82926);

        List<MapPoint> list = new ArrayList<>();
        // 96
        list.add(new MapPoint(22.640318, 113.8283));
        // 23
        list.add(new MapPoint(22.641179, 113.830681));

        List<Object> listo = new ArrayList<>();
        for (MapPoint mapPoint : list) {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("startLon", start.getLon());
            param.put("startLat", start.getLan());
            param.put("endLon", mapPoint.getLon());
            param.put("endLat", mapPoint.getLan());
            listo.add(param);
        }
        getStraightLine(listo);
    }

    /**
     * 获取两个地点之间的距离,精确到小数点后两位km
     */
    private static List<Integer> getStraightLine(List<Object> requestParameters) {
        List<Integer> result = new ArrayList<>();
        if (CollectionUtil.isEmpty(requestParameters)) {
            return result;
        }
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
            System.out.println("endLon = " + endLon + ", endLat = " + endLat);
            int totallength = (int) MM_GetMapDistance(startLon, startLat, endLon, endLat);
            // System.out.println("入参距离为" + totallength + "km");
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