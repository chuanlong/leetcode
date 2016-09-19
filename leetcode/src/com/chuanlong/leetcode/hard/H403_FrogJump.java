package com.chuanlong.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class H403_FrogJump {

	/**
	 * https://leetcode.com/problems/frog-jump/
	 */
	public static void main(String[] args) {

	}
	
	
    public boolean canCross(int[] stones) {
        if(stones.length < 2 || stones[0] != 0 || stones[1] != 1){
        	return false;
        }
    	
        int n = stones.length;
        List<List<Integer>> possible = new ArrayList<List<Integer>>();
        
        possible.add(new ArrayList<Integer>()); // 0
        possible.add(new ArrayList<Integer>()); // 1
        possible.get(1).add(1);
        
        for(int i=2; i<stones.length; i++){
        	possible.add(new ArrayList<Integer>());
        	
        	for(int j=i-1; j>=1; j--){
        		int gap = stones[i] - stones[j];
        		if(possible.get(j).contains(gap) 
        				|| possible.get(j).contains(gap-1)
        				|| possible.get(j).contains(gap+1)){
        			possible.get(i).add(gap);
        		}
        	}
        	
        }
        
        if(possible.size() == n && possible.get(n-1).size() > 0){
        	return true;
        }else{
        	return false;
        }
        
    }

}
