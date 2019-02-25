package com.dht.thread_test.no_2;

import com.dht.thread_test.annotation.NotThreadSafe;

/**
 * @author dht
 * @create 2019-02-25 22:46
 * <p>
 * 类似懒汉式的单例模式，是线程不安全的
 **/
@NotThreadSafe
public class LazyInitRace {

    private Object instance = null;

    public Object getInstance() {
        if (instance == null) {
            instance = new Object();
        }
        return instance;
    }
}
