package com.chuanlong.leetcode.hard;

import com.chuanlong.leetcode.util.Util;

public class H321_CreateMaximumNumber {

	/**
	 * https://leetcode.com/problems/create-maximum-number/
	 * */
	public static void main(String[] args) {
		
		H321_CreateMaximumNumber obj = new H321_CreateMaximumNumber();
		
//		int[] max1 = obj.maxNumber(new int[]{3,4,6,5}, new int[]{9,1,2,5,8,3}, 5);
//		
//		System.out.println(Util.Array2String(max1) + "--> expect:\n[9,8,6,5,3]\n");
//
//		int[] max2 = obj.maxNumber(new int[]{6,7}, new int[]{6,0,4}, 5);
//		
//		System.out.println(Util.Array2String(max2) + "--> expect:\n[6,7,6,0,4]\n");
//
//		int[] max3 = obj.maxNumber(new int[]{3,9}, new int[]{8,9}, 3);
//		
//		System.out.println(Util.Array2String(max3) + "--> expect:\n[9,8,9]\n");
//		
//		
//		int[] max4 = obj.maxNumber(new int[]{2,5,6,4,4,0}, new int[]{7,3,8,0,6,5,7,6,2}, 15);
//		
//		System.out.println(Util.Array2String(max4) + "--> expect:\n[7,3,8,2,5,6,4,4,0,6,5,7,6,2,0]\n");
//	
//
//		int[] max5 = obj.maxNumber(
//				new int[]{5,0,2,1,0,1,0,3,9,1,2,8,0,9,8,1,4,7,3}, 
//				new int[]{7,6,7,1,0,1,0,5,6,0,5,0}, 31);
//		
//		System.out.println(Util.Array2String(max5) + "--> expect:\n[7,6,7,5,1,0,2,1,0,1,0,5,6,0,5,0,1,0,3,9,1,2,8,0,9,8,1,4,7,3,0]\n");
	
		int[] max6 = obj.maxNumber(
				new int[]{8,9,7,3,5,9,1,0,8,5,3,0,9,2,7,4,8,9,8,1,0,2,0,2,7,2,3,5,4,7,4,1,4,0,1,4,2,1,3,1,5,3,9,3,9,0,1,7,0,6,1,8,5,6,6,5,0,4,7,2,9,2,2,7,6,2,9,2,3,5,7,4,7,0,1,8,3,6,6,3,0,8,5,3,0,3,7,3,0,9,8,5,1,9,5,0,7,9,6,8,5,1,9,6,5,8,2,3,7,1,0,1,4,3,4,4,2,4,0,8,4,6,5,5,7,6,9,0,8,4,6,1,6,7,2,0,1,1,8,2,6,4,0,5,5,2,6,1,6,4,7,1,7,2,2,9,8,9,1,0,5,5,9,7,7,8,8,3,3,8,9,3,7,5,3,6,1,0,1,0,9,3,7,8,4,0,3,5,8,1,0,5,7,2,8,4,9,5,6,8,1,1,8,7,3,2,3,4,8,7,9,9,7,8,5,2,2,7,1,9,1,5,5,1,3,5,9,0,5,2,9,4,2,8,7,3,9,4,7,4,8,7,5,0,9,9,7,9,3,8,0,9,5,3,0,0,3,0,4,9,0,9,1,6,0,2,0,5,2,2,6,0,0,9,6,3,4,1,2,0,8,3,6,6,9,0,2,1,6,9,2,4,9,0,8,3,9,0,5,4,5,4,6,1,2,5,2,2,1,7,3,8,1,1,6,8,8,1,8,5,6,1,3,0,1,3,5,6,5,0,6,4,2,8,6,0,3,7,9,5,5,9,8,0,4,8,6,0,8,6,6,1,6,2,7,1,0,2,2,4,0,0,0,4,6,5,5,4,0,1,5,8,3,2,0,9,7,6,2,6,9,9,9,7,1,4,6,2,8,2,5,3,4,5,2,4,4,4,7,2,2,5,3,2,8,2,2,4,9,8,0,9,8,7,6,2,6,7,5,4,7,5,1,0,5,7,8,7,7,8,9,7,0,3,7,7,4,7,2,0,4,1,1,9,1,7,5,0,5,6,6,1,0,6,9,4,2,8,0,5,1,9,8,4,0,3,1,2,4,2,1,8,9,5,9,6,5,3,1,8,9,0,9,8,3,0,9,4,1,1,6,0,5,9,0,8,3,7,8,5}, 
				new int[]{7,8,4,1,9,4,2,6,5,2,1,2,8,9,3,9,9,5,4,4,2,9,2,0,5,9,4,2,1,7,2,5,1,2,0,0,5,3,1,1,7,2,3,3,2,8,2,0,1,4,5,1,0,0,7,7,9,6,3,8,0,1,5,8,3,2,3,6,4,2,6,3,6,7,6,6,9,5,4,3,2,7,6,3,1,8,7,5,7,8,1,6,0,7,3,0,4,4,4,9,6,3,1,0,3,7,3,6,1,0,0,2,5,7,2,9,6,6,2,6,8,1,9,7,8,8,9,5,1,1,4,2,0,1,3,6,7,8,7,0,5,6,0,1,7,9,6,4,8,6,7,0,2,3,2,7,6,0,5,0,9,0,3,3,8,5,0,9,3,8,0,1,3,1,8,1,8,1,1,7,5,7,4,1,0,0,0,8,9,5,7,8,9,2,8,3,0,3,4,9,8,1,7,2,3,8,3,5,3,1,4,7,7,5,4,9,2,6,2,6,4,0,0,2,8,3,3,0,9,1,6,8,3,1,7,0,7,1,5,8,3,2,5,1,1,0,3,1,4,6,3,6,2,8,6,7,2,9,5,9,1,6,0,5,4,8,6,6,9,4,0,5,8,7,0,8,9,7,3,9,0,1,0,6,2,7,3,3,2,3,3,6,3,0,8,0,0,5,2,1,0,7,5,0,3,2,6,0,5,4,9,6,7,1,0,4,0,9,6,8,3,1,2,5,0,1,0,6,8,6,6,8,8,2,4,5,0,0,8,0,5,6,2,2,5,6,3,7,7,8,4,8,4,8,9,1,6,8,9,9,0,4,0,5,5,4,9,6,7,7,9,0,5,0,9,2,5,2,9,8,9,7,6,8,6,9,2,9,1,6,0,2,7,4,4,5,3,4,5,5,5,0,8,1,3,8,3,0,8,5,7,6,8,7,8,9,7,0,8,4,0,7,0,9,5,8,2,0,8,7,0,3,1,8,1,7,1,6,9,7,9,7,2,6,3,0,5,3,6,0,5,9,3,9,1,1,0,0,8,1,4,3,0,4,3,7,7,7,4,6,4,0,0,5,7,3,2,8,5,1,4,5,8,5,6,7,5,7,3,3,9,6,8,1,5,1,1,1,0,3},
				500);
		
		System.out.println(Util.Array2String(max6));
	
		
	}
	
	public int[] maxNumber(int[] nums1, int[] nums2, int k){
		int[] list = new int[k];
		int[] max = new int[k];
		for(int i=0; i<k; i++){
			list[i] = -1;
			max[i] = -1;
		}
		maxNumber(nums1, 0, nums2, 0, k, list, max);
		return max;
	}
	
	private void maxNumber(int[] nums1, int i, int[] nums2, int j,
			int k, int[] list, int[] max){
		if(k == 0){
			System.out.println(Util.Array2String(list));
			return;
		}
		
		int m = nums1.length;
		int n = nums2.length;
		
		int end1 = (k-(n-j)-1) <= 0 ? (m-1) : (m-1)-(k-(n-j)-1);
		int max1 = m;
		if(max1 < i || max1 > end1){
    		for(int x=i; x<=end1; x++){
    			if(max1 > end1 || nums1[x] > nums1[max1]){
    				max1 = x;
    			}
    		}
		}
		
		int end2 = (k-(m-i)-1) <= 0 ? (n-1) : (n-1)-(k-(m-i)-1);
		int max2 = n;
		if(max2 < j || max2 > end2){
			for(int x=j; x<=end2; x++){
				if(max2 > end2 || nums2[x] > nums2[max2]){
					max2 = x;
				}
			}
		}
		
		int choose = 0; // 0 equal, 1 choose nums1, 2 choose num2
		
		if(max1 < i || max1 > end1){
			choose = 2;
		}else if(max2 < j || max2 > end2){
			choose = 1;
		}else{
			if(nums1[max1] > nums2[max2]){
				choose = 1;
			}else if(nums1[max1] < nums2[max2]){
				choose = 2;
			}else{
				choose = 0;
			}
		}
		
		if(choose == 1){
			list[list.length-k] = nums1[max1];
			if(list[list.length-k] >= max[max.length-k]){
				if(list[list.length-k] > max[max.length-k]){
					max[max.length-k] = nums1[max1];
					for(int x=max.length-k+1; x<max.length; x++){
						max[x] = -1;
					}
				}
				maxNumber(nums1, max1+1, nums2, j, k-1, list, max);
			}
			list[list.length-k] = -1;
		}else if(choose == 2){
			list[list.length-k] = nums2[max2];
			if(list[list.length-k] >= max[max.length-k]){
				if(list[list.length-k] > max[max.length-k]){
					max[max.length-k] = nums2[max2];
					for(int x=max.length-k+1; x<max.length; x++){
						max[x] = -1;
					}
				}
				maxNumber(nums1, i, nums2, max2+1, k-1, list, max);
			}
			list[list.length-k] = -1;
		}else{
			// both
			int key = nums1[max1];
			list[list.length-k] = key;
			if(list[list.length-k] >= max[max.length-k]){
				if(list[list.length-k] > max[max.length-k]){
					max[max.length-k] = key;
					for(int x=max.length-k+1; x<max.length; x++){
						max[x] = -1;
					}
				}
				maxNumber(nums1, max1+1, nums2, j, k-1, list, max);
				maxNumber(nums1, i, nums2, max2+1, k-1, list, max);	
			}
			list[list.length-k] = -1;
		}
	}
	
//	// 0 equal, 1 larger, -1 smaller
//	private int isLargerOrEqual(int[] list, int[] max){
//		for(int x=0; x<list.length; x++){
//			if(list[x] == -1){
//				return 0;
//			}else{
//				if(list[x] > max[x]){
//					return 1;
//				}else if(list[x] < max[x]){
//					return -1;
//				}
//			}
//		}
//		return 0;
//	}


}
