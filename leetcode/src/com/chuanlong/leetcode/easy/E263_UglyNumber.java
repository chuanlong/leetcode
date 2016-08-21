package com.chuanlong.leetcode.easy;

public class E263_UglyNumber {

	/**
	 * https://leetcode.com/problems/ugly-number/
	 * */
	public static void main(String[] args) {
		E263_UglyNumber obj = new E263_UglyNumber();
		
		System.out.println("8 -> true, result:" + obj.isUgly(8));
		System.out.println("14 -> false, result:" + obj.isUgly(14));
	}
	
    public boolean isUgly(int num) {
        
    	int x = num;
    	while(x > 1){
    		if(isPrimeFactor(x, 2)){
    			x = x/2;
    		}else if(isPrimeFactor(x, 3)){
    			x = x/3;
    		}else if(isPrimeFactor(x, 5)){
    			x = x/5;
    		}else{
    			return false;
    		}
    		
    	}
    	
    	if(x == 1){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    private boolean isPrimeFactor(int x, int factor){
    	if(factor == 0){
    		return false;
    	}
    	int xx = x/factor;
    	if(xx * factor == x){
    		return true;
    	}else{
    		return false;
    	}
    }
    

}
