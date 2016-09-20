package com.chuanlong.leetcode.medium;

public class M334_IncreasingTripletSubsequence {

	/**
	 * https://leetcode.com/problems/increasing-triplet-subsequence/
	 */
	public static void main(String[] args) {

		M334_IncreasingTripletSubsequence obj = new M334_IncreasingTripletSubsequence();
		
//		obj.increasingTriplet(new int[]{5,1,5,5,2,5,4});
		obj.increasingTriplet(new int[]{1,1,-2,6});
		
	}
	
    public boolean increasingTriplet(int[] nums) {
    	if(nums == null || nums.length < 3){
    		return false;
    	}
    	
    	int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
        	if(first == Integer.MAX_VALUE && second == Integer.MAX_VALUE){
        		first = nums[i];
        	}else if(second == Integer.MAX_VALUE){
        		if(nums[i] < first){
        			first = nums[i];
        		}else if(nums[i] > first){
        			second = nums[i];
        		}
        	}else{
        		if(nums[i] < first){
        			first = nums[i];
        		}else if(nums[i] > first && nums[i] < second){
        			second = nums[i];
        		}else if(nums[i] > second){
        			return true;
        		}
        	}
        }
    	
    	return false;
    }

}
