package com.dht.thread_test.no_4.vehicle_tracker;

import com.dht.thread_test.annotation.GuardedBy;
import com.dht.thread_test.annotation.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dht
 * @create 2019-02-28 10:48
 * <p>
 * 基于监视器模式的车辆追踪器
 **/
@ThreadSafe
public class MonitorVehicleTracker {

    @GuardedBy(lock = "this")
    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    /**
     * 获取所有车的位置
     *
     * @return
     */
    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(locations);
    }

    /**
     * 根据车辆编号获取该车的位置信息
     *
     * @param id 车辆ID
     * @return
     */
    public synchronized MutablePoint getLocation(String id) {
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }

    public synchronized void setLocation(String id, int x, int y) {
        MutablePoint loc = locations.get(id);
        if (loc == null) {
            throw new IllegalArgumentException("No Such Id:" + id);
        }
        loc.setX(x);
        loc.setY(y);
    }

    /**
     * 深度复制
     *
     * @param locations 所有车的位置信息
     * @return
     */
    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> locations) {
        Map<String, MutablePoint> result = new HashMap();
        for (String id : locations.keySet()) {
            result.put(id, locations.get(id));
        }
        return Collections.unmodifiableMap(result);
    }

}
