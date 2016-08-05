package com.chuanlong.leetcode.easy;

public class E258_AddDigits {

	/**
	 * https://leetcode.com/problems/add-digits/
	 */
	public static void main(String[] args) {
		
		E258_AddDigits obj = new E258_AddDigits();
		
		System.out.println("38 expect:2, result:" + obj.addDigits(38));
		System.out.println("9 expect:9, result:" + obj.addDigits(9));
	}

    public int addDigits(int num) {
    	int result = num;
        while(!(result>=0 && result<=9)){
        	char[] tokens = (result+"").toCharArray();
        	int x=0;
        	for(int i=0; i<tokens.length; i++){
        		x += (tokens[i]-'0');
        	}
        	result = x;
        }
    	return result;
    }
	
}
