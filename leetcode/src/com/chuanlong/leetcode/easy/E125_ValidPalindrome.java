package com.chuanlong.leetcode.easy;

public class E125_ValidPalindrome {

	/**
	 * https://oj.leetcode.com/problems/valid-palindrome/
	 */
	public static void main(String[] args) {
		
//		ValidPalindrome obj = new ValidPalindrome();
//		
//		boolean b1 = obj.isPalindrome("A man, a plan, a canal: Panama"); //true
//		boolean b2 = obj.isPalindrome("race a car"); //false
//		boolean b3 = obj.isPalindrome(" "); //false;
//		boolean b4 = obj.isPalindrome("1a2"); //false;
	}
	
	
	
	public boolean isPalindrome(String s) {
		if (s == null)
			return false;

		int i = 0;
		int j = s.length() - 1;

		while (i <= j) {
			while (i <= j && !isValid(s.charAt(i)))
				i++;
			while (i <= j && !isValid(s.charAt(j)))
				j--;

			if (i <= j) {
				if (Character.toLowerCase(s.charAt(i)) == Character
						.toLowerCase(s.charAt(j))) {
					i++;
					j--;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isValid(char ch) {
		return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'));
	}
	
	

}
