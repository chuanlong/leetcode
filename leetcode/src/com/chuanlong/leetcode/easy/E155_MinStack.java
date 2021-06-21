package com.chuanlong.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class E155_MinStack {
	
	
	/**
	 * https://leetcode.com/problems/min-stack/
	 */
	public static void main(String[] args) {
		
	}
	
	
	class MinStack {

		private List<Integer> stack = new ArrayList<Integer>();
		private List<Integer> mins = new ArrayList<Integer>();
		
	    /** initialize your data structure here. */
	    public MinStack() {
	    	stack = new ArrayList<Integer>();
	    	mins = new ArrayList<Integer>();
	    }
	    
	    public void push(int x) {
	    	if(stack.size() > 0){
	    		int min = mins.get(mins.size()-1) > x ? x : mins.get(mins.size()-1);
	    		stack.add(x);
	    		mins.add(min);
	    	}else{
	    		stack.add(x);
	    		mins.add(x);
	    	}
	    }
	    
	    public void pop() {
	    	if(stack.size() > 0){
	    		stack.remove(stack.size()-1);
	    		mins.remove(mins.size()-1);
	    	}
	    }
	    
	    public int top() {
	    	if(stack.size() > 0){
	    		return stack.get(stack.size()-1);
	    	}else{
	    		return -1;
	    	}
	    }
	    
	    public int getMin() {
	    	if(mins.size() > 0){
	    		return mins.get(mins.size()-1);
	    	}else{
	    		return -1;
	    	}
	    }
	}



	class MinStack2 {
		private final static int DEFAULT = Integer.MIN_VALUE;
		private Stack<Integer> s1;
		private Stack<Integer> s2;

		public MinStack2() {
			s1 = new Stack<>();
			s2 = new Stack<>();
		}

		public void push(int val) {
			if(s1.empty()) {
				s2.push(val);
			} else {
				s2.push(Math.min(s2.peek(), val));
			}
			s1.push(val);
		}

		public void pop() {
			s1.pop();
			s2.pop();
		}

		public int top() {
			if(s1.empty()) {
				return DEFAULT;
			} else {
				return s1.peek();
			}
		}

		public int getMin() {
			if(s1.empty()) {
				return DEFAULT;
			} else {
				return s2.peek();
			}
		}
	}
}
