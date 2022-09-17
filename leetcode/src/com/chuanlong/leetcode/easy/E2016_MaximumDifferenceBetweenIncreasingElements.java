package com.chuanlong.leetcode.easy;

public class E2016_MaximumDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
        int max = -1;
        int minNum = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] <= minNum) {
                minNum = nums[i];
            } else {
                max = Math.max(max, nums[i]-minNum);
            }
        }
        return max;
    }
}
