package com.xuegao.luanqibazao_1.ditu;

public class MapPoint {

    // 纬度
    private double lan;
    // 经度
    private double lon;

    public MapPoint() {
    }

    public MapPoint(double lan, double lon) {
        this.lan = lan;
        this.lon = lon;
    }

    public double getLan() {
        return lan;
    }

    public void setLan(double lan) {
        this.lan = lan;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

}
