package com.chuanlong.leetcode.easy;


public class E066_PlusOne {

	/**
	 * https://leetcode.com/problems/plus-one/
	 */
	public static void main(String[] args) {

	}
	
    public int[] plusOne(int[] digits) {
    	if(digits == null || digits.length == 0){
    		return digits;
    	}
    	
    	for(int i=digits.length-1; i>=0; i--){
    		if(digits[i] < 9){
    			digits[i] = digits[i]+1;
    			return digits;
    		}else{
    			digits[i] = 0;
    		}
    	}
    	
    	int[] newDigits = new int[digits.length+1];
    	newDigits[0] = 1;
    	for(int i=0; i<digits.length; i++){
    		newDigits[i+1] = 0;
    	}
    	
    	return newDigits;
    }

}
