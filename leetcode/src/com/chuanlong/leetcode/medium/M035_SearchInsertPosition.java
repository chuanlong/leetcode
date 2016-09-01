package com.chuanlong.leetcode.medium;

public class M035_SearchInsertPosition {

	/**
	 * https://leetcode.com/problems/search-insert-position/
	 */
	public static void main(String[] args) {
		
	}

    public int searchInsert(int[] nums, int target) {
        
    	if(target <= nums[0]){
    		return 0;
    	}else if(target == nums[nums.length-1]){
    		return nums.length - 1;
    	}else if(target > nums[nums.length-1]){
    		return nums.length;
    	}
    	
    	int start = 0, end = nums.length-1;
    	int mid = (start+end)/2;
    	while(mid > start){
    		if(nums[mid] == target){
    			return mid;
    		}else if(nums[mid] < target){
    			start = mid;
    		}else{
    			end = mid;
    		}
    		mid = (start+end)/2;
    	}
    	
    	return end;
    }
	
}
