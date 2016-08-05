package com.chuanlong.leetcode.easy;

public class E171_ExcelSheetColumnNumber {

	/**
	 * https://leetcode.com/problems/excel-sheet-column-number/
	 */
	public static void main(String[] args) {

		E171_ExcelSheetColumnNumber obj = new E171_ExcelSheetColumnNumber();
		
		System.out.println("A -> 1, result:" + obj.titleToNumber("A"));
		System.out.println("B -> 2, result:" + obj.titleToNumber("B"));
		System.out.println("Z -> 26, result:" + obj.titleToNumber("Z"));
		System.out.println("AA -> 27, result:" + obj.titleToNumber("AA"));
		System.out.println("AB -> 28, result:" + obj.titleToNumber("AB"));
	}
	
    public int titleToNumber(String s) {
    	if(s == null || s.length() == 0){
    		return 0;
    	}
    	
    	char[] tokens = s.toCharArray();
    	for(int i=0; i<tokens.length; i++){
    		if(!(tokens[i]>= 'A' && tokens[i] <= 'Z')){
    			return 0;
    		}
    	}
    	
    	int result = 0;
    	for(int i=0; i<tokens.length; i++){
    		result = result*26 + (tokens[i]-'A'+1);
    	}
        
        return result;
    }

}
