package com.chuanlong.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H140_WordBreakII {
	
	public static void main(String[] args) {
	
		String s = "catsanddog";
		List<String> list = Arrays.asList("cat", "cats", "and", "sand", "dog");
		
		H140_WordBreakII obj = new H140_WordBreakII();
		obj.wordBreak(s, list);
	}

    public List<String> wordBreak(String s, List<String> wordDict) {
    	return wordBreak(s, wordDict, new HashMap<String, List<String>>());
    }
    
    private List<String> wordBreak(String s, List<String> wordDict, Map<String, List<String>> map){
    	if(map.containsKey(s)){
    		return map.get(s);
    	}
    	
    	List<String> list = new ArrayList<String>();
    	
    	for(String str : wordDict){
    		if(s.equals(str)){
    			list.add(str);
    		}else if(s.startsWith(str)){
    			List<String> subList = wordBreak(s.substring(str.length()), wordDict, map);
    			for(String subStr : subList){
    				list.add(str + " " + subStr);
    			}
    		}
    	}
    	
    	map.put(s, list);
    	return list;
    }
	
}
