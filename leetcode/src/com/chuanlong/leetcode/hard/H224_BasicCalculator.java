package com.chuanlong.leetcode.hard;

import java.util.Stack;

public class H224_BasicCalculator {
	
    public int calculate(String s) {
    	if(s == null || s.length() == 0){
    		return 0;
    	}
    	
    	int n = s.length();
    	char[] chs = s.toCharArray();
    	Stack<Integer> stack = new Stack<Integer>();
    	int calc = 0;
    	int sign = 1;
    	for(int i=0; i<n; i++){
    		if(chs[i] >= '0' && chs[i] <= '9'){
    			int token = chs[i] - '0';
    			while(i+1<n && chs[i+1] >= '0' && chs[i+1] <='9'){
    				token = token*10 + (chs[++i]-'0');
    			}
    			calc = calc + sign*token;
    		}else{
    			if(chs[i] == '+'){
	    			sign = 1;
	    		}else if(chs[i] == '-'){
	    			sign = -1;
	    		}else if(chs[i] == '('){
	    			stack.push(calc);
	    			stack.push(sign);
	    			calc = 0;
	    			sign = 1;
	    		}else if(chs[i] == ')'){
	    			int sig = stack.pop();
	    			int num = stack.pop();
	    			calc = num + sig*calc;
	    		}
    		}
    	}
    	return calc;
    }

}
