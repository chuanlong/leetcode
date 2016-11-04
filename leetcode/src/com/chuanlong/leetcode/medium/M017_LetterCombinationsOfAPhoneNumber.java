package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M017_LetterCombinationsOfAPhoneNumber {

	/**
	 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
	 */
	public static void main(String[] args) {

	}
	
    public List<String> letterCombinations(String digits) {
    	List<String> combinations = new ArrayList<String>();
    	
        if(digits == null || digits.length() == 0){
        	return combinations;
        }
    	
    	int digit = digits.charAt(0) - '0';
    	if(digit >= 2 && digit <= 9){
    		char[] chars = getCharOfDigit(digit);
    		if(digits.length() == 1){
    			for(int i=0; i<chars.length; i++){
    				combinations.add(chars[i]+"");
    			}
    		}else{
    			List<String> list = letterCombinations(digits.substring(1));
    			for(int i=0; i<chars.length; i++){
    				for(int j=0; j<list.size(); j++){
    					combinations.add(chars[i]+list.get(j));
    				}
    			}
    		}	
    	}
    	
    	
    	return combinations;
    }
    
    
    
    private char[] getCharOfDigit(int digit){
    	if(digit >=2 && digit <= 6){
    		return new char[]{(char)('a'+(digit-2)*3), (char)('a'+(digit-2)*3+1), (char)('a'+(digit-2)*3+2)};
    	}else if(digit == 7){
    		return new char[]{'p', 'q', 'r', 's'};
    	}else if(digit == 8){
    		return new char[]{'t', 'u', 'v'};
    	}else if(digit == 9){
    		return new char[]{'w', 'x', 'y', 'z'};
    	}
    	return new char[0];
    }

}
