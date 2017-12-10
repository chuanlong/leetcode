package com.chuanlong.leetcode.hard;

public class H214_ShortestPalindrome {
	
    public String shortestPalindrome(String s) {
    	if(s == null || s.length() == 0){
    		return s;
    	}
    	int k=s.length()-1, i=0, j=k;
    	char chs[] = s.toCharArray();
    	while(i<j){
    		if(chs[i] == chs[j]){
    			i++; j--;
    		}else{
    			k--; i=0; j=k;
    		}
    	}
    	
    	return new StringBuffer(s.substring(k+1, s.length()))
    			.reverse()
    			.append(s)
    			.toString();
    }

}
