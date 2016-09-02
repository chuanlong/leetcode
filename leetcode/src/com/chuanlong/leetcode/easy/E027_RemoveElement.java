package com.chuanlong.leetcode.easy;

public class E027_RemoveElement {

	/**
	 * https://leetcode.com/problems/remove-element/
	 */
	public static void main(String[] args) {

		E027_RemoveElement obj = new E027_RemoveElement();
		
		obj.removeElement(new int[]{4,5}, 4);
		
	}
	
	
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
    	
    	int start = 0, end = nums.length-1;
    	while(start < end){
    		while(start < end && nums[start] != val) start++;
    		
    		while(start < end && nums[end] == val) end--;
    		
    		if(start < end){
    			nums[start] = nums[end];
    			nums[end] = val;
    			start++;
    			end--;
    		}
    	}
    	
    	if(nums[start] == val){
    		return start;
    	}else{
    		return start+1;
    	}
    }

}
