package com.chuanlong.leetcode.easy;

public class E058_LengthOfLastWord {

	/**
	 * https://oj.leetcode.com/problems/length-of-last-word/
	 */
	public static void main(String[] args) {

//		E058_LengthOfLastWord obj = new E058_LengthOfLastWord();
//				
//		int len1 = obj.lengthOfLastWord("Hello World"); //5
//		int len2 = obj.lengthOfLastWord(null); //0
//		int len3 = obj.lengthOfLastWord(""); //0
//		int len4 = obj.lengthOfLastWord(" "); //0
//		int len5 = obj.lengthOfLastWord("sss sdddQ "); //5
//		int len6 = obj.lengthOfLastWord("sss sdddQ ADFWEf"); //6
		
				
	}
	
	
	public int lengthOfLastWord(String s) {

		if (s == null)
			return 0;

		boolean isMark = false;
		int len = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			boolean isChar = (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
			
			if(isChar){
				if(isMark){
					len++;
				}else{
					isMark = true;
					len = 1;
				}				
			}else{
				if(isMark){
					break;
				}
			}					
		}

		return len;
	}
	

}
