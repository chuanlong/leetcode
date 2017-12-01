package com.chuanlong.leetcode.easy;

public class E053_MaximumSubarray {

    public int maxSubArray(int[] nums) {
    	int maxSum = nums[0], maxEndSum = nums[0];
    	for(int i=1; i<nums.length; i++){
    		maxEndSum = Math.max(maxEndSum + nums[i], nums[i]);
    		maxSum = Math.max(maxSum, maxEndSum);
    	}
    	return maxSum;
    }
    
}
