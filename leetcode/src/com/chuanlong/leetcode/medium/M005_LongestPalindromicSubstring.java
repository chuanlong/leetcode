package com.chuanlong.leetcode.medium;

public class M005_LongestPalindromicSubstring {

	/**
	 * https://leetcode.com/problems/longest-palindromic-substring/
	 */
	public static void main(String[] args) {
		
		M005_LongestPalindromicSubstring obj = new M005_LongestPalindromicSubstring();
		
		obj.longestPalindrome("abb");

		System.out.println("abb -> bb, result:" + obj.longestPalindrome("abb"));
		System.out.println("abbc -> bb, result:" + obj.longestPalindrome("abbc"));
		System.out.println("a -> a, result:" + obj.longestPalindrome("a"));
		
	}
	
    public String longestPalindrome(String s) {
    	if(s == null || s.length() <= 1){
    		return s;
    	}
    	
    	String longest = "";
    	String longestWithEnd = "";
    	
    	char[] chars = s.toCharArray();
    	int n = chars.length;
    	
    	longest += chars[0];
    	longestWithEnd += chars[0];
    	
    	for(int i=1; i<n; i++){
    		int start = i - longestWithEnd.length() - 1;
    		start = start >= 0 ? start : 0;
    		
    		while(!isPalindrome(chars, start, i)){
    			start++;
    		}
    		
    		longestWithEnd = new String(chars, start, i-start+1);
    		longest = longest.length() > longestWithEnd.length() ? longest : longestWithEnd;
    	}
    	
    	return longest;
    }
    
    private boolean isPalindrome(char[] chars, int start, int end){
    	if(start > end){
    		return false;
    	}
    	
    	for(int i = start, j = end; i<=j; i++, j--){
    		if(chars[i] != chars[j]){
    			return false;
    		}
    	}
    	return true;
    }

}
