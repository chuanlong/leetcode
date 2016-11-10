package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M039_CombinationSum {

	/**
	 * https://leetcode.com/problems/combination-sum/
	 */
	public static void main(String[] args) {

	}
	
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
    	Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
    	return list;
    }
    
    
    private void backtrack(List<List<Integer>> list, List<Integer> cache, int[] nums, int target, int start){
    	if(target < 0){
    		return;
    	}else if(target == 0){
    		list.add(new ArrayList<Integer>(cache));
    	}else{
    		for(int i=start; i<nums.length; i++){
    			cache.add(nums[i]);
    			backtrack(list, cache, nums, target-nums[i], i);
    			cache.remove(cache.size()-1);
    		}
    		
    	}
    }
    
    

}
