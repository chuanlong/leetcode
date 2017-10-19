package com.chuanlong.leetcode.easy;

public class E028_ImplementStrStr {

	public static void main(String[] args) {

	}
	
	
	
    public int strStr(String haystack, String needle) {
    	if (needle == null || needle.length() == 0) {
			return 0;
		}
    	
    	if (haystack != null && haystack.length() > 0) {
    		int index = 0;
    		while(index + needle.length() <= haystack.length()) {
    			if (haystack.substring(index, index+needle.length()).equals(needle)) {
    				return index;
    			}
    			index ++;
    		}
    	}
        
    	return -1;
    }

}
