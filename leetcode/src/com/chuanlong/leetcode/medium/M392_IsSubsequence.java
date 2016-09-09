package com.chuanlong.leetcode.medium;

public class M392_IsSubsequence {

	/**
	 * https://leetcode.com/problems/is-subsequence/
	 */
	public static void main(String[] args) {

	}
	
    
	
	public boolean isSubsequence(String s, String t) {
		if(s == null || s.length() == 0){
			return true;
		}else if(t == null || t.length() == 0){
			return false;
		}
	
		char[] tokens1 = s.toCharArray();
		char[] tokens2 = t.toCharArray();
		
		int i=0, j=0;
		while(i<tokens1.length && j<tokens2.length){
			if(tokens1[i] == tokens2[j]){
				i++; j++;
			}else{
				j++;
			}			
		}
		
		if(i == tokens1.length){
			return true;
		}else{
			return false;
		}
    }
    
    

}
