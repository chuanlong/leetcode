package com.chuanlong.leetcode.medium;

public class M096_UniqueBinarySearchTrees {

	public static void main(String[] args) {
		

	}
	
    public int numTrees(int n) {
    		int m = (n>=2) ? n : 2;
    		int[] a = new int[m+1];
    		a[0] = 1;
    		a[1] = 1;
    		a[2] = 2;
    		for(int i=3; i<=n; i++) {
    			int sum = 0;
    			for(int j=0; j<=i-1; j++) {
    				sum += a[j] * a[i-1-j];
    			}
    			a[i] = sum;
    		}
    		return a[n];
    }

}
