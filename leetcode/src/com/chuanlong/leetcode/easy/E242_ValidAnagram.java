package com.chuanlong.leetcode.easy;

public class E242_ValidAnagram {

	/**
	 * https://leetcode.com/problems/valid-anagram/
	 */
	public static void main(String[] args) {

		E242_ValidAnagram obj = new E242_ValidAnagram();
		
		System.out.println("[anagram, nagaram], expect:true, result:" + obj.isAnagram("anagram", "nagaram"));
		System.out.println("[rat, car], expect:false, result:" + obj.isAnagram("rat", "car"));
	}
	
	public boolean isAnagram(String s, String t) {
		if ((s == null || "".equals(s)) && (t == null || "".equals(t))) {
			return true;
		}

		if ((s == null || "".equals(s)) || (t == null || "".equals(t))) {
			return false;
		}

		if (s.length() != t.length()) {
			return false;
		}
		
		int[] x = new int[26];
		int[] y = new int[26];
		for(int i=0; i<26; i++){
			x[i] = y[i] = 0;
		}
		
		for(int i=0; i<s.length(); i++){
			x[s.charAt(i)-'a']++;
			y[t.charAt(i)-'a']++;
		}
		
		for(int i=0; i<x.length; i++){
			if(x[i] != y[i]){
				return false;
			}
		}
		return true;
	}
	
}
