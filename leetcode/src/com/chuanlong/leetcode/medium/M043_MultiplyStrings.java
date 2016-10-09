package com.chuanlong.leetcode.medium;

public class M043_MultiplyStrings {

	/**
	 * https://leetcode.com/problems/multiply-strings/
	 */
	public static void main(String[] args) {

	}
	
	
    public String multiply(String num1, String num2) {
    	int m = num1.length();
    	int n = num2.length();
    	
    	String str1 = reverse(num1);
    	String str2 = reverse(num2);
    	int[] a = new int[m+n];

    	for(int i=0; i<m; i++){
    		for(int j=0; j<n; j++){
    			int pos = i+j;
    			int mul = (str1.charAt(i)-'0') * (str2.charAt(j)-'0');
    			a[pos] += mul;
    		}
    	}
    	
        for(int i=0; i<a.length-1; i++){
        	int sum = a[i];
        	a[i] = sum % 10;
        	a[i+1] += sum/10;
        }

        StringBuilder sb = new StringBuilder();
        boolean isStarted = false;
        for(int i=a.length-1; i>=0; i--){
        	if(isStarted || a[i] != 0){
        		sb.append(a[i]);
        		isStarted = true;
        	}
        }
        if(sb.length() == 0) sb.append(0);
    	return sb.toString();
    }
    
    private String reverse(String a){
    	StringBuilder sb = new StringBuilder();
    	for(int i=a.length()-1; i>=0; i--){
    		sb.append(a.charAt(i));
    	}
    	return sb.toString();
    }

}
