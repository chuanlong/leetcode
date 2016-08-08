package com.chuanlong.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class E217_ContainsDuplicate {

	/**
	 * https://leetcode.com/problems/contains-duplicate/
	 */
	public static void main(String[] args) {
		
	}
	
    public boolean containsDuplicate(int[] nums) {
    	if(nums == null || nums.length == 0 || nums.length == 1){
    		return false;
    	}
    	Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++){
        	if(set.contains(nums[i])){
        		return true;
        	}
        	set.add(nums[i]);
        }    	
    	return false;
    }
    
}
