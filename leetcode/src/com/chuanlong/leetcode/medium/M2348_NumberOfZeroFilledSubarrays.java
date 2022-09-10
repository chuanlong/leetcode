package com.chuanlong.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class M2348_NumberOfZeroFilledSubarrays {
    public long zeroFilledSubarray(int[] nums) {
        // contiguous num, count
        Map<Integer, Integer> map = new HashMap<>();
        int contiguous0 = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                contiguous0++;
            } else {
                if(contiguous0 > 0) {
                    int count = map.getOrDefault(contiguous0, 0);
                    map.put(contiguous0, count+1);
                }
                contiguous0 = 0;
            }
        }
        if(contiguous0 > 0) {
            int count = map.getOrDefault(contiguous0, 0);
            map.put(contiguous0, count+1);
        }

        int max = 0;
        for(int key : map.keySet()) {
            max = Math.max(max, key);
        }

        long[] combinations = new long[max+1];
        combinations[0] = 0;
        for(int i=1; i<max+1; i++) {
            combinations[i] = combinations[i-1] + i;
        }

        long subarrays = 0;
        for(int key: map.keySet()) {
            subarrays += combinations[key] * map.get(key);
        }
        return subarrays;
    }
}
