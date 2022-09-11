package com.chuanlong.leetcode.medium;

public class M300_LongestIncreasingSubsequence {

	/**
	 * https://leetcode.com/problems/longest-increasing-subsequence/
	 */
	public static void main(String[] args) {
		M300_LongestIncreasingSubsequence obj =new M300_LongestIncreasingSubsequence();
		System.out.println("Test1, expect:4, output:" + obj.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
		System.out.println("Test2, expect:4, output:" + obj.lengthOfLIS(new int[]{0,1,0,3,2,3}));
		System.out.println("Test3, expect:1, output:" + obj.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
	}

	public int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		int max = 1;
		for(int i=0; i<n; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
	
    public int lengthOfLIS1(int[] nums) {
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
