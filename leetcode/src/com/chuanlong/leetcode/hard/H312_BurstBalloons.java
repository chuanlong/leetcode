package com.chuanlong.leetcode.hard;

public class H312_BurstBalloons {

	/**
	 * https://leetcode.com/problems/burst-balloons/
	 */
	public static void main(String[] args) {

		H312_BurstBalloons obj = new H312_BurstBalloons();
		
		System.out.println("[3, 1, 5, 8] -> 167, res:" + obj.maxCoins(new int[]{3, 1, 5, 8}));
		
	}

    public int maxCoins(int[] nums) {
    	
    	int n = nums.length;
    	int[] a = new int[n+2];
    	for(int i=1; i<n+1; i++){
    		a[i] = nums[i-1];
    	}
    	a[0] = a[n+1] = 1;
    	
    	return maxCoins(a, new int[n][n], 1, n);
    }
    
    
    private int maxCoins(int[] a, int[][] coins, int left, int right){
    	if(left > right){
    		return 0;
    	}
    	
    	if(left == right){
    		coins[left-1][right-1] = a[left-1] * a[left] * a[left+1];
    	}
    	
    	if(coins[left-1][right-1] > 0){
    		return coins[left-1][right-1];
    	}
    	
    	int maxCoins = 0;
    	for(int i=left; i<=right; i++){
    		
    		int leftCoins = maxCoins(a, coins, left, i-1);
    		int rightCoins = maxCoins(a, coins, i+1, right);

    		int totalCoins = leftCoins + rightCoins + a[i] * a[left-1] * a[right+1];
    		
    		maxCoins = Math.max(maxCoins, totalCoins);
    	}
    	
    	coins[left-1][right-1] = maxCoins;
    	return maxCoins;
    }
    
    
    
	
}
