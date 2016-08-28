package com.chuanlong.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E350_IntersectionOfTwoArrays2 {

	/**
	 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
	 * */
	public static void main(String[] args) {

	}
	
	
    public int[] intersect(int[] nums1, int[] nums2) {
    	if(nums1 == null || nums1.length == 0
    			|| nums2 == null || nums2.length == 0){
    		return new int[0];
    	}
        
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i=0, j=0; i<nums1.length && j<nums2.length;){
    		if(nums1[i] == nums2[j]){
    			list.add(nums1[i]);
    			i++;
    			j++;
    		}else if(nums1[i] < nums2[j]){
    			i++;
    		}else{
    			j++;
    		}
    	}
    	
    	
    	int[] interesctions = new int[list.size()];
    	for(int i=0; i<list.size(); i++){
    		interesctions[i] = list.get(i);
    	}
    	return interesctions;
    }
	

}
