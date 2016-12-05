package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M040_CombinationSum2 {

	/**
	 * https://leetcode.com/problems/combination-sum-ii/
	 */
	public static void main(String[] args) {

	}
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
    	Arrays.sort(candidates);
    	backtrack2(list, new ArrayList<Integer>(), candidates, target, 0);
    	return list;
    }

    
//    private void backtrack(List<List<Integer>> list, List<Integer> cache, int[] nums, int target, int start){
//    	if(target < 0){
//    		return;
//    	}else if(target == 0){
//    		addToSet(list, new ArrayList<Integer>(cache));
//    	}else{
//    		for(int i=start; i<nums.length; i++){
//    			cache.add(nums[i]);
//    			backtrack(list, cache, nums, target-nums[i], i+1);
//    			cache.remove(cache.size()-1);
//    		}
//    		
//    	}
//    }
//    
//    private void addToSet(List<List<Integer>> list, List<Integer> cache){
//    	for(int i=0; i<list.size(); i++){
//    		if(list.get(i).size() == cache.size()){
//    			List<Integer> item = list.get(i);
//    			boolean isSame = true;
//    			for(int j=0; j<item.size(); j++){
//    				if(item.get(j) != cache.get(j)){
//    					isSame = false;
//    					break;
//    				}
//    			}
//    			if(isSame){
//    				return;
//    			}
//    		}
//    	}
//    	list.add(cache);
//    }


    private void backtrack2(List<List<Integer>> list, List<Integer> cache, int[] nums, int target, int start){
    	if(target < 0){
    		return;
    	}else if(target == 0){
    		list.add(new ArrayList<Integer>(cache));
    	}else{
    		for(int i=start; i<nums.length; i++){
    			if(i > start && nums[i] == nums[i-1]) continue;
    			cache.add(nums[i]);
    			backtrack2(list, cache, nums, target-nums[i], i+1);
    			cache.remove(cache.size()-1);
    		}
    	}
    }
    
}
