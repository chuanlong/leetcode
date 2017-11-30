package com.chuanlong.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    public boolean wordBreak1(String s, List<String> wordDict) {
    	return wordBreak(s, wordDict, new HashMap<String, Boolean>());
    }
    
    private boolean wordBreak(String s, List<String> wordDict, Map<String, Boolean> map){
    	if(map.containsKey(s)){
    		return map.get(s);
    	}
    	
    	Boolean isWordBreak = false;
    	for(String str : wordDict){
    		if(s.equals(str)){
    			isWordBreak = true;
    			break;
    		}else if(str.length() < s.length() && s.startsWith(str)){
    			Boolean isSubWordBreak = wordBreak(s.substring(str.length()), wordDict, map);
    			if(isSubWordBreak){
    				isWordBreak = true;
        			break;
    			}
    		}
    	}
    	
    	map.put(s, isWordBreak);
    	return isWordBreak;
    }
    
    
    
}
