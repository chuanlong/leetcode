package com.chuanlong.leetcode.easy;

public class E014_LongestCommonPrefix {

	/**
	 * https://leetcode.com/problems/longest-common-prefix/
	 */
	public static void main(String[] args) {

	}
	
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
        	return "";
        }else if(strs.length == 1){
        	return strs[0];
        }
        
        String prefix = "";
    	for(int i=0; i<strs[0].length();i++){
    		char com = strs[0].charAt(i);
    		for(int j=1; j<strs.length; j++){
    			if(i >= strs[j].length() || com != strs[j].charAt(i)){
    				return prefix;
    			}
    		}
    		prefix += com;
    	}
    	
        return prefix;
    }

}
