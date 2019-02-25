package com.dht.thread_test.annotation;

/**
 * 说明被标注的变量由哪个锁来保护
 */
public @interface GuardedBy {
    String lock();
}
