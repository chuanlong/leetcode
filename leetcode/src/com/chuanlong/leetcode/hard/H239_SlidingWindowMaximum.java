package com.chuanlong.leetcode.hard;

import java.util.TreeMap;
import java.util.TreeSet;

public class H239_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        int[] results = new int[nums.length-k+1];
        for(int i=0; i<k; i++) {
            if(!map.containsKey(nums[i])) map.put(nums[i], new TreeSet<>());
            map.get(nums[i]).add(i);
        }
        results[0] = map.lastEntry().getKey();
        for(int i=k; i< nums.length; i++) {
            TreeSet<Integer> set = map.get(nums[i-k]);
            set.remove(i-k);
            if(set.size() == 0) map.remove(nums[i-k]);
            if(!map.containsKey(nums[i])) map.put(nums[i], new TreeSet<>());
            map.get(nums[i]).add(i);
            results[i-k+1] = map.lastEntry().getKey();
        }
        return results;
    }

}
