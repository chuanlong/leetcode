package com.chuanlong.leetcode.easy;

public class E278_FirstBadVersion {

	/**
	 * https://leetcode.com/problems/first-bad-version/
	 * */
	public static void main(String[] args) {

		E278_FirstBadVersion obj = new E278_FirstBadVersion();
		
		System.out.println("2126753390 -> 1702766719, result:" + obj.firstBadVersion(2126753390));
		
	}
	
	
    public int firstBadVersion(int n) {
        if(!isBadVersion(n)){
        	return n+1;
        }else if(isBadVersion(0)){
        	return 0;
        }
    	
    	long x = 0, y = n;
    	while(x+1 < y){
    		long mid = (x+y)/2;
    		if(isBadVersion((int)mid)){
    			y = mid;
    		}else{
    			x = mid;
    		}
    	}
    	
    	return (int)x+1;
    }
	
	
	
	/** 
	 * The isBadVersion API is defined in the parent class VersionControl.
	 */
    boolean isBadVersion(int version){
    	if(version >= 1702766719){
    		return true;
    	}else{
    		return false;
    	}
    }

}
