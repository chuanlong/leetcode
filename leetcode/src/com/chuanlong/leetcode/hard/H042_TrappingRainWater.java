package com.chuanlong.leetcode.hard;

public class H042_TrappingRainWater {

	/**
	 * https://leetcode.com/problems/trapping-rain-water/
	 */
	public static void main(String[] args) {
		H042_TrappingRainWater obj = new H042_TrappingRainWater();
		System.out.println("Test1, expect:6, output:" + obj.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
	}

	public int trap(int[] height) {
		int n = height.length;
		int[] left = new int[n];
		int[] right = new int[n];
		left[0] = 0;
		right[n-1] = 0;

		for(int i=1; i<n; i++) {
			left[i] = Math.max(left[i-1], height[i-1]);
		}
		for(int i=n-2; i>=0; i--) {
			right[i] = Math.max(right[i+1], height[i+1]);
		}

		int sum = 0;
		for(int i=1; i<n-1; i++) {
			sum += Math.max(Math.min(left[i], right[i]) - height[i], 0);
		}
		return sum;
	}

	
    public int trap2(int[] height) {
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
