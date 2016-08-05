package com.chuanlong.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.chuanlong.leetcode.util.Util;

public class E349_IntersectionOfTwoArrays {

	/**
	 * https://leetcode.com/problems/intersection-of-two-arrays/
	 */
	public static void main(String[] args) {

		E349_IntersectionOfTwoArrays obj = new E349_IntersectionOfTwoArrays();
		
		System.out.println("[2], [2] -> [2] , result:" + Util.Array2String(obj.intersection(new int[]{2},new int[]{2})));
		System.out.println("[1,2,2,1], [2,2] -> [2] , result:" + Util.Array2String(obj.intersection(new int[]{1,2,2,1},new int[]{2,2})));
		
//		int[] nums1 = new int[]{5,1,5,4,6,8,7,6,8,7};
//		obj.sort(nums1, 0, nums1.length-1);
//		System.out.println(Util.Array2String(nums1));
	}
	
	
    public int[] intersection(int[] nums1, int[] nums2) {
    	List<Integer> x = new ArrayList<Integer>();
    	
    	if(nums1 != null && nums1.length > 0
    			&& nums2 != null && nums2.length > 0){
    		sort(nums1, 0, nums1.length-1);
    		sort(nums2, 0, nums2.length-1);
    		
    		for(int i=0, j=0; i<nums1.length && j<nums2.length;){
    			if(nums1[i] < nums2[j]){
    				i++;
    			}else if(nums1[i] > nums2[j]){
    				j++;
    			}else{
    				if(x.isEmpty() || x.get(x.size()-1) != nums1[i]){
    					x.add(nums1[i]);
    				}
					i++;
					j++;
    			}    			
    		}    		
    	}
    	
    	int[] y = new int[x.size()];
    	for(int i=0; i<x.size(); i++){
    		y[i] = x.get(i);
    	}
    	return y;
    }
    
    public void sort(int[] nums, int start, int end){
    	if(nums == null || start >= end || start < 0 || end >= nums.length){
    		return;
    	}
    	
    	int x = start+1;
    	int y = end;
    	while(x<y){
    		while(x<y && nums[x] <= nums[start]){
    			x++;
    		}
    		
    		while(x<y && nums[y] >= nums[start]){
    			y--;
    		}
    		
    		if(x<y){
    			int temp = nums[x];
    			nums[x] = nums[y];
    			nums[y] = temp;
    		}
    	}
    	
    	if(nums[x] >= nums[start]){
    		x = x-1;
    	}
    	
    	if(start < x){
    		int temp = nums[start];
    		nums[start] = nums[x];
    		nums[x] = temp;    		
    	}
    	if(start < x-1){
    		sort(nums, start, x-1);    		
    	}
    	if(x+1 < end){
    		sort(nums, x+1, end);        		
    	}	
    }

}
