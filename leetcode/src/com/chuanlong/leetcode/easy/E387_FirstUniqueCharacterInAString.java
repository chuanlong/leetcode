package com.chuanlong.leetcode.easy;

public class E387_FirstUniqueCharacterInAString {

	/**
	 * https://leetcode.com/problems/first-unique-character-in-a-string/
	 */
	public static void main(String[] args) {

	}
	
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0){
        	return -1;
        }
    	
        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++){
        	counts[chars[i] - 'a']++;
        }
    	
        for(int i=0; i<chars.length; i++){
        	if(counts[chars[i]-'a'] == 1){
        		return i;
        	}
        }
    	
    	return -1;
    }

}
