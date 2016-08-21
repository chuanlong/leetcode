package com.chuanlong.leetcode.easy;

public class E013_RomanToInteger {

	
	/**
	 * https://leetcode.com/problems/roman-to-integer/
	 * */
	public static void main(String[] args) {

		E013_RomanToInteger obj = new E013_RomanToInteger();
		
		System.out.println("XCIX -> 99, result:" + obj.romanToInt("XCIX"));
		
	}
	
	
    public final char Roman_1 = 'I';
	public final char Roman_5 = 'V';
	public final char Roman_10 = 'X';
	public final char Roman_50 = 'L';
	public final char Roman_100 = 'C';
	public final char Roman_500 = 'D';
	public final char Roman_1000 = 'M';
	
	// 1->3999
    public int romanToInt(String s) {
        if(s == null || s.length() == 0){
        	return 0;
        }
        
        int x = 0;
        char[] tokens = s.toCharArray();
        for(int i=0; i<tokens.length; i++){
        	switch (tokens[i]){
    			case Roman_1000: x += 1000;break;
    			case Roman_500: x += 500; break;
    			case Roman_100:
    				if(i+1<tokens.length && (tokens[i+1] == Roman_500 || tokens[i+1] == Roman_1000)){
    					x -= 100;
    				}else{
    					x += 100;
    				}
    				break;
    			case Roman_50: x += 50; break;
    			case Roman_10:
    				if(i+1<tokens.length && (tokens[i+1] == Roman_50 || tokens[i+1] == Roman_100)){
    					x -= 10;
    				}else{
    					x += 10;
    				}
    				break;
    			case Roman_5: x += 5; break;
    			case Roman_1:
    				if(i+1<tokens.length && (tokens[i+1] == Roman_5 || tokens[i+1] == Roman_10)){
    					x -= 1;
    				}else{
    					x += 1;
    				}
    				break;
    			default: return 0; //error
        	}
        }
        
    	return x;
    }
	

}
