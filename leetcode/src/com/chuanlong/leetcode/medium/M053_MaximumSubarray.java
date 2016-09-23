package com.chuanlong.leetcode.medium;

public class M053_MaximumSubarray {

	/**
	 * https://leetcode.com/problems/maximum-subarray/
	 */
	public static void main(String[] args) {

	}
	
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        
        if(n >= 1){
            int[] maxIn = new int[n];
            int[] maxEnd = new int[n];
        	
            maxIn[0] = nums[0];
            maxEnd[0] = nums[0];
            
            for(int i=1; i<n; i++){
            	maxEnd[i] = Math.max(maxEnd[i-1] + nums[i], nums[i]);
            	maxIn[i] = Math.max(maxIn[i-1], maxEnd[i]);        	
            }
        	
            return maxIn[n-1];
        }else{
        	return 0;
        }
    }

}
