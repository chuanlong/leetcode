package com.chuanlong.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

import com.chuanlong.leetcode.util.Util;

public class H315_CountOfSmallerNumbersAfterSelf {

	/**
	 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
	 * */
	public static void main(String[] args) {

		H315_CountOfSmallerNumbersAfterSelf obj = new H315_CountOfSmallerNumbersAfterSelf();
		List<Integer> counts = obj.countSmaller(new int[]{5,2,6,1});
		
		System.out.println(Util.List2String(counts));
	}
	
    public List<Integer> countSmaller(int[] nums) {
    	List<Integer> list = new ArrayList<>();
    	
    	List<Integer> counts = new ArrayList<>();
    	if(nums != null && nums.length > 0){
    		for(int i=nums.length-1; i>=0; i--){
    			int index = getIndex(nums[i], list);
    			counts.add(0, index);
    			list.add(index, nums[i]);
    		}
    	}
    	return counts;
    }
    
    
    public int getIndex(int num, List<Integer> list){
    	if(list.size() == 0 || list.get(0)>=num){
    		return 0;
    	}
    	
    	if(list.get(list.size()-1) < num){
    		return list.size();
    	}
    	
    	int start=0, end=list.size()-1;
    	while(start < end){
    		int mid = (start+end)/2;
    		if(list.get(mid) >= num && list.get(mid-1) < num){
    			return mid;
    		}
    		if(list.get(mid) < num){
    			start = mid+1;
    		}else{
    			end = mid-1;
    		}
    	}
    	return start;
    }
	

}
