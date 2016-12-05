package com.chuanlong.leetcode.hard;

public class H004_MedianOfTwoSortedArrays {

	/**
	 * https://leetcode.com/problems/median-of-two-sorted-arrays/
	 */
	public static void main(String[] args) {

		H004_MedianOfTwoSortedArrays obj = new H004_MedianOfTwoSortedArrays();
		obj.findMedianSortedArrays(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2});
		
	}
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        if((m+n)%2 == 1){
        	int k = (m+n+1)/2;
        	int kth = getKth(nums1, 0, m, nums2, 0, n, k);
        	return (double) kth;
        }else{
        	int k1 = (m+n)/2;
        	int k2 = (m+n)/2 + 1;
        	
        	int kth1 = getKth(nums1, 0, m, nums2, 0, n, k1);
        	int kth2 = getKth(nums1, 0, m, nums2, 0, n, k2);
        	
        	return ((double) kth1 + kth2) / 2.0;
        }    	
    }
    
    private int getKth(int[] nums1, int start1, int length1, int[] nums2, int start2, int length2, int k){
    	// keep length1 <= length2
    	if(length1 > length2){
    		return getKth(nums2, start2, length2, nums1, start1, length1, k);    		
    	}
    	
    	if(length1 == 0){
    		return nums2[start2+k-1];
    	}
    	
    	if(k == 1){
    		return Math.min(nums1[start1], nums2[start2]);
    	}
    	
    
    	int i = Math.min(length1, k/2), j = Math.min(length2, k/2);
    	if(nums1[start1+i-1] < nums2[start2+j-1]){
    		return getKth(nums1, start1+i, length1-i, nums2, start2, length2, k-i);
    	}else{
    		return getKth(nums1, start1, length1, nums2, start2+j, length2-j, k-j);
    	}
    }

}
