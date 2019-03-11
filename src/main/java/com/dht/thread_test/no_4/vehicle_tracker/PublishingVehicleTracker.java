package com.dht.thread_test.no_4.vehicle_tracker;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dht
 * @create 2019-02-28 13:51
 * <p>
 * 安全发布底层状态的车辆追踪器
 **/
public class PublishingVehicleTracker {

    private final Map<String, SafePoint> locations;
    private final Map<String, SafePoint> unmodifiableMap;

    public PublishingVehicleTracker(Map<String, SafePoint> locations) {
        this.locations = new ConcurrentHashMap(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
    }


    public Map<String, SafePoint> getLocations() {
        return unmodifiableMap;
    }

    public SafePoint getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (!locations.containsKey(id)) {
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        }
        locations.get(id).set(x, y);
    }

}
