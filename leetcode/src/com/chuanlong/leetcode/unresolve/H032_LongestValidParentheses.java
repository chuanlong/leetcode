package com.chuanlong.leetcode.unresolve;

import java.util.Stack;

public class H032_LongestValidParentheses {
	
    public int longestValidParentheses(String s) {
    	int max = 0;
    	Stack<Character> stack = new Stack<Character>();
    	if(s != null && s.length() != 0){
    		char[] chs = s.toCharArray();
    		for(int i=0; i<chs.length; i++){
    			if(!stack.isEmpty() && stack.peek() == '(' && chs[i] == ')'){
    				stack.pop();
    				max = max+2;
    			}else{
    				stack.push(chs[i]);
    			}
    		}
    	}
    	return max;
    }

}
