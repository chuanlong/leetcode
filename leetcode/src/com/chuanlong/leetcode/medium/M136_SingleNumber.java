package com.chuanlong.leetcode.medium;

public class M136_SingleNumber {

	/**
	 * https://leetcode.com/problems/single-number/
	 */
	public static void main(String[] args) {
		
		M136_SingleNumber obj = new M136_SingleNumber();

		System.out.println("[6] -> 6, result:" + obj.singleNumber(new int[]{6}));
		System.out.println("[6, 7, 8, 6, 8] -> 7, result:" + obj.singleNumber(new int[]{6,7,8,6,8}));
	}
	
	
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        
        int result = 0;
        for(int i=0; i<nums.length; i++){
        	result = result ^ nums[i];
        }
    	return result;
    }

}
