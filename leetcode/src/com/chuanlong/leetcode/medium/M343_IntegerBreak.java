package com.chuanlong.leetcode.medium;

public class M343_IntegerBreak {

	/**
	 * https://leetcode.com/problems/integer-break/
	 */
	public static void main(String[] args) {

		M343_IntegerBreak obj = new M343_IntegerBreak();
		
		System.out.println("2 -> 1, result:" + obj.integerBreak(2));
		System.out.println("10 -> 36, result:" + obj.integerBreak(10));
		
	}
	
    public int integerBreak(int n) {
        final int MAX = 58;
    	if(n >= 2 && n <= MAX){
    	}else{
    		return 0;
    	}        
        
        int[] x = new int[MAX+1];
    	
    	x[0] = 0;
    	x[1] = 0;
    	x[2] = 1;
    	x[3] = 2;
    	x[4] = 4;
    	
    	for(int i=5; i<=n && i<x.length; i++){
    		int newMax = 0;
    		for(int j=2; j>=2 && (i-j)>=2; j++){
    			int a = (j>=4) ? x[j] : j;
    			int b = (i-j>=4) ? x[i-j] : i-j;
    			int newX = a * b;
    			newMax = newMax > newX ? newMax : newX;
    		}
    		x[i] = newMax;
    	}
    	
    	return x[n];
    }

}
