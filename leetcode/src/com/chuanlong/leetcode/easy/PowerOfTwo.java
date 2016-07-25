package com.chuanlong.leetcode.easy;

public class PowerOfTwo {

	/**
	 * https://leetcode.com/problems/power-of-two/
	 */
	public static void main(String[] args) {
		
		PowerOfTwo obj = new PowerOfTwo();

		System.out.println("1 expected:true, result:" + obj.isPowerOfTwo(1));
		System.out.println("2 expected:true, result:" + obj.isPowerOfTwo(2));
		System.out.println("255 expected:false, result:" + obj.isPowerOfTwo(255));
		System.out.println("256 expected:true, result:" + obj.isPowerOfTwo(256));
		
	}
	
    public boolean isPowerOfTwo(int n) {
    	if(n == 0){
    		return false;
    	}
   	
    	int a = n;
    	while(a != 0){
    		if(a == 1 || a%2 == 0){
    			a >>= 1;
    		}else{
    			return false;
    		}
    	}    	
    	return true;
    }

}
