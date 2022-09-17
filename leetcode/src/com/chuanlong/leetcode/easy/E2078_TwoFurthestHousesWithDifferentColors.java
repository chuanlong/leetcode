package com.chuanlong.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class E2078_TwoFurthestHousesWithDifferentColors {
    public int maxDistance(int[] colors) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = -1;
        for(int i=0; i<colors.length; i++) {
            if(!map.containsKey(colors[i])) map.put(colors[i], i);
            for(int key : map.keySet()) {
                if(key != colors[i]) {
                    max = Math.max(max, i-map.get(key));
                }
            }
        }
        return max;
    }
}
