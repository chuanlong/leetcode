package com.chuanlong.leetcode.medium;

public class M050_PowXN {

	/**
	 * https://leetcode.com/problems/powx-n/
	 */
	public static void main(String[] args) {

	}

    public double myPow(double x, int n) {
    	if(n == 0){
    		return 1;
    	}
    	
    	// consider the INT_MIN
    	if (n < 0) {
            return 1 / (x * myPow(x, -(n + 1)));
        }
    	
    	if(n%2 == 0){
    		return myPow(x*x, n/2);
    	}else{
    		return x * myPow(x*x, n/2);
    	}
    }
	
}
