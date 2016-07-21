package com.chuanlong.leetcode;

public class ReverseInteger {

	/**
	 * https://oj.leetcode.com/problems/reverse-integer/
	 */
	public static void main(String[] args) {
		
		ReverseInteger instance = new ReverseInteger();
		
		int i1 = instance.reverse(123); //321
		int i2 = instance.reverse(-123); //-321
		int i3 = instance.reverse(0); //0
		int i4 = instance.reverse(-102030); //-30201

	}

	
	public int reverse(int x) {
		int abs = x > 0 ? x : (0 - x);

		int y = 0;
		for (; abs > 0; abs = abs / 10)
			y = y * 10 + abs % 10;

		if (x < 0)
			y = 0 - y;

		return y;
	}
	
	
	
}
