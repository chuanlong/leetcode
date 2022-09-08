package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M2368_ReachableNodesWithRestrictions {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<edges.length; i++) {
            List<Integer> x = map.getOrDefault(edges[i][0], new ArrayList<>());
            x.add(edges[i][1]);
            if(!map.containsKey(edges[i][0])) map.put(edges[i][0], x);

            List<Integer> y = map.getOrDefault(edges[i][1], new ArrayList<>());
            y.add(edges[i][0]);
            if(!map.containsKey(edges[i][1])) map.put(edges[i][1], y);
        }

        Map<Integer, Boolean> reachable = new HashMap();
        Map<Integer, Boolean> unScan = new HashMap<>();
        Map<Integer, Boolean> restrict = new HashMap<>();
        for(int i=0; i<restricted.length; i++) {
            restrict.put(restricted[i], true);
        }

        unScan.put(0, true);
        while(!unScan.isEmpty()) {
            int k = unScan.keySet().iterator().next();
            unScan.remove(k);
            reachable.put(k, true);

            List<Integer> newUnScan = map.getOrDefault(k, new ArrayList<>());
            for(int i=0; i<newUnScan.size(); i++) {
                int j = newUnScan.get(i);
                if(!reachable.containsKey(j) && !restrict.containsKey(j) && !unScan.containsKey(j)) {
                    unScan.put(j, true);
                }
            }
        }
        return reachable.keySet().size();
    }
}
