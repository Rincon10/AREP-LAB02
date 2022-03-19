package edu.escuelaing.arep.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 3/19/2022
 * @project Back-end
 */
public class IpPool {
    public static Map<String, Integer> ipMap = new ConcurrentHashMap<>();

    static {
        int servers = 3;
        for (int i = 1; i <= servers; i++) {
            ipMap.put("http://localhost:3500"+i+"/api/v1/messages",10);
        }
    }
}
