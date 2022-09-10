package com.chuanlong.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class M2342_MaxSumOfAPairWithEqualSumOfDigits {

    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> cache = new HashMap<>();
        int max = -1;
        for(int i=0; i<nums.length; i++) {
            int digits = getDigits(nums[i], cache);
            if(!map.containsKey(digits)) {
                map.put(digits, i);
            } else {
                max = Math.max(max, nums[map.get(digits)] + nums[i]);
                if(nums[map.get(digits)] < nums[i]) {
                    map.put(digits, i);
                }
            }
        }
        return max;
    }

    private int getDigits(int x, Map<Integer, Integer> cache) {
        if(cache.containsKey(x)) return cache.get(x);
        int sum = 0;
        while(x>0) {
            sum+= x%10;
            x = x/10;
        }
        cache.put(x, sum);
        return sum;
    }
}
