package edu.escuelaing.arep.services.impl;

import edu.escuelaing.arep.model.IpPool;
import edu.escuelaing.arep.services.ILoadBalance;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 3/19/2022
 * @project Back-end
 */
public class RoundRobin implements ILoadBalance {
    private static Integer position = 0;

    @Override
    public String getServer() {
        //Getting All the servers
        Set<String> servers = IpPool.ipMap.keySet();
        List<String> serverList = new ArrayList<>();

        serverList.addAll(servers);
        String target = null;

        synchronized (position) {
            if (position > serverList.size()) position = 0;

            target = serverList.get(position);
            position++;
        }
        return target;
    }
}
