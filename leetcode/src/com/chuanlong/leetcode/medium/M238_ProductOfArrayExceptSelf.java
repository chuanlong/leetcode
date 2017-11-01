package com.chuanlong.leetcode.medium;

public class M238_ProductOfArrayExceptSelf {

	public static void main(String[] args) {

	}
	
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int temp = 1;
        for(int i=0; i<nums.length; i++){
        	result[i] = temp;
        	temp = temp * nums[i];
        }
        temp = 1;
        for(int i=nums.length-1; i>=0; i--){
        	result[i] = result[i] * temp;
        	temp = temp * nums[i];
        }
        return result;
    }
}
