package com.chuanlong.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class E2404_MostFrequentEvenElement {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i]%2 == 0) {
                int count = map.getOrDefault(nums[i], 0);
                map.put(nums[i], count+1);
            }
        }

        int maxCount = 0;
        int maxNum = -1;
        for(int key : map.keySet()) {
            if(maxCount < map.get(key) || (maxCount == map.get(key) && key < maxNum)) {
                maxCount = map.get(key);
                maxNum = key;
            }

        }
        return maxNum;
    }
}
