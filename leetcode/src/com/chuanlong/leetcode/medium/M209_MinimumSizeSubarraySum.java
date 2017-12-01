package com.chuanlong.leetcode.medium;

public class M209_MinimumSizeSubarraySum {

	public static void main(String[] args) {
		
		M209_MinimumSizeSubarraySum obj = new M209_MinimumSizeSubarraySum();
		
		obj.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
	}
	
    public int minSubArrayLen(int s, int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
    	
        int min = 0;
        int i=0, j=0;
        int sum = nums[i];
        while(i<nums.length && j<nums.length){
        	if(i<=j && sum >= s){
        		min = (min == 0 || min > j-i+1) ? (j-i+1) : min;
        		sum = sum - nums[i];
        		i++;
        	}else{
        		j++;
        		if(j < nums.length) sum = sum + nums[j];
        	}
        }
    	
    	return min;
    }

}
