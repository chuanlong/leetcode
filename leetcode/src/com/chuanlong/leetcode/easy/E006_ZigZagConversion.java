package com.chuanlong.leetcode.easy;

public class E006_ZigZagConversion {

	/**
	 * https://leetcode.com/problems/zigzag-conversion/
	 */
	public static void main(String[] args) {

	}

	
    public String convert(String s, int numRows) {
        
    	StringBuffer[] strs = new StringBuffer[numRows];
    	for(int i=0; i<strs.length; i++){
    		strs[i] = new StringBuffer();
    	}
    	
    	for(int i=0; i<s.length(); i++){
    		int cycle = numRows + (numRows-2);
    		if(cycle <= 0) cycle = 1;

    		int index = 0;
    		if(i%cycle < numRows){
    			index = i%cycle;
    		}else{
    			index = numRows - 2 - (i%cycle-numRows) ;
    		}
    		
    		strs[index].append(s.charAt(i));
    	}
    	
    	
    	StringBuffer sb = new StringBuffer();
    	for(int i=0; i<strs.length; i++){
    		sb.append(strs[i]);
    	}
    	return sb.toString();
    }
	
}
