package com.chuanlong.leetcode.medium;

public class M260_SingleNumber3 {

	/**
	 * https://leetcode.com/problems/single-number-iii/
	 * */
	public static void main(String[] args) {

	}
	
    public int[] singleNumber(int[] nums) {
    	int diff = 0;
    	for(int i=0; i<nums.length; i++){
    		diff = diff^nums[i];
    	}
        
    	int oneBit = (diff & (diff-1)) ^ diff;
    	
    	int diffA = 0, diffB = 0;
    	for(int i=0; i<nums.length; i++){
    		if((oneBit&nums[i]) > 0){
    			diffA = diffA ^ nums[i];
    		}else{
    			diffB = diffB ^ nums[i];
    		}
    	}
    	return new int[]{diffA, diffB};
    }

}
