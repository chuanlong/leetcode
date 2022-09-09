package com.chuanlong.leetcode.hard;

public class H2366_MinimumReplacementsToSortTheArray {

    public long minimumReplacement(int[] nums) {
        long replaces = 0;
        int min = nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--) {
            int x = nums[i];
            if(x<=min) {
                min = x;
            } else {
                // do replacement
                if(x%min == 0) {
                    replaces += x/min-1;
                } else {
                    int replace = x/min;
                    min = x/(replace+1);
                    replaces += replace;
                }
            }
        }
        return replaces;
    }

}
