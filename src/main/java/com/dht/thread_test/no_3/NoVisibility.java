package com.dht.thread_test.no_3;

/**
 * @author dht
 * @create 2019-02-26 15:28
 * <p>
 * 该程序想表述的内容是有可能会输出0、42或者不输出，因为重排序的顺序时无法检测到的
 * 读取到脏数据——类似事务的脏读
 **/
public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {

        @Override
        public void run() {
            while (!ready) {
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {

        new ReaderThread().start();
        number = 42;
        ready = true;

    }

}
