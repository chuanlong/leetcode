package com.chuanlong.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class E118_PascalsTriangle {

	/**
	 * https://leetcode.com/problems/pascals-triangle/
	 */
	public static void main(String[] args) {
		
		E118_PascalsTriangle obj = new E118_PascalsTriangle();
		
		obj.generate(5);
	}
	
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	for(int i=0; i<numRows; i++){
    		List<Integer> row = new ArrayList<Integer>();
    		for(int j=0; j<i+1; j++){
    			if(j == 0 || j == i){
    				row.add(1);
    			}else{
    				row.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
    			}
    		}
    		list.add(row);
    	}
    	return list;
    }

}
