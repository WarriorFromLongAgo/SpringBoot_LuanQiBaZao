package com.xuegao.luanqibazao_1.utils.ditu;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * <br/> @ClassName：ditu5
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/6/22 17:33
 */
public class ditu6 {
    public static void main(String[] args) {
        Map<String, Object> neighPosition = findNeighPosition(116.352677, 39.409199, "200");
        System.out.println(neighPosition);
    }

    /**
     * 地球半径 平均值。千米
     */
    public final static double EARTH_RADIUS = 6378.137;

    /**
     * 计算查询点的经纬度范围
     * @param longitude 经度
     * @param latitude 纬度
     */
    private static Map<String, Object> findNeighPosition(double longitude, double latitude, String matchDistance) {
        double dis = Double.parseDouble(matchDistance);
        double dlng = 2 * Math.asin(Math.sin(dis / (2 * EARTH_RADIUS)) / Math.cos(latitude * Math.PI / 180));
        //角度转为弧度
        dlng = dlng * 180 / Math.PI;
        double dlat = dis / EARTH_RADIUS;
        dlat = dlat * 180 / Math.PI;
        double minlng = longitude - dlng;
        double maxlng = longitude + dlng;
        double minlat = latitude - dlat;
        double maxlat = latitude + dlat;

        Map<String, Object> paramMap = Maps.newHashMap();
        // 经度
        paramMap.put("lonMin", minlng);
        paramMap.put("lonMax", maxlng);
        //纬度
        paramMap.put("latMin", minlat);
        paramMap.put("latMax", maxlat);
        return paramMap;
    }
}