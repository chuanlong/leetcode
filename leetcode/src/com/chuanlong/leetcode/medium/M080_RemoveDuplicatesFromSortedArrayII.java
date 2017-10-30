package com.chuanlong.leetcode.medium;

public class M080_RemoveDuplicatesFromSortedArrayII {

	public static void main(String[] args) {

	}
	
	
    public int removeDuplicates(int[] nums) {
        int count = 0;
        if(nums != null && nums.length > 0){
        	int previous = -1;
        	boolean twice = false;
        	for(int i=0; i<nums.length; i++){
        		if(previous == -1 || nums[previous] != nums[i]){
        			nums[count++] = nums[i];
        			previous = i;
        			twice = false;
        		}else{
        			if(!twice){
            			nums[count++] = nums[i];
        				twice = true;
        			}
        		}
        	}
        }
    	return count;
    }

}
