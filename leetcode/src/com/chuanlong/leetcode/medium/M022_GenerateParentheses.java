package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M022_GenerateParentheses {

	/**
	 * https://leetcode.com/problems/generate-parentheses/
	 */
	public static void main(String[] args) {

	}
	
	
    public List<String> generateParenthesis(int n) {
    	
    	List<String> list = new ArrayList<String>();

    	generateParenthesis(n, 0, 0, "", list);
    	
    	return list;
    }
    
    
    public void generateParenthesis(int n, int left, int right, String str, List<String> list){
    	if(n == left && n == right){
    		list.add(str);
    		return;
    	}
    	
    	if(left < n){
    		generateParenthesis(n, left+1, right, str + "(", list);
    	}
    	
    	if(right < n && right < left){
    		generateParenthesis(n, left, right+1, str + ")", list);
    	}
    	
    }

}
