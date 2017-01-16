package com.chuanlong.leetcode.medium;

public class M279_PerfectSquares {

	/**
	 * https://leetcode.com/problems/perfect-squares/
	 * */
	public static void main(String[] args) {
		
	}

    public int numSquares(int n) {
    	// 1 -> 46340
    	int[] m = new int[n+1];
    	m[0] = 0;
    	for(int i=1; i<=n; i++){
    		int min = Integer.MAX_VALUE;
    		for(int j=1; j*j<=i; j++){
    			min = Math.min(m[i-j*j] + 1, min);
    		}
    		m[i] = min;
    	}
        return m[n];
    }
    
    
	
}
