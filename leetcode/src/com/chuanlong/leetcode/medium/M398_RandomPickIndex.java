package com.chuanlong.leetcode.medium;

import java.util.Random;

public class M398_RandomPickIndex {
	
	private int[] nums;
	private Random random;
	
    public M398_RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    public int pick(int target) {
        int count = 0, pos = -1;
        for(int i=0; i<nums.length; i++){
        	if(nums[i] == target){
        		if(random.nextInt(++count) == 0){
        			pos = i;
        		}
        	}
        }
    	return pos;
    }
	
}
