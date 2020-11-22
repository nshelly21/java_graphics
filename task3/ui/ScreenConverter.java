package com.company.task3.ui;

import com.company.task3.Core.RealPoint;
import com.company.task3.Core.ScreenPoint;

public class ScreenConverter {
    private double realX, realY, realWidth, realHeight;
    private int screenWight, screenHeight;

    public ScreenConverter(double realX, double realY, double realWidth, double realHeight,
                           int screenWight, int screenHeight) {
        this.realX = realX;
        this.realY = realY;
        this.realWidth = realWidth;
        this.realHeight = realHeight;
        this.screenWight = screenWight;
        this.screenHeight = screenHeight;
    }

    public ScreenPoint r2s(RealPoint p){
        double x = (p.getX() - realX) * screenWight / realWidth;
        double y = (realY - p.getY()) * screenHeight / realHeight;
        return new ScreenPoint((int)x, (int)y);
    }

    public RealPoint s2r (ScreenPoint p){
        double x = p.getX() * realWidth / screenWight + realX;
        double y = realY - p.getY() * realHeight / screenHeight;
        return new RealPoint(x,y);
    }

    public double getRealX() {
        return realX;
    }

    public void setRealX(double realX) {
        this.realX = realX;
    }

    public double getRealY() {
        return realY;
    }

    public void setRealY(double realY) {
        this.realY = realY;
    }

    public double getRealWidth() {
        return realWidth;
    }

    public void setRealWidth(double realWidth) {
        this.realWidth = realWidth;
    }

    public double getRealHeight() {
        return realHeight;
    }

    public void setRealHeight(double realHeight) {
        this.realHeight = realHeight;
    }

    public int getScreenWight() {
        return screenWight;
    }

    public void setScreenWight(int screenWight) {
        this.screenWight = screenWight;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }
}