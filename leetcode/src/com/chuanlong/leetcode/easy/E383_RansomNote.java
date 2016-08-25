package com.chuanlong.leetcode.easy;

public class E383_RansomNote {

	/**
	 * https://leetcode.com/problems/ransom-note/
	 */
	public static void main(String[] args) {

	}

	
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine == null || magazine.length() == 0){
        	if(ransomNote == null || ransomNote.length() == 0){
        		return true;
        	}else{
        		return false;
        	}
        }
    	
    	int[] letters = new int[26];
        for(int i=0; i<magazine.length(); i++){
        	letters[magazine.charAt(i) - 'a']++;
        }
        
        if(ransomNote != null){
            for(int i=0; i<ransomNote.length(); i++){
            	if(letters[ransomNote.charAt(i) - 'a'] > 0){
            		letters[ransomNote.charAt(i) - 'a']--;
            	}else{
            		return false;
            	}
            }
        }
    	
    	return true;
    }
	
}
