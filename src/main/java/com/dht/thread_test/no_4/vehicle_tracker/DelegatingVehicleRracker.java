package com.dht.thread_test.no_4.vehicle_tracker;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dht
 * @create 2019-02-28 11:14
 * <p>
 * 将线程安全委托给ConcurrentHashMap
 **/
public class DelegatingVehicleRracker {

    private final ConcurrentHashMap<String, Point> locations;
    private final Map<String, Point> unmodifiableMap;

    public DelegatingVehicleRracker(Map<String, Point> points) {
        locations = new ConcurrentHashMap(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, Point> getLocations() {
        return unmodifiableMap;
    }

    public Point getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (locations.replace(id, new Point(x, y)) == null) {
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        }
    }
}
