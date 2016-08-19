package com.chuanlong.leetcode.easy;

public class E007_ReverseInteger {

	/**
	 * https://oj.leetcode.com/problems/reverse-integer/
	 */
	public static void main(String[] args) {
		
//		E007_ReverseInteger obj = new E007_ReverseInteger();
//		
//		int i1 = obj.reverse(123); //321
//		int i2 = obj.reverse(-123); //-321
//		int i3 = obj.reverse(0); //0
//		int i4 = obj.reverse(-102030); //-30201

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
