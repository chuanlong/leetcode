package com.chuanlong.leetcode.easy;

public class E345_ReverseVowelsOfAString {

	/**
	 * https://leetcode.com/problems/reverse-vowels-of-a-string/
	 */
	public static void main(String[] args) {

	}
	
	
	// vowels letter include: a e i o u
    public String reverseVowels(String s) {
    	if(s == null || s.length() == 0){
    		return s;
    	}
    	
        char[] chars = s.toCharArray();
    	for(int i=0, j=chars.length-1; i<j;){
    		if(isVowels(chars[i]) && isVowels(chars[j])){
    			char letter = chars[i];
    			chars[i] = chars[j];
    			chars[j] = letter;
    			i++;
    			j--;
    		}else if(!isVowels(chars[i])){
    			i++;
    		}else{
    			j--;
    		}
    	}
        
    	return new String(chars);
    }
    
    private boolean isVowels(char letter){
    	if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u'
    			|| letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U'){
    		return true;
    	}else{
    		return false;
    	}
    }

}
