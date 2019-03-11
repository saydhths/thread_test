package com.dht.thread_test.no_4.vehicle_tracker;

/**
 * @author dht
 * @create 2019-02-28 10:49
 **/
public class MutablePoint {

    private int x;
    private int y;


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public MutablePoint(MutablePoint loc) {
        this.x = loc.getX();
        this.y = loc.getY();
    }

    public MutablePoint() {
    }
}
