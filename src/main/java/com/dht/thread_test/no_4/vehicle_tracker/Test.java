package com.dht.thread_test.no_4.vehicle_tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author dht
 * @create 2019-02-28 14:43
 **/
public class Test {
    public static void main(String[] args) {


        List<String> list = new ArrayList();
        list.add("x");
        list.add("y");
        list.add("z");
        list.add("e");
        list.add("f");
        // 会抛出ConcurrentModificationException
        for (String s : list) {
            if (s.equals("e")) ;
            list.remove(s);
        }
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).equals("e")) {
//                list.remove(i);
//            }
//        }
    }

}
