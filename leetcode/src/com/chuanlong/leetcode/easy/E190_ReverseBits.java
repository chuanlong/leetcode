package com.chuanlong.leetcode.easy;

public class E190_ReverseBits {

	/**
	 * https://leetcode.com/problems/reverse-bits/
	 */
	public static void main(String[] args) {

		E190_ReverseBits obj = new E190_ReverseBits();		
		
		System.out.println("43261596, expected:964176192, result:" + obj.reverseBits(43261596));
		
	}
	
	
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int a = n;
    	int reverse = 0;
    	    	
    	for(int i=0; i<32; i++){
    		reverse = (((reverse<<1)&0xFFFFFFFE) | (a&0x00000001));
    		a >>= 1;
    	}
    	
    	return reverse;
    }

}
