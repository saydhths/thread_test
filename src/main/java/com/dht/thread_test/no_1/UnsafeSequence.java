package com.dht.thread_test.no_1;

/**
 * @author dht
 * @create 2019-02-25 16:13
 * <p>
 * 如果执行的时机不对，那么两个线程在调用getNext时会得到相同的值。
 **/
public class UnsafeSequence {
    private int value;

    public int getValue() {
        return value++;
    }
}
