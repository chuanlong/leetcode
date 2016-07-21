package com.chuanlong.leetcode.easy;

public class SumOfTwoIntegers {

	/**
	 * https://leetcode.com/problems/sum-of-two-integers/
	 */
	public static void main(String[] args) {

		SumOfTwoIntegers obj = new SumOfTwoIntegers();
		
		System.out.println("1+2:" + obj.getSum(1, 2));
		System.out.println("1+0:" + obj.getSum(1, 0));
		System.out.println("1+-1:" + obj.getSum(1, -1));
		
	}
	
	
    public int getSum(int a, int b) {
    	int x = a;
    	int y = b;
    	int sum = a;
    	
    	while(y != 0){
    		int x1 = x;
    		int y1 = y;
    		
    		x = x1 ^ y1;
    		y = (x1 & y1) << 1;
    		
    		sum = x;
    	}
    	
    	return sum;
    }
    

}
