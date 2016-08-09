package com.chuanlong.leetcode.medium;

public class M012_IntegerToRoman {

	/**
	 * https://leetcode.com/problems/integer-to-roman/
	 */
	public static void main(String[] args) {

		M012_IntegerToRoman obj = new M012_IntegerToRoman();
		
		System.out.println("1 -> Ｉ, result:" + obj.intToRoman(1));
		System.out.println("99 -> ＸＣＩＸ, result:" + obj.intToRoman(99));
		
	}
	
	
    public final String Roman_1 = "I";
	public final String Roman_5 = "V";
	public final String Roman_10 = "X";
	public final String Roman_50 = "L";
	public final String Roman_100 = "C";
	public final String Roman_500 = "D";
	public final String Roman_1000 = "M";
	
	/**
	 * 1 -> 3999
	 * */
    public String intToRoman(int num) {
        String roman = "";
    	int x = num;
        
    	int x_1000 = x / 1000;
    	x = x - x_1000 * 1000;
    	for(int i=0; i<x_1000; i++){
    		roman += Roman_1000;
    	}
    	
    	if(x >= 900){
    		roman += Roman_100 + Roman_1000;
    		x = x - 900;
    	}else if(x >= 500){
    		int x_100 = (x-500) / 100;
    		x = x - 500 - x_100 * 100;
    		roman += Roman_500;
    		for(int i=0; i<x_100; i++){
    			roman += Roman_100;
    		}
    	}else if(x >= 400){
    		roman += Roman_100 + Roman_500;
    		x = x - 400;
    	}else{
    		int x_100 = x /100;
    		x = x - x_100 * 100;
    		for(int i=0; i<x_100; i++){
    			roman += Roman_100;
    		}
    	}
    	
    	if(x >= 90){
    		roman += Roman_10 + Roman_100;
    		x = x - 90;
    	}else if(x >= 50){
    		int x_10 = (x-50) / 10;
    		x = x - 50 - x_10 * 10;
    		roman += Roman_50;
    		for(int i=0; i<x_10; i++){
    			roman += Roman_10;
    		}
    	}else if(x >= 40){
    		roman += Roman_10 + Roman_50;
    		x = x - 40;
    	}else{
    		int x_10 = x / 10;
    		x = x - x_10 * 10;
    		for(int i=0; i<x_10; i++){
    			roman += Roman_10;
    		}
    	}
    	
    	if(x >= 9){
    		roman += Roman_1 + Roman_10;
    		x = x - 9;
    	}else if(x >= 5){
    		int x_1 = (x-5);
    		x = x - 5 - x_1;
    		roman += Roman_5;
    		for(int i=0; i<x_1; i++){
    			roman += Roman_1;
    		}
    	}else if(x >= 4){
    		roman += Roman_1 + Roman_5;
    		x = x - 4;
    	}else{
    		int x_1 = x;
    		x = x - x_1;
    		for(int i=0; i<x_1; i++){
    			roman += Roman_1;
    		}
    	}
    	
    	assert(x == 0);
    	
    	return roman;
    }

}
