package com.chuanlong.leetcode.medium;

public class M003_LongestSubstringWithoutRepeatingCharacters {

	/**
	 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
	 */
	public static void main(String[] args) {

	}
	
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
        	return 0;
        }
        
        char[] chars = s.toCharArray();
        int n = chars.length;
        
        int[] longest = new int[n];
        int[] longestWithEnd = new int[n];
        
        longest[0] = 1;
        longestWithEnd[0] = 1;
        for(int i=1; i<n; i++){
        	String previousLongestWithEnd = new String(chars, i-longestWithEnd[i-1], longestWithEnd[i-1]);
        	if(previousLongestWithEnd.contains(chars[i]+"")){
        		int index = previousLongestWithEnd.indexOf(chars[i]+"");
        		longestWithEnd[i] = longestWithEnd[i-1] - index;
        	}else{
        		longestWithEnd[i] = longestWithEnd[i-1] + 1;
        	}
        	longest[i] = Math.max(longest[i-1], longestWithEnd[i]);
        }
    	return longest[n-1];
    }

	public int lengthOfLongestSubstring2(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}

		char[] chs = s.toCharArray();
		int x=0; // largest not contain last char
		int y=1; // largest contain last char
		for(int i=1; i<chs.length; i++) {
			x = Math.max(x, y);
			int j=i-1;
			for(; j>=i-y; j--) {
				if(chs[j] == chs[i]) {
					break;
				}
			}
			y = i-j;
		}
		return Math.max(x, y);
	}

}
