package com.chuanlong.leetcode.easy;

public class E026_RemoveDuplicatesFromSortedArray {

	/**
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
	 */
	public static void main(String[] args) {

	}
	
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        
        int size = 1;
        int val = nums[0];
        for(int i=1; i<nums.length; i++){
        	if(val == nums[i]){
        		continue;
        	}else{
        		val = nums[i];
        		if(size == i){
        			size++;
        		}else{
        			nums[size++] = nums[i];
        		}
        	}
        }
        
    	return size;
    }

}
