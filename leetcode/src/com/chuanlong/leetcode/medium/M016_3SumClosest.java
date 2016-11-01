package com.chuanlong.leetcode.medium;

import java.util.Arrays;

public class M016_3SumClosest {

	/**
	 * https://leetcode.com/problems/3sum-closest/
	 */
	public static void main(String[] args) {
		
		M016_3SumClosest obj = new M016_3SumClosest();
		
		System.out.println("{0,0,0,1,1}, 3 -> 2, result:" + obj.threeSumClosest(new int[]{0,0,0,1,1}, 3));
		
	}
	
	
    public int threeSumClosest(int[] nums, int target) {
    	Arrays.sort(nums);
    	
    	int distance = Integer.MAX_VALUE;
    	int sum = -1;
    	for(int i=0; i<nums.length; i++){
    		for(int j=i+1; j<nums.length; j++){
    			int k = closest(nums, target-nums[i]-nums[j], 0, nums.length-1, i, j);

    			System.out.println("i,j,k:" + i+"," + j +"," +k);
    			
    			int newDistance = Math.abs(nums[i]+nums[j]+nums[k]-target);
    			if(newDistance < distance){
    				distance = newDistance;
    				sum = nums[i] + nums[j] + nums[k];
    			}
    		}
    	}    	
    	return sum;
    }
    
    
    private int closest(int[] nums, int val, int start, int end, int ignore1, int ignore2){
    	if(start >= end){
    		int index = -1;
    		int distance = Integer.MAX_VALUE;
    		int x1 = end;
    		int x2 = start;
    		
    		while(x1 != -1 && (x1 == ignore1 || x1 == ignore2)){
    			x1 = (x1-1 >= 0 ? x1-1 : -1);    			
    		}
    		
    		while(x2 != -1 && (x2 == ignore1 || x2 == ignore2)){
    			x2 = (x2+1 < nums.length ? x2+1 : -1);
    		}
    		
    		if(x1 != -1){
    			if(Math.abs(val-nums[x1]) < distance){
    				distance = Math.abs(val-nums[x1]);
    				index = x1;
    			}	
    		}
    		
    		if(x2 != -1 && x2 != x1){
    			if(Math.abs(val-nums[x2]) < distance){
    				distance = Math.abs(val-nums[2]);
    				index = x2;
    			}
    		}
    		
    		return index;
    	}
    	
    	int mid = (start + end)/2;
    	if(nums[mid] == val){
    		return closest(nums, val, mid, mid, ignore1, ignore2);
    	}else{
    		if(nums[mid] < val){
    			return closest(nums, val, mid+1, end, ignore1, ignore2);
    		}else{
    			return closest(nums, val, start, mid-1, ignore1, ignore2);
    		}
    	}
    }
    
}
