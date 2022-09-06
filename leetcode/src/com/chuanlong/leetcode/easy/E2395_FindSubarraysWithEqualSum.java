package com.chuanlong.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class E2395_FindSubarraysWithEqualSum {
    public boolean findSubarrays(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i=1; i<nums.length; i++) {
            int sum = nums[i] + nums[i-1];
            if(map.containsKey(sum)) {
                return true;
            } else {
                map.put(sum, true);
            }
        }
        return false;
    }
}
