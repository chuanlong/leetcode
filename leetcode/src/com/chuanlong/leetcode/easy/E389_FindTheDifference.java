package com.chuanlong.leetcode.easy;

public class E389_FindTheDifference {

	/**
	 * https://leetcode.com/problems/find-the-difference/
	 */
	public static void main(String[] args) {

	}
	
    public char findTheDifference(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];

        for(int i=0; i<chars1.length; i++){
        	counts1[chars1[i]-'a']++;
        }
        
        for(int i=0; i<chars2.length; i++){
        	counts2[chars2[i]-'a']++;
        }
        
        for(int i=0; i<26; i++){
        	if(counts1[i]+1 == counts2[i]){
        		return (char) ('a'+i);
        	}
        }
        
        // error
        return 'a';
    }

}
