package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.util.Util;

public class CountingBits {

	/**
	 * https://leetcode.com/problems/counting-bits/
	 */
	public static void main(String[] args) {
		
		CountingBits obj = new CountingBits();
		
		System.out.println("num=5, result:" + Util.Array2String(obj.countBits(5)));
	}
	
	
    public int[] countBits(int num) {
        int[] a = new int[num+1];
        
        a[0] = 0;

        if(num >= 1){
        	a[1] = 1;
        }
        
        for(int i=2; i<num+1; i++){
        	a[i] = a[i/2] + (i%2);
        }
        
        return a;
    }
    
}
