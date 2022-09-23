package com.chuanlong.leetcode.medium;

import java.util.TreeMap;

public class M532_KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        int pairs = 0;
        if(k == 0) {
            for(int i : map.keySet()) {
                if(map.get(i) >= 2) {
                    pairs++;
                }
            }
        } else {
            for(int i : map.keySet()) {
                if(map.containsKey(i+k)) {
                    pairs++;
                }
            }
        }
        return pairs;
    }
}
