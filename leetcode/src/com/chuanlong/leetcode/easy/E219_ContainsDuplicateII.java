package com.chuanlong.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E219_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        for(int key : map.keySet()) {
            if(map.get(key).size() >= 2) {
                List<Integer> indexes = map.get(key);
                for(int i=1; i<indexes.size(); i++) {
                    if(indexes.get(i)-indexes.get(i-1) <= k) return true;
                }
            }
        }
        return false;
    }
}
