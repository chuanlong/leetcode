package com.chuanlong.leetcode.medium;

public class M162_FindPeakElement {

	public static void main(String[] args) {

	}
	
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
        	return -1;
        }
        
        for(int i=0; i<nums.length; i++){
        	if(i == 0 || nums[i] > nums[i-1]){
        		if(i == nums.length-1 || nums[i] > nums[i+1]){
        			return i;
        		}
        	}
        }
        
        return -1;
    }
	

}
