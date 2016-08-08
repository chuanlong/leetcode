package com.chuanlong.leetcode.easy;


public class E169_MajorityElement {

	/**
	 * https://leetcode.com/problems/majority-element/
	 */
	public static void main(String[] args) {
		
		E169_MajorityElement obj = new E169_MajorityElement();
		
		System.out.println("{2} -> 2, result:" + obj.majorityElement(new int[]{2}));
		System.out.println("{2,2} -> 2, result:" + obj.majorityElement(new int[]{2,2}));
		System.out.println("{2,3,2} -> 2, result:" + obj.majorityElement(new int[]{2,3,2}));

	}
	
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        
        int[] signs = new int[nums.length];
        for(int i=0; i<signs.length; i++){
        	signs[i] = 1;
        }

        int i=0, j=0;
        while(i<nums.length && j<nums.length){
        	if(i == j || signs[j] == 0){
        		j++; continue;
        	}
        	if(signs[i] == 0){
        		i++; continue;
        	}
        	if(nums[i] == nums[j]){
        		j++; continue;
        	}else{
        		signs[i] = 0;
        		signs[j] = 0;
        		i++;j++;
        	}        	
        }
        
        while(i<nums.length){
        	if(signs[i] == 1){
        		return nums[i];
        	}
        	i++;
        }        
    	
    	return 0;
    }
	

}
