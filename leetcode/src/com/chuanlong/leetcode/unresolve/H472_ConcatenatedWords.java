package com.chuanlong.leetcode.unresolve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class H472_ConcatenatedWords {

	public static void main(String[] args) {
		
		String[] words = new String[]{"cat", "dog", "catdog"};
		H472_ConcatenatedWords obj = new H472_ConcatenatedWords();
		obj.findAllConcatenatedWordsInADict(words);
	}
	
	
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
    	List<String> list = new ArrayList<String>();
    	Arrays.sort(words, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
    	
    	Set<String> dict = new HashSet<String>();
    	for(int i=0; i<words.length; i++){
    		if(isWordBreak(words[i], dict)){
    			list.add(words[i]);
    		}
    		dict.add(words[i]);
    	}
    	return list;
    }
    
    
    private boolean isWordBreak(String s, Set<String> dict){
    	if(dict.isEmpty()) return false;
    	
    	int n = s.length();
    	boolean[] f = new boolean[n+1];
    	f[0] = true;
    	for(int i=1; i<n+1; i++){
    		for(int j=0; j<i; j++){
    			if(f[j] && dict.contains(s.substring(j, i))){
    				f[i] = true;
    				break;
    			}
    		}
    	}
    	return f[n];
    }
	
	
    public List<String> findAllConcatenatedWordsInADict1(String[] words) {
    	List<String> list = new ArrayList<String>();
    	
    	Arrays.sort(words, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        List<String> dict = new ArrayList<String>();
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	for(int i=0; i<words.length; i++){
    		dict.add(words[i]);
    	}
    	
    	int n = dict.size();
    	for(int i=0; i<n; i++){
    		String s = dict.get(i);
    		if(isWordBreak(s, dict, map) == 2){
    			list.add(s);
    		}
    	}
    	return list;
    }
    
    private Integer isWordBreak(String s, List<String> dict, Map<String, Integer> map){
    	if(map.containsKey(s)) {
    		return map.get(s);
    	}
    	
    	Integer isWordBreak = 0;
    	for(String str : dict){
    		if(s.equals(str)){
    			isWordBreak = 1;
    			break;
    		}else if(s.length() > str.length() && s.startsWith(str)){
    			Integer isSubWordBreak = isWordBreak(s.substring(str.length()), dict, map);
    			if(isSubWordBreak >= 1){
    				isWordBreak = 2;
    				break;
    			}
    		}
    	}
    	
    	map.put(s, isWordBreak);
    	return isWordBreak;
    }

}
