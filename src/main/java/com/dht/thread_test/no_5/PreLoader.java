package com.dht.thread_test.no_5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author dht
 * @create 2019-03-11 16:40
 **/
public class PreLoader {
    private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(new Callable() {
        @Override
        public ProductInfo call() throws Exception {
            return loadProductInfo();
        }

        private ProductInfo loadProductInfo() {
            return null;
        }
    });


    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public ProductInfo get() throws InterruptedException {
        try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            // doSomething();
            throw new InterruptedException();
        }
    }


}
