package com.chuanlong.leetcode.easy;

public class E191_NumberOf1Bits {

	/**
	 * https://leetcode.com/problems/number-of-1-bits/
	 */
	public static void main(String[] args) {

		E191_NumberOf1Bits obj = new E191_NumberOf1Bits();
		
		System.out.println("2147483648, expected:1, result:" + obj.hammingWeight(0x80000000));
		System.out.println("4294967295, expected:32, result:" + obj.hammingWeight(0xFFFFFFFF));
		
	}
	
    public int hammingWeight(int n) {
    	int a = n;
    	int count = 0;
    	if(n < 0){
    		a = n & 0x7FFFFFFF;
    		count = 1;
    	}
    	while(a != 0){
    		if(a%2 == 1 || a%2 == -1){
        		count++;
    		}
    		a = a/2;
    	}        
    	return count;
    }	

}
