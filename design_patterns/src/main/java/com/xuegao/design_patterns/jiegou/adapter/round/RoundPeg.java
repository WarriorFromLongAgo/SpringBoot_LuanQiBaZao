package com.xuegao.design_patterns.jiegou.adapter.round;

/**
 * RoundPegs are compatible with RoundHoles.
 *
 * 圆钉
 */
public class RoundPeg {
    private double radius;

    public RoundPeg() {}

    public RoundPeg(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}