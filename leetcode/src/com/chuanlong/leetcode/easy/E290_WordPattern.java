package com.chuanlong.leetcode.easy;

public class E290_WordPattern {

	/**
	 * https://leetcode.com/problems/word-pattern/
	 */
	public static void main(String[] args) {

		E290_WordPattern obj = new E290_WordPattern();
		
		System.out.println("abba, 'dog cat cat dog' -> true, result:" + obj.wordPattern("abba", "dog cat cat dog"));
		System.out.println("abba, 'dog cat cat fish' -> false, result:" + obj.wordPattern("abba", "dog cat cat fish"));
		System.out.println("abba, 'dog dog dog dog' -> false, result:" + obj.wordPattern("abba", "dog dog dog dog"));
	}
	
	
    public boolean wordPattern(String pattern, String str) {
    	char[] patterns = pattern.toCharArray();
    	String[] tokens = str.split(" ");
    	
    	if(patterns.length != tokens.length){
    		return false;
    	}
    	
    	String[] maps = new String[26];
    	for(int i=0; i<tokens.length; i++){
    		if(maps[patterns[i]-'a'] == null){
    			maps[patterns[i]-'a'] = tokens[i];
    		}else{
    			if(!maps[patterns[i]-'a'].equals(tokens[i])){
    				return false;
    			}
    		}
    	} 
    	
    	for(int i=0; i<maps.length; i++){
    		for(int j=i+1; j<maps.length; j++){
    			if(maps[i] != null && maps[j] != null
    					&& maps[i].equals(maps[j])){
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }

}
