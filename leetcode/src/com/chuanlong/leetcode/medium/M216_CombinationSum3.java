package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M216_CombinationSum3 {

	/**
	 * https://leetcode.com/problems/combination-sum-iii/
	 */
	public static void main(String[] args) {

	}
	
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
    	        
        combination(list, new ArrayList<Integer>(), k, 1, n);
    	
        return list;
    }
    
    
    private void combination(List<List<Integer>> list, List<Integer> combine, int k, int start, int n){
    	if(combine.size() == k && n == 0){
    		List<Integer> success = new ArrayList<Integer>(combine);
    		list.add(success);
    	}else{
        	for(int i=start; i<=9; i++){
        		combine.add(i);
        		combination(list, combine, k, i+1, n-i);
        		combine.remove(combine.size()-1);
        	}
    	}
    }

}
