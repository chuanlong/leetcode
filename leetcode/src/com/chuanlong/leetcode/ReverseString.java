package com.chuanlong.leetcode;

public class ReverseString {

	/**
	 * https://leetcode.com/problems/reverse-string/
	 */
	public static void main(String[] args) {

	}
	
    public String reverseString(String s) {
        if(s == null || "".equals(s) || s.length() == 1){
        	return s;
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i = s.length()-1; i >= 0; i--){
        	sb.append(s.charAt(i));
        }
    	
    	return sb.toString();
    }

}
