package com.chuanlong.leetcode.easy;

import java.util.Stack;

public class E020_ValidParentheses {

	/**
	 * https://leetcode.com/problems/valid-parentheses/
	 */
	public static void main(String[] args) {

	}
	
	
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
        	return true;
        }
        
        Stack<Character> stack = new Stack<Character>();
        
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++){
        	char ch = chars[i];
        	if(ch == '(' || ch == '[' || ch == '{'){
        		stack.push(ch);
        	}else if(ch == ')' || ch == ']' || ch == '}'){
        		if(stack.isEmpty()){
        			return false;
        		}
        		char peer = stack.pop();
        		if((ch == ')' && peer == '(')
        				|| (ch == ']' && peer == '[')
        				|| (ch == '}' && peer == '{')){
        			continue;
        		}else{
        			return false;
        		}
        	}else{
        		return false;
        	}
        }
        
        if(stack.isEmpty()){
        	return true;
        }else{
        	return false;
        }
    }

}
