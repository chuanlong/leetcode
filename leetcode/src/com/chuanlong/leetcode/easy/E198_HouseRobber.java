package com.chuanlong.leetcode.easy;

public class E198_HouseRobber {

	/**
	 * https://leetcode.com/problems/house-robber/
	 */
	public static void main(String[] args) {

	}
	
	
    public int rob(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
    	
    	int[] max = new int[nums.length+2];
    	max[0] = 0;
    	max[1] = 0;
    	for(int i=0; i<nums.length; i++){
    		int j = i+2;
    		max[j] = (max[j-2]+nums[i]) > max[j-1] ? (max[j-2]+nums[i]) : max[j-1]; 
    	}
    	
        return max[max.length-1];
    }

}
