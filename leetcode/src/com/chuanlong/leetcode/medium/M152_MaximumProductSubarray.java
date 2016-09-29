package com.chuanlong.leetcode.medium;

public class M152_MaximumProductSubarray {

	/**
	 * https://leetcode.com/problems/maximum-product-subarray/
	 */
	public static void main(String[] args) {

	}
	
	
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        
        int n = nums.length;
        int[] maxIn = new int[n];
        int[] maxEnd = new int[n];
        
        int[] minIn = new int[n];
        int[] minEnd = new int[n];
        
        maxIn[0] = nums[0];
        maxEnd[0] = nums[0];
        minIn[0] = nums[0];
        maxEnd[0] = nums[0];
        
        for(int i=1; i<n; i++){
        	
        	// maxEnd[i] = max(maxEnd[i-1]*nums[i], minEnd[i-1]*nums[i], nums[i]);
        	maxEnd[i] = Math.max(Math.max(maxEnd[i-1]*nums[i], minEnd[i-1]*nums[i]), nums[i]);
        	
        	// minEnd[i] = min(maxEnd[i-1]*nums[i], minEnd[i-1]*nums[i], nums[i]);
        	minEnd[i] = Math.min(Math.min(maxEnd[i-1]*nums[i], minEnd[i-1]*nums[i]), nums[i]);
        	
        	// maxIn[i] = max(maxEnd[i], maxIn[i-1])
        	maxIn[i] = Math.max(maxEnd[i], maxIn[i-1]);
        	
        	// minIn[i] = min(minEnd[i], minIn[i-1])
        	minIn[i] = Math.min(minEnd[i], minIn[i-1]);
        }
    	
        return maxIn[n-1];
    }

}
