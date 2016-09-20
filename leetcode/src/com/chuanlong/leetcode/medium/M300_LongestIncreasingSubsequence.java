package com.chuanlong.leetcode.medium;

public class M300_LongestIncreasingSubsequence {

	/**
	 * https://leetcode.com/problems/longest-increasing-subsequence/
	 */
	public static void main(String[] args) {

	}
	
	
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        
        int n = nums.length;
        int[] maxs = new int[n];
        int max = 0;
        
        for(int i=0; i<n; i++){
        	maxs[i] = 1;
        	for(int j=i-1; j>=0; j--){
        		if(nums[j] < nums[i]){
        			maxs[i] = Math.max(maxs[i], maxs[j] + 1);
        		}
        	}
        	max = Math.max(max, maxs[i]);
        }
    	
    	return max;
    }

}
