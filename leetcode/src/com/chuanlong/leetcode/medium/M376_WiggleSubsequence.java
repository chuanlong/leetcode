package com.chuanlong.leetcode.medium;

public class M376_WiggleSubsequence {

	/**
	 * https://leetcode.com/problems/wiggle-subsequence/
	 */
	public static void main(String[] args) {
		
		M376_WiggleSubsequence obj = new M376_WiggleSubsequence();
		
		System.out.println("[1,7,4,9,2,5], right:6, result:" 
				+ obj.wiggleMaxLength(new int[]{1,7,4,9,2,5}));
		
		System.out.println("[1,17,5,10,13,15,10,5,16,8], right:7, result:" 
				+ obj.wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
		
		System.out.println("[1,2,3,4,5,6,7,8,9], right:2, result:" 
				+ obj.wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));

	}
	
    public int wiggleMaxLength(int[] nums) {
    	if(nums == null){
    		return 0;
    	}
    	
    	if(nums.length <= 2){
    		return nums.length;
    	}
    	
    	int[] a = new int[nums.length-1];
    	for(int i=0; i<nums.length-1; i++){
    		a[i] = nums[i+1] - nums[i];
    	}
    	
    	int count = 1;
    	int diff = a[0];
    	for(int i=1; i<a.length; i++){
			if ((a[i] < 0 && diff > 0) || (a[i] > 0 && diff < 0)) {
				count++;
				diff = a[i];
			}
    	}
    	return count+1;
    }
	
}
