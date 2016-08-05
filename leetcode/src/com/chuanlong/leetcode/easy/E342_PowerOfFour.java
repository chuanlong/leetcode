package com.chuanlong.leetcode.easy;

public class E342_PowerOfFour {

	/**
	 * https://leetcode.com/problems/power-of-four/
	 */
	public static void main(String[] args) {
		
		E342_PowerOfFour obj = new E342_PowerOfFour();
		
		System.out.println("1 -> true, result:" + obj.isPowerOfFour(1));
		System.out.println("16 -> true, result:" + obj.isPowerOfFour(16));
		System.out.println("15 -> false, result:" + obj.isPowerOfFour(15));
		System.out.println("-1 -> false, result:" + obj.isPowerOfFour(-1));
		System.out.println("1162261466 -> false, result:" + obj.isPowerOfFour(1162261466));
		
	}
	
	
    public boolean isPowerOfFour(int num) {
        int x = 1;
        while(x<num && x < 1073741824){
        	x = x*4;
        }
        if(x == num){
        	return true;
        }else{
        	return false;
        }
    }

}
