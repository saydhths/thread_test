package com.dht.thread_test.no_3;

import com.dht.thread_test.annotation.GuardedBy;
import com.dht.thread_test.annotation.ThreadSafe;

/**
 * @author dht
 * @create 2019-02-26 17:03
 **/
@ThreadSafe
public class SynchronizedInteger {

    @GuardedBy(lock = "this")
    private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}
