package com.chuanlong.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class E202_HappyNumber {

	/**
	 * https://leetcode.com/problems/happy-number/
	 */
	public static void main(String[] args) {

		E202_HappyNumber obj = new E202_HappyNumber();
		
		obj.isHappy(19);
		
	}
	
    public boolean isHappy(int n) {
    	if(n < 1){
    		return false;
    	}else if(n == 1){
    		return true;
    	}
    	
    	Set<Integer> sets = new HashSet<Integer>();
    	while(n!= 0 && n != 1 && !sets.contains(n)){
    		sets.add(n);
    		n = cal(n);
    	}
    	
    	if(n == 1){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    
    private int cal(int n){
    	if(n < 1){
    		return 0;
    	}
    	
    	int calN = 0;
    	char[] chars = (n+"").toCharArray();
    	for(int i=0; i<chars.length; i++){
    		int digit = Integer.parseInt(chars[i]+"");
    		calN += digit * digit;
    	}
    	
    	char[] chars2 = (calN+"").toCharArray();
    	Arrays.sort(chars);
    	Integer calN2 = 0;
    	for(int i=0; i<chars2.length; i++){
    		calN2 = calN2*10 + Integer.parseInt(chars2[i]+"");
    	}
    	
    	return calN2;
    }

}
