package com.chuanlong.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class M2364_CountNumberOfBadPairs {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int x = nums[i] - i;
            int y = map.getOrDefault(x, 0);
            map.put(x, y+1);
        }
        Object[] keys = map.keySet().toArray();
        int sum = 0;
        for(int i=0; i<keys.length; i++){
            sum += map.get(keys[i]);
        }

        long counts = 0;
        for(int i=0; i<keys.length; i++) {
            int x = map.get(keys[i]);
            counts += x * (sum-x);
        }
        return counts/2;
    }
}
