package com.chuanlong.leetcode.easy;

public class E070_ClimbingStairs {

	/**
	 * https://leetcode.com/problems/climbing-stairs/
	 */
	public static void main(String[] args) {

	}
	
	
    public int climbStairs(int n) {
    	int size = (n+1 >= 3) ? (n+1) : 3;
    	
    	int[] a = new int[size];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        
        for(int i=3; i<n+1; i++){
        	a[i] = a[i-1] + a[i-2];
        }
    	    	
    	return a[n];
    }
	

}
