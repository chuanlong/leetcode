package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M120_Triangle {

	public static void main(String[] args) {

	}
	
    public int minimumTotal(List<List<Integer>> triangle) {
    	if(triangle.size() == 0){
    		return 0;
    	}else{
        	List<List<Integer>> min = new ArrayList<List<Integer>>();
        	for(int i=0; i<triangle.size(); i++){
        		List<Integer> rowMin = new ArrayList<Integer>();
        		for(int j=0; j<triangle.get(i).size(); j++){
        			int temp = Integer.MAX_VALUE;
        			if(i-1>=0 && j-1>=0){
        				temp = min.get(i-1).get(j-1);
        			}
        			if(i-1>=0 && j<min.get(i-1).size()){
        				temp = Math.min(temp, min.get(i-1).get(j));
        			}
        			if(temp == Integer.MAX_VALUE){
            			rowMin.add(triangle.get(i).get(j));
        			}else{
            			rowMin.add(temp+triangle.get(i).get(j));
        			}
        		}
            	min.add(rowMin);
        	}
        	
        	int lastMin = Integer.MAX_VALUE;
        	for(int i=0; i<min.get(min.size()-1).size(); i++){
        		lastMin = Math.min(lastMin, min.get(min.size()-1).get(i));
        	}
        	
        	return lastMin;
    	}
    }

}
