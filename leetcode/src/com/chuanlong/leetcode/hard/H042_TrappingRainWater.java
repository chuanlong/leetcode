package com.chuanlong.leetcode.hard;

public class H042_TrappingRainWater {

	/**
	 * https://leetcode.com/problems/trapping-rain-water/
	 */
	public static void main(String[] args) {

	}
	
	
    public int trap(int[] height) {
    	if(height == null || height.length <= 2){
    		return 0;
    	}
    	
    	int[] leftHighest = new int[height.length];
    	int[] rightHighest = new int[height.length];
    	
    	leftHighest[0] = height[0];
    	for(int i=1; i<height.length; i++){
    		leftHighest[i] = height[i] > leftHighest[i-1] ? height[i] : leftHighest[i-1];
    	}
    	
    	rightHighest[height.length-1] = height[height.length-1];
    	for(int i=height.length-2; i>=0; i--){
    		rightHighest[i] = height[i] > rightHighest[i+1] ? height[i] : rightHighest[i+1];
    	}
    	
    	int trap = 0;
    	for(int i=1; i<height.length-1; i++){
    		trap += (leftHighest[i] < rightHighest[i] ? leftHighest[i] : rightHighest[i]) - height[i];
    	}
    	
        return trap;
    }

}
