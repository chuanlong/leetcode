package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.util.Util;

public class M319_BulbSwitcher {

	/**
	 * https://leetcode.com/problems/bulb-switcher/
	 */
	public static void main(String[] args) {

		M319_BulbSwitcher obj = new M319_BulbSwitcher();
		
		System.out.println("0  -> 0, result:" + obj.bulbSwitch(0));
		System.out.println("1  -> 1, result:" + obj.bulbSwitch(1));
		System.out.println("3  -> 1, result:" + obj.bulbSwitch(3));
		System.out.println("5  -> 2, result:" + obj.bulbSwitch(5));
		System.out.println("10 -> 3, result:" + obj.bulbSwitch(10));
		
		System.out.println("0  -> result:" + Util.Array2String(obj.bulbSwitchArray(0)));
		System.out.println("1  -> result:" + Util.Array2String(obj.bulbSwitchArray(1)));
		System.out.println("3  -> result:" + Util.Array2String(obj.bulbSwitchArray(3)));
		System.out.println("5  -> result:" + Util.Array2String(obj.bulbSwitchArray(5)));
		System.out.println("10 -> result:" + Util.Array2String(obj.bulbSwitchArray(10)));
		System.out.println("15 -> result:" + Util.Array2String(obj.bulbSwitchArray(15)));
		System.out.println("18 -> result:" + Util.Array2String(obj.bulbSwitchArray(18)));
		System.out.println("20 -> result:" + Util.Array2String(obj.bulbSwitchArray(20)));
		System.out.println("23 -> result:" + Util.Array2String(obj.bulbSwitchArray(23)));
		System.out.println("73 -> result:" + Util.Array2String(obj.bulbSwitchArray(73)));
		System.out.println("99 -> result:" + Util.Array2String(obj.bulbSwitchArray(99)));
	}
	
    public int bulbSwitch(int n) {
    	if(n <= 0){
    		return 0;
    	}
    	
    	int x = 1;
    	int total = 1;
    	for(int i=1; x<=n;i++){
    		int newX = x + i*2;
    		if(n>=x && n<=newX){
    			return total;
    		}
    		x = newX+1;
    		total++;
    	}
        
    	return 0;
    }
    
    
    public int[] bulbSwitchArray(int n){
    	if(n <= 0){
    		return new int[]{};
    	}
    	
    	int[] a = new int[n];
    	for(int i=0; i<a.length; i++){
    		a[i] = 0;
    	}
    	
    	for(int i=1; i<n+1; i++){
    		for(int j=1; j*i-1<n ;j++){
    			a[j*i-1] = 1 - a[j*i-1];
    		}    		
    	}  	
    	
    	return a;
    }

}
