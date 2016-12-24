package com.chuanlong.leetcode.medium;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.chuanlong.leetcode.bean.NestedInteger;

public class M341_FlattenNestedListIterator {

	/**
	 * https://leetcode.com/problems/flatten-nested-list-iterator/
	 */
	public static void main(String[] args) {

	}

	public class NestedIterator implements Iterator<Integer> {

		Stack<NestedInteger> stack;
		
	    public NestedIterator(List<NestedInteger> nestedList) {
	        stack = new Stack<>();
	        add(nestedList);
	    }

	    @Override
	    public Integer next() {
	    	if(!stack.isEmpty()){
	    		NestedInteger top = stack.pop();
	    		if(top.isInteger()){
	    			return top.getInteger();
	    		}else{
	    			List<NestedInteger> list = top.getList();
	    			add(list);
	    			return next();
	    		}	    		
	    	}else{
	    		return null;
	    	}
	    }

	    @Override
	    public boolean hasNext() {
	    	if(!stack.isEmpty()){
	    		NestedInteger top = stack.pop();
	    		if(top.isInteger()){
	    			stack.push(top);
	    			return true;
	    		}else{
	    			List<NestedInteger> list = top.getList();
	    			add(list);
	    			return hasNext();
	    		}	    		
	    	}else{
	    		return false;
	    	}
	    }
	    
	    private void add(List<NestedInteger> list){
	        for(int i=list.size()-1; i>=0; i--){
	        	stack.add(list.get(i));
	        }
	    }
	    
	}
	
}
