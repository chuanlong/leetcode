package com.chuanlong.leetcode.medium;

public class M357_CountNumbersWithUniqueDigits {

	/**
	 * https://leetcode.com/problems/count-numbers-with-unique-digits/
	 */
	public static void main(String[] args) {

	}
	
    public int countNumbersWithUniqueDigits(int n) {
    	if(n == 0){
    		return 1;
    	}else if(n == 1){
    		return 10;
    	}
    	
    	int count = 10;
    	int max = (n>10) ? 10 : n;
    	for(int i=2; i<=max; i++){
    		count += 9 * calAMN(9, i-1);    		
    	}
    	return count;
    }
    
    private int calAMN(int m, int n){
    	int aMN = 1;
    	for(int i=m; i>m-n; i--){
    		aMN = aMN * i;
    	}
    	return aMN;
    }

}
