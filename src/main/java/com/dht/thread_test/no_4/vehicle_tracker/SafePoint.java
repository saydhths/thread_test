package com.dht.thread_test.no_4.vehicle_tracker;

import com.dht.thread_test.annotation.GuardedBy;

/**
 * @author dht
 * @create 2019-02-28 11:43
 **/
public class SafePoint {

    @GuardedBy(lock = "this")
    private int x;
    @GuardedBy(lock = "this")
    private int y;

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private SafePoint(int[] a) {
        this(a[0], a[1]);
    }

    public SafePoint(SafePoint p) {
        this(p.get());
    }

    private synchronized int[] get() {
        return new int[0];
    }


    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
