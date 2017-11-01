package com.chuanlong.leetcode.medium;

public class M011_ContainerWithMostWater {

	public static void main(String[] args) {

	}
	
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int max = -1;
        while(left < right){
        	max = Math.max(max, (right-left) * Math.min(height[left], height[right]));
        	if(height[left] < height[right]){
        		left++;
        	}else{
        		right--;
        	}
        }
    	return max;
    }

}
