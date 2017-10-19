package com.chuanlong.leetcode.easy;

public class E067_AddBinary {

	public static void main(String[] args) {

		E067_AddBinary obj = new E067_AddBinary();
		
		String str1 = obj.addBinary("0", "0");
		String str2 = obj.addBinary("0", "1");
		String str3 = obj.addBinary("111", "111");
		String str4 = obj.addBinary("11", "1");
		
		System.out.println("'0', '0' -->" + str1);
		System.out.println("'0', '1' -->" + str2);
		System.out.println("'111', '111' -->" + str3);
		System.out.println("'11', '1' -->" + str4);
		
	}
	
	
    public String addBinary(String a, String b) {
        int length = (a.length() > b.length() ? a.length() : b.length()) + 1;
        
        int[] str = str2array("", length);
        int[] aStr = str2array(a, length);
        int[] bStr = str2array(b, length);
        
        for(int i=0; i<length-1; i++) {
        	int bit = str[i] + aStr[i] + bStr[i];
        	if (bit > 1) {
        		str[i+1] = 1;
        		str[i] = bit % 2;
        	} else {
        		str[i] = bit;
        	}
        }

        String c = "";
        for(int i=0; i<length-1; i++) {
        	c = str[i] + c;
        }
    	if(str[length-1] == 1) {
    		c = "1" + c;
    	}
    	
    	return c;
    }
    
    private int[] str2array(String a, int length) {
    	int[] array = new int[length];
    	for(int i=0; i<a.length(); i++) {
    		array[i] = (a.charAt(a.length()-1-i) - '0');
    	}
    	
    	for(int i=a.length(); i<length; i++) {
    		array[i] = 0;
    	}
    	
    	return array;
    }

}
