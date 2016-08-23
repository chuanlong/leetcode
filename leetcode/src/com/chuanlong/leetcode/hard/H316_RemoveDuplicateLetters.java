package com.chuanlong.leetcode.hard;

public class H316_RemoveDuplicateLetters {

	/**
	 * https://leetcode.com/problems/remove-duplicate-letters/
	 */
	public static void main(String[] args) {

		H316_RemoveDuplicateLetters obj = new H316_RemoveDuplicateLetters();
		
//		System.out.println("cbacdcbc -> acdb, result:" + obj.removeDuplicateLetters("cbacdcbc"));
		
		System.out.println("abacb -> abc, result:" + obj.removeDuplicateLetters("abacb"));
	}
	
	
    public String removeDuplicateLetters(String s) {
    	if(s == null || s.length() == 0){
    		return s;
    	}
    	
    	char[] chars = s.toCharArray();
    	int[] lastIndexs = new int[26];
    	
    	for(int i=0; i<26; i++){
    		lastIndexs[i] = -1;
    	}
    	
    	for(int i=0; i<chars.length; i++){
    		lastIndexs[chars[i] - 'a'] = i;
    	}
    	
    	
    	String smallestString = "";
    	int startIndex = 0;
    	int endIndex = getSmallestLastIndex(lastIndexs);
    	while(endIndex != -1){
    		int newStartIndex = endIndex;
    		char smallestChar = chars[endIndex];
    		for(int i=endIndex; i>=startIndex; i--){
    			if(lastIndexs[chars[i]-'a'] != -1 && smallestChar >= chars[i]){
    				newStartIndex = i;
    				smallestChar = chars[i];
    			}
    		}
    		
    		smallestString += smallestChar;
    		lastIndexs[smallestChar-'a'] = -1;
    		if(newStartIndex == endIndex){
    			startIndex = newStartIndex + 1;
    		}else{
    			startIndex = newStartIndex+1;
    		}    		
			endIndex = getSmallestLastIndex(lastIndexs);
    	}
    	
    	return smallestString;
    }
    
    // -1 is not exist or the smallest last index in array.
    private int getSmallestLastIndex(int[] lastIndexs){
    	int smallestLastIndex = -1;
    	for(int i=0; i<26; i++){
    		if(lastIndexs[i] != -1 && (smallestLastIndex == -1 || smallestLastIndex > lastIndexs[i])){
    			smallestLastIndex = lastIndexs[i];
    		}
    	}
    	return smallestLastIndex;
    }
    

}
