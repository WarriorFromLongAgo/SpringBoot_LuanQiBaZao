package com.xuegao.luanqibazao_1.utils.ditu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <br/> @ClassName：ditu
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/6/11 17:51
 */
public class ditu2 {

    public static void main(String[] args) {
        MapPoint start = new MapPoint(22.64073, 113.82926);

        List<MapPoint> list = new ArrayList<>();
        list.add(new MapPoint(22.640318, 113.8283));
        list.add(new MapPoint(22.64142, 113.833693));
        list.add(new MapPoint(22.64092, 113.83135));
        list.add(new MapPoint(22.641523225797, 113.8319195481));
        list.add(new MapPoint(22.641179, 113.830681));
        for (MapPoint mapPoint : list) {
            double distence = getDistence(start, mapPoint);
            System.out.println("入参距离为" + distence + "km");
            System.out.println(mapPoint.getLan() + ", " + mapPoint.getLon());
            System.out.println("====");
        }
    }

    /**
     * 获取两个地点之间的距离,精确到小数点后两位km
     */
    public static double getDistence(MapPoint start, MapPoint end) {
        // 得到起点经纬度,并转换为角度
        double startLon = (Math.PI / 180) * start.getLon();
        double startLan = (Math.PI / 180) * start.getLan();
        // 得到终点经纬度,并转换为角度
        double endLon = (Math.PI / 180) * end.getLon();
        double endtLan = (Math.PI / 180) * end.getLan();

        // 地球平均直径为12756km,半径为6378km
        double earthR = 6378;

        // 计算公式
        double distence = Math.acos(Math.sin(startLan) * Math.sin(endtLan)
                + Math.cos(startLan) * Math.cos(endtLan) * Math.cos(endLon - startLon)) * earthR;

        return BigDecimal.valueOf(distence).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}