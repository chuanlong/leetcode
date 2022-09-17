package com.chuanlong.leetcode.medium;

public class M005_LongestPalindromicSubstring {

	/**
	 * https://leetcode.com/problems/longest-palindromic-substring/
	 */
	public static void main(String[] args) {
		
		M005_LongestPalindromicSubstring obj = new M005_LongestPalindromicSubstring();
		
//		obj.longestPalindrome("abb");
//
//		System.out.println("abb -> bb, result:" + obj.longestPalindrome("abb"));
//		System.out.println("abbc -> bb, result:" + obj.longestPalindrome("abbc"));
//		System.out.println("a -> a, result:" + obj.longestPalindrome("a"));
		
		System.out.println("babad -> bab, result:" + obj.longestPalindrome("babad"));
		
	}

	public String longestPalindrome(String s) {
		int n = s.length();
		char[] chs = s.toCharArray();
		int[] a = new int[n];
		a[0] = 1;
		String sub = chs[0] + "";
		for(int i=1; i<n; i++) {
			if(i-a[i-1]-1>=0 && chs[i] == chs[i-a[i-1]-1]) {
				a[i] = a[i-1] + 2;
			} else {
				for(int j=i-a[i-1]; j<=i; j++) {
					if(isPalindromic(chs, j, i)) {
						a[i] = i+1-j;
						break;
					}
				}
			}
			if(a[i] > sub.length()) {
				sub = s.substring(i-a[i]+1, i+1);
			}
		}
		return sub;
	}



	private boolean isPalindromic(char[] chs, int i, int j) {
		while(i<j) {
			if(chs[i] != chs[j]) return false;
			i++;
			j--;
		}
		return true;
	}

	public String longestPalindrome3(String s) {
		int n = s.length();
		String[] a = new String[n];
		String[] b = new String[n];

		char[] chs = s.toCharArray();
		a[0] = "";
		b[0] = chs[0]+"";
		for(int i=1; i<n; i++) {
			// a[i]
			a[i] = (a[i-1].length() >= b[i-1].length()) ? a[i-1] : b[i-1];

			// b[i]
			if(i-b[i-1].length()-1>=0 && chs[i] == chs[i-b[i-1].length()-1]) {
				b[i] = chs[i] + b[i-1] + chs[i];
			} else {
				for(int j=i-b[i-1].length(); j<=i; j++) {
					if(isPalindromic3(chs, j, i)) {
						b[i] = s.substring(j, i+1);
						break;
					}
				}
			}
		}


		return (a[n-1].length() > b[n-1].length()) ? a[n-1] : b[n-1];
	}

	private boolean isPalindromic3(char[] chs, int i, int j) {
		while(i<j) {
			if(chs[i] != chs[j]) return false;
			i++;
			j--;
		}
		return true;
	}

	
    public String longestPalindrome2(String s) {
    	if(s == null || s.length() <= 1){
    		return s;
    	}
    	
    	String longest = "";
    	String longestWithEnd = "";
    	
    	char[] chars = s.toCharArray();
    	int n = chars.length;
    	
    	longest += chars[0];
    	longestWithEnd += chars[0];
    	
    	for(int i=1; i<n; i++){
    		int start = i - longestWithEnd.length() - 1;
    		start = start >= 0 ? start : 0;
    		
    		while(!isPalindrome2(chars, start, i)){
    			start++;
    		}
    		
    		longestWithEnd = new String(chars, start, i-start+1);
    		longest = longest.length() > longestWithEnd.length() ? longest : longestWithEnd;
    	}
    	
    	return longest;
    }
    
    private boolean isPalindrome2(char[] chars, int start, int end){
    	if(start > end){
    		return false;
    	}
    	
    	for(int i = start, j = end; i<=j; i++, j--){
    		if(chars[i] != chars[j]){
    			return false;
    		}
    	}
    	return true;
    }

    
    public String longestPalindrome1(String s) {
    	if(s == null || s.length() == 0){
    		return s;
    	}
        char[] chs = s.toCharArray();
    	String longest = chs[0]+"";
    	int index = 0;
    	for(int i=1; i<chs.length; i++){
    		if(index-1>=0 && chs[index-1] == chs[i]){
    			index = index-1;
    		}else{
    			int j=index;
    			for(j=index; j<=i; j++){
    				if(isPalindrome1(chs, j, i)){
    					break;
    				}
    			}
    			index = j;
    		}
    		longest = longest.length()>i-index+1 ? longest : s.substring(index, i+1);
    	}
    	return longest;
    }
    
    private boolean isPalindrome1(char[] chs, int i, int j){
    	if(i>=j){
    		return true;
    	}else if(chs[i] != chs[j]){
    		return false;
    	}else{
    		return isPalindrome1(chs, i+1, j-1);
    	}
    }
    
}
