package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M241_DifferentWaysToAddParentheses {

	/**
	 * https://leetcode.com/problems/different-ways-to-add-parentheses/
	 */
	public static void main(String[] args) {

		M241_DifferentWaysToAddParentheses obj = new M241_DifferentWaysToAddParentheses();
		
		obj.diffWaysToCompute("2-1-1");
	}
	
    public List<Integer> diffWaysToCompute(String input) {
        
    	String[] tokens = input.split("[\\+\\-\\*]");
    	
    	List<Integer> list = new ArrayList<Integer>();
    	if(tokens.length == 1){
    		list.add(Integer.parseInt(input));
    	}else{
        	char[] chars = input.toCharArray();
        	for(int i=0; i<chars.length; i++){
        		if(chars[i] == '+' || chars[i] == '-' || chars[i] == '*'){

        			List<Integer> left = diffWaysToCompute(input.substring(0, i));
        			List<Integer> right = diffWaysToCompute(input.substring(i+1));
        			
        			List<Integer> total = cal(left, right, chars[i]);
        			
        			list.addAll(total);
        		}
        	}
    	}
    	
    	return list;
    }
    
    
    
    private List<Integer> cal(List<Integer> left, List<Integer> right, char symbol){
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i=0; i<left.size(); i++){
    		for(int j=0; j<right.size(); j++){
    			if(symbol == '+'){
    				list.add(left.get(i) + right.get(j));
    			}else if(symbol == '-'){
    				list.add(left.get(i) - right.get(j));
    			}else{
    				list.add(left.get(i) * right.get(j));
    			}
    		}
    	}
    	return list;
    }
    
    
    

}
