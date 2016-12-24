package com.chuanlong.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H336_PalindromePairs {

	/**
	 * https://leetcode.com/problems/palindrome-pairs/
	 */
	public static void main(String[] args) {

	}
	
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        if(words != null && words.length > 0){
        	Map<String, Integer> map = new HashMap<>();
        	for(int i=0; i<words.length; i++) map.put(words[i], i);
        
        	for(int i=0; i<words.length; i++){
        		String origin = words[i];
        		        		
        		for(int j=0; j<=origin.length(); j++){
        			String left = origin.substring(0, j);
        			String right = origin.substring(j);
        			
        			if(isPalindrome(left)){
        				String rightReverse = new StringBuffer(right).reverse().toString();
        				Integer index = map.get(rightReverse);
        				if(index != null && index != i && left.length() > 0){
        					List<Integer> item = new ArrayList<>();
        					item.add(index);
        					item.add(i);
        					list.add(item);        					
        				}
        			}
        			
        			if(isPalindrome(right)){
        				String leftReverse = new StringBuffer(left).reverse().toString();
        				Integer index = map.get(leftReverse);
        				if(index != null && index != i){
        					List<Integer> item = new ArrayList<>();
        					item.add(i);
        					item.add(index);
        					list.add(item);
        				}
        			}  
        			
        		}        		
        	}
        }    	
    	
    	return list;
    }
    
    
    
    private boolean isPalindrome(String str){
    	int i = 0, j = str.length()-1;
    	while(i < j){
    		if(str.charAt(i) != str.charAt(j)){
    			return false;
    		}else{
    			i++; j--;
    		}
    	}
    	return true;
    }
    

}
