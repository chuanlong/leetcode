package com.chuanlong.leetcode.util;

import com.chuanlong.leetcode.bean.ListNode;

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
    
    public static String ListNode2String(ListNode node){
    	if(node == null){
    		return "";
    	}
    	String str = "[";
    	for(ListNode n = node; n != null; n=n.next){
    		str += n.val + ",";
    	}
    	str = str.substring(0, str.length()-1);
    	str += "]";
    	return str;    	
    }
	
}
