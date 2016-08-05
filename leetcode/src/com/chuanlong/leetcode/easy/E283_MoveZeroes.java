package com.chuanlong.leetcode.easy;

public class E283_MoveZeroes {

	/**
	 * https://leetcode.com/problems/move-zeroes/
	 */
	public static void main(String[] args) {

	}
	
    public void moveZeroes(int[] nums) {
        if(nums == null){
        	return;
        }
        
        int zeroIndex = 0;
        for(int i=0; i<nums.length; i++){
        	if(nums[i] == 0){
        		continue;
        	}else{
        		if(zeroIndex < i){
        			nums[zeroIndex] = nums[i];
        			nums[i] = 0;
        		}        		
        		zeroIndex++;
        	}
        }
    }

}
