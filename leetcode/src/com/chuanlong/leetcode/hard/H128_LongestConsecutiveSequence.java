package com.chuanlong.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class H128_LongestConsecutiveSequence {

	/**
	 * https://leetcode.com/problems/longest-consecutive-sequence/
	 */
	public static void main(String[] args) {

		H128_LongestConsecutiveSequence obj = new H128_LongestConsecutiveSequence();
		
		obj.longestConsecutive(new int[]{1,0,-1});
		
	}
	
	
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
        	if(!map.containsKey(nums[i])){
        		int key = nums[i];
        		int left = map.containsKey(key-1) ? map.get(key-1) : 0;
        		int right = map.containsKey(key+1) ? map.get(key+1) : 0;
        		
        		int total = left+right+1;
        		map.put(key, total);
        		
        		if(res < total){
        			res = total;
        		}
        		
        		map.put(i-left, total);
        		map.put(i+right, total);
        	}else{
        		// ignore the duplicate num
        	}
        }
    	
    	return res;
    }

}
