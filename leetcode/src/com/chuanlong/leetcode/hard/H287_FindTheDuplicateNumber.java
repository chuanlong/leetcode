package com.chuanlong.leetcode.hard;

public class H287_FindTheDuplicateNumber {

	/**
	 * https://leetcode.com/problems/find-the-duplicate-number/
	 */
	public static void main(String[] args) {

		H287_FindTheDuplicateNumber obj = new H287_FindTheDuplicateNumber();
		
		obj.findDuplicate(new int[]{1,2,3,5,6,7,8,4,4,9,10});
	}
	
	
    public int findDuplicate(int[] nums) {
    	int n = nums.length - 1;
    	
    	int start = 1, end = n;
    	int mid = (start+end)/2;
    	
    	while(start < end){
        	int countLeft = 0;
        	int countRight = 0;
        	
        	for(int i=0; i<nums.length; i++){
        		if(nums[i] >= start && nums[i] <= end){
        			if(nums[i] < mid){
        				countLeft++;
        			}else if(nums[i] > mid){
        				countRight++;
        			}
        		}
        	}
        	
        	if(countLeft > (mid-start)){
        		end = mid-1;
        		mid = (start+end)/2;
        	}else if(countRight > (end-mid)){
        		start = mid+1;
        		mid = (start+end)/2;
        	}else{
        		return mid;
        	}
    	}
    	
    	return mid;
    }
    
    
    

}
