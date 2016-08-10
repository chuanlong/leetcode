package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M077_Combinations {

	/**
	 * https://leetcode.com/problems/combinations/
	 */
	public static void main(String[] args) {
		
		M077_Combinations obj = new M077_Combinations();

		System.out.println("4 1 -> [[1],[2],[3],[4]] , result:" + obj.combine(4, 1));
		System.out.println("4 2 -> [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]] , result:" + obj.combine(4, 2));

	}
	
	
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();

    	if(n > 0 && k > 0){
        	if(n == k){
        		List<Integer> item = new ArrayList<Integer>();
        		for(int i=1; i<n+1; i++){
        			item.add(i);
        		}
        		list.add(item);
        	}else if(n > k){
        		List<List<Integer>> list1 = combine(n-1, k-1);
        		for(int i=0; i<list1.size(); i++){
        			list1.get(i).add(n);
        		}
        		if(k == 1){
        			List<Integer> item = new ArrayList<Integer>();
        			item.add(n);
        			list1.add(item);
        		}        		
        		list.addAll(list1);
        		
        		List<List<Integer>> list2 = combine(n-1, k);
        		list.addAll(list2);
        	}
    	}
    	
    	return list;
    }
    
}
