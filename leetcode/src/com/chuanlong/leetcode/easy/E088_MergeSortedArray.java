package com.chuanlong.leetcode.easy;

public class E088_MergeSortedArray {

	public static void main(String[] args) {

	}
	
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int index = m+n-1;
    	int i = m-1, j = n-1;
    	while((i>=0 || j>=0) && index>i){
    		if(i<0 || nums1[i] <= nums2[j]){
    			nums1[index--] = nums2[j--];
    		}else{
    			nums1[index--] = nums1[i--];
    		}
    	}
    }

}
