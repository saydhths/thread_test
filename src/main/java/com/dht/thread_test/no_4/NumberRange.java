package com.dht.thread_test.no_4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dht
 * @create 2019-03-01 10:54
 * <p>
 * 如果一个线程调用setLower(5),另一个线程调用setUpper(4),那么在一些错误的执行时序中，有可能设置成功
 **/
public class NumberRange {
    // 不变性条件： lower <= upper
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    public void setLower(int i) {
        // 先检查后执行
        if (i > upper.get()) {
            throw new IllegalArgumentException("can't set lower to " + i + " > upper");
        }
        lower.set(i);
    }

    private void setUpper(int i) {
        // 先检查后执行
        if (i < lower.get()) {
            throw new IllegalArgumentException("can't set upper to " + i + " < lower");
        }
        upper.set(i);
    }

    public boolean isInRange(int i) {
        return (i >= lower.get() && i <= upper.get());
    }
}
