package com.chuanlong.leetcode.util;

public class Util {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	
    public static String Array2String(int[] a){
    	if(a == null){
    		return "";
    	}
    	String str = "[";
    	for(int i=0; i<a.length; i++){
    		str += a[i] + ",";
    	}
    	if(a.length > 0){
    		str = str.substring(0, str.length()-1);
    	}
    	
    	str += "]";
    	return str;
    }
	
}
