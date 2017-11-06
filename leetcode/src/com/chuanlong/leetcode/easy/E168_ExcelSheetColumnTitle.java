package com.chuanlong.leetcode.easy;

public class E168_ExcelSheetColumnTitle {

	public static void main(String[] args) {

		E168_ExcelSheetColumnTitle obj = new E168_ExcelSheetColumnTitle();
		
		System.out.println("1 -> A:" + obj.convertToTitle(1));
		System.out.println("26 -> Z:" + obj.convertToTitle(26));
		System.out.println("27 -> AA:" + obj.convertToTitle(27));
		System.out.println("52 -> AZ:" + obj.convertToTitle(52));
		System.out.println("53 -> BA:" + obj.convertToTitle(53));
	}
	
	/**
	 * 1 -> A
	 * 26 -> Z
	 * 27 -> AA
	 * 52 -> AZ
	 * */
    public String convertToTitle(int n) {
        int m = n;
        String str = "";
        while(m>0){
        	str = int2char(m%26) + str;
        	m = (m-1)/26;
        }
        return str;
    }
    
    private String int2char(int ch){
    	if(ch == 0){
    		return "Z";
    	}else{
    		return ((char)('A'+ch-1)) + "";
    	}
    }

}
