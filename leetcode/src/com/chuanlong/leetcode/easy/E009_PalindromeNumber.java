package com.chuanlong.leetcode.easy;

public class E009_PalindromeNumber {

	/**
	 * https://leetcode.com/problems/palindrome-number/
	 */
	public static void main(String[] args) {

	}
	
	
    public boolean isPalindrome(int x) {
        if(x < 0){
        	return false;
        }
        
        int y=0;
        int i=x;
        while(i > 0){
        	y = y*10 + i%10;
        	i = i/10;
        }
        
        return x==y;
    }

}
