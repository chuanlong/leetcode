package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M018_4Sum {

	/**
	 * https://leetcode.com/problems/4sum/
	 */
	public static void main(String[] args) {

	}
	
	
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	
    	if(nums != null){
    		quickSort(nums, 0, nums.length-1);
  		
    		for(int i=0; i<nums.length; i++){
    			for(int j=i+1; j<nums.length; j++){
    				for(int k=j+1; k<nums.length; k++){
    					
    					int val = target - nums[i] - nums[j] - nums[k];
    					int index = splitSearch(nums, val, k+1, nums.length-1);
    					
    					if(index != -1){
    						List<Integer> item = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k], nums[index]));
    						if(!isContain(list, item)){
    							list.add(item);
    						}
    					}
    					
    				}
    			}
    			
    		}
    		
    	}
    	
    	return list;
    }
    
    

    private void quickSort(int[] nums, int start, int end){
    	if(start < end){
    		int key = nums[start];
    		int i=start, j=end;
    		while(i < j){
    			while(i < j && nums[j] >= key) j--;
    			nums[i] = nums[j];
    			while(i < j && nums[i] <= key) i++;
    			nums[j] = nums[i];
    		}
    		nums[i] = key;
    		
    		quickSort(nums, start, i-1);
    		quickSort(nums, i+1, end);
    	}
    }
    
    private int splitSearch(int[] nums, int val, int start, int end){
    	if(start > end){
    		return -1;
    	}
    	
    	int mid = (start + end)/2;
    	if(nums[mid] == val){
    		return mid;
    	}else{
    		if(nums[mid] < val){
    			return splitSearch(nums, val, mid+1, end);
    		}else{
    			return splitSearch(nums, val, start, mid-1);
    		}
    	}
    }
    
    private boolean isContain(List<List<Integer>> list, List<Integer> item){
    	for(int i=0; i<list.size(); i++){
    		boolean isSame = true;
    		for(int j=0; j<item.size(); j++){
    			if(!list.get(i).get(j).equals(item.get(j))){
    				isSame = false;
    				break;
    			}
    		}
    		if(isSame){
    			return true;
    		}
    	}
    	
    	return false;
    }
	

}
