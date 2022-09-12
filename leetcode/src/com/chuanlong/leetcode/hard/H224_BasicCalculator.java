package com.chuanlong.leetcode.hard;

import java.util.Stack;

public class H224_BasicCalculator {

	public static void main(String[] args) {
		H224_BasicCalculator obj = new H224_BasicCalculator();

		System.out.println("Test1, expect:2, output:" + obj.calculate("1 + 1"));
		System.out.println("Test2, expect:3, output:" + obj.calculate(" 2-1 + 2 "));
		System.out.println("Test3, expect:23, output:" + obj.calculate("(1+(4+5+2)-3)+(6+8)"));
		System.out.println("Test4, expect:3, output:" + obj.calculate("1-(         -2)"));
		System.out.println("Test5, expect:23, output:" + obj.calculate("(1+(4+5+2)-3)+(6+8)"));
	}


	public int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int operand = 0;
		int result = 0;
		int signal = 1;
		char[] chs = s.toCharArray();
		for(int i=0; i<chs.length; i++) {
			char ch = chs[i];
			if(ch >= '0' && ch <= '9') {
				operand = operand*10 + (ch-'0');
			} else if (ch == '+') {
				result = result + signal*operand;
				signal = 1;
				operand = 0;
			} else if (ch == '-') {
				result = result + signal*operand;
				signal = -1;
				operand = 0;
			} else if (ch == '(') {
				stack.push(result);
				stack.push(signal);
				result = 0;
				signal = 1;
			} else if (ch == ')') {
				int prevSignal = stack.pop();
				int prevOperand = stack.pop();

				result = prevOperand + prevSignal * (result + signal*operand);
				signal = 1;
				operand = 0;
			}
		}
		return result + signal*operand;
	}




    public int calculate3(String s) {
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

	public int calculate2(String s) {
		return evaluate2(s);
	}

	public int evaluate2(String s) {
    	char[] chs = s.toCharArray();

    	int prev = 0;
		int curr = 0;
		int sign = '+';

    	for(int i=0; i<chs.length; i++) {
    		if(chs[i] >= '0' && chs[i] <= '9') {
    			curr = curr*10 + (chs[i]-'0');
			} else if (chs[i] == '+' || chs[i] == '-') {
    			if(sign == '+') {
    				prev = prev + curr;
				} else if (sign == '-') {
    				prev = prev - curr;
				}
    			sign = chs[i];
    			curr = 0;
			} else if (chs[i] == '(') {
    			int end = findRightIndex(s, i);
    			curr = evaluate2(s.substring(i+1, end));
    			i = end;
			}
		}
    	if(sign == '+') {
    		prev = prev + curr;
		} else if (sign == '-') {
    		prev = prev - curr;
		}
    	return prev;
	}

	private int findRightIndex(String s, int x) {
    	char[] chs = s.toCharArray();
    	int count = 1;
    	for(int i=x+1; i<s.length(); i++) {
    		if(chs[i] == '(') {
    			count++;
			} else if (chs[i] == ')') {
    			count--;
				if(count == 0) return i;
    		}
		}
    	return -1;
	}

}
