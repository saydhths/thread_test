package com.dht.thread_test.no_3;

import com.dht.thread_test.annotation.NotThreadSafe;

/**
 * @author dht
 * @create 2019-02-26 17:00
 **/
@NotThreadSafe
public class MutableInteger {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
