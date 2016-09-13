package com.chuanlong.leetcode.medium;

import java.util.Arrays;

public class M377_CombinationSum4 {

	/**
	 * https://leetcode.com/problems/combination-sum-iv/
	 */
	public static void main(String[] args) {

	}
	
	
//	public int combinationSum4(int[] nums, int target) {
//		if (nums == null || nums.length == 0 || target < 0) {
//			return 0;
//		}
//		
//		// sort nums in ascending order
//		Arrays.sort(nums);
//		
//		return combine(nums, target);
//	}
//    
//	
//	public int combine(int[] nums, int target){
//		
//		int possible = 0;
//		for(int i=0; i<nums.length; i++){
//			if(target - nums[i] > 0){
//				possible += combine(nums, target-nums[i]);
//			}else if(target - nums[i] == 0){
//				possible += 1;
//			}else{
//				break;
//			}
//		}
//		
//		return possible;
//	}
	
	
	public int combinationSum4(int[] nums, int target) {
		if (nums == null || nums.length == 0 || target < 0) {
			return 0;
		}
		
		// sort nums in ascending order
		Arrays.sort(nums);

		int[] combine = new int[target+1];
		combine[0] = 1;

		for(int i=1; i<target+1; i++){
			combine[i] = 0;
			
			for(int j=0; j<nums.length; j++){
				if(i - nums[j] >= 0){
					combine[i] += combine[i-nums[j]];
				}else{
					break;
				}
			}
		}

		return combine[target];
	}
	    

}
