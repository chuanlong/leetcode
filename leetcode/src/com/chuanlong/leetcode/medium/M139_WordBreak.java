package com.chuanlong.leetcode.medium;

import java.util.List;

public class M139_WordBreak {
	
    public boolean wordBreak(String s, List<String> wordDict) {
    	int n = s.length();
    	boolean[] f = new boolean[n+1];
    	f[0] = true;
    	
    	for(int i=1; i<n+1; i++){
    		for(String prefix : wordDict){
    			if(i-prefix.length()>=0 
    					&& prefix.equals(s.substring(i-prefix.length(), i))
    					&& f[i-prefix.length()]){
    				f[i] = true;
    				break;
    			}
    		}
    	}

    	return f[n];
    }
    
}
