package com.chuanlong.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class E2341_MaximumNumberOfPairsInArray {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count+1);
        }

        int x=0, y=0;
        for(int key : map.keySet()) {
            int value = map.get(key);
            x+= value/2;
            y+= value%2;
        }
        return new int[]{x, y};
    }
}
