package com.chuanlong.leetcode.medium;

public class M268_MissingNumber {

	/**
	 * https://leetcode.com/problems/missing-number/
	 */
	public static void main(String[] args) {

		M268_MissingNumber obj = new M268_MissingNumber();
		
		System.out.println("[0, 1, 3] -> 2, result:" + obj.missingNumber(new int[]{0,1,3}));		
	}
	
	
    public int missingNumber(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
    	
    	double average = ((double) nums.length) / 2;
    	double x=average;
    	for(int i=0; i<nums.length; i++){
    		x = x + average - nums[i];
    	}
        
    	return (int)x;
    }
	

}
