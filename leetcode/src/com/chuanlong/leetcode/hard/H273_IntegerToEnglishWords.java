package com.chuanlong.leetcode.hard;

public class H273_IntegerToEnglishWords {

	/**
	 * https://leetcode.com/problems/integer-to-english-words/
	 */
	public static void main(String[] args) {

		H273_IntegerToEnglishWords obj = new H273_IntegerToEnglishWords();
		
//		System.out.println("0 -> 'Zero', result:" + obj.numberToWords(0));
//		System.out.println("123 -> 'One Hundred Twenty Three', result:" + obj.numberToWords(123));
//		System.out.println("12345 -> 'Twelve Thousand Three Hundred Forty Five', result:" + obj.numberToWords(12345));
//		System.out.println("1234567 -> 'One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven', result:" + obj.numberToWords(1234567));
//		System.out.println("1234567891 -> 'One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One', result:\n" + obj.numberToWords(1234567891));
		System.out.println("100 -> 'One Hundred', result:" + obj.numberToWords(100));
		System.out.println("10000 -> 'Ten Thousand', result:" + obj.numberToWords(10000));
	}
	
	
	public final static String SPACE = " ";
	
	public final static String NUM_0 = "Zero";
	public final static String NUM_1 = "One";
	public final static String NUM_2 = "Two";
	public final static String NUM_3 = "Three";
	public final static String NUM_4 = "Four";
	public final static String NUM_5 = "Five";
	public final static String NUM_6 = "Six";
	public final static String NUM_7 = "Seven";
	public final static String NUM_8 = "Eight";
	public final static String NUM_9 = "Nine";
	public final static String NUM_10 = "Ten";
	
	public final static String NUM_11 = "Eleven";
	public final static String NUM_12 = "Twelve";
	public final static String NUM_13 = "Thirteen";
	public final static String NUM_14 = "Fourteen";
	public final static String NUM_15 = "Fifteen";
	public final static String NUM_16 = "Sixteen";
	public final static String NUM_17 = "Seventeen";
	public final static String NUM_18 = "Eighteen";
	public final static String NUM_19 = "Nineteen";
	
	public final static String NUM_20 = "Twenty";
	public final static String NUM_30 = "Thirty";
	public final static String NUM_40 = "Forty";
	public final static String NUM_50 = "Fifty";
	public final static String NUM_60 = "Sixty";
	public final static String NUM_70 = "Seventy";
	public final static String NUM_80 = "Eighty";
	public final static String NUM_90 = "Ninety";


	public final static String NUM_100 = "Hundred";
	public final static String NUM_1000 = "Thousand";
	public final static String NUM_1000_000 = "Million";
	public final static String NUM_1000_000_000 = "Billion";
	

    public String numberToWords(int num) {
        switch(num){
        	case 0: return NUM_0;
        	case 1: return NUM_1;
        	case 2: return NUM_2;
        	case 3: return NUM_3;
        	case 4: return NUM_4;
        	case 5: return NUM_5;
        	case 6: return NUM_6;
        	case 7: return NUM_7;
        	case 8: return NUM_8;
        	case 9: return NUM_9;
        	case 10: return NUM_10;
        	case 11: return NUM_11;
        	case 12: return NUM_12;
        	case 13: return NUM_13;
        	case 14: return NUM_14;
        	case 15: return NUM_15;
        	case 16: return NUM_16;
        	case 17: return NUM_17;
        	case 18: return NUM_18;
        	case 19: return NUM_19;
        	case 20: return NUM_20;
        	case 30: return NUM_30;
        	case 40: return NUM_40;
        	case 50: return NUM_50;
        	case 60: return NUM_60;
        	case 70: return NUM_70;
        	case 80: return NUM_80;
        	case 90: return NUM_90;
        	default: break;
        }
        
        if(num < 100){
        	int y = num % 10;
        	int x = num - y;
        	return numberToWords(x) + (y == 0 ? "" : SPACE + numberToWords(y));
        }else if(num < 1000){
        	int x = num / 100;
        	int y = num - x*100;
        	return numberToWords(x) + SPACE + NUM_100 + (y == 0 ? "" : SPACE + numberToWords(y));
        }else if(num < 1000 * 1000){
        	int x = num / 1000;
        	int y = num - x*1000;
        	return numberToWords(x) + SPACE + NUM_1000 + (y == 0 ? "" : SPACE + numberToWords(y));
        }else if(num < 1000 * 1000 * 1000){
        	int x = num / 1000000;
        	int y = num - x*1000000;
        	return numberToWords(x) + SPACE + NUM_1000_000 + (y == 0 ? "" : SPACE + numberToWords(y));
        }else{
        	// num is no less than 2^31-1(2147483647)
        	int x = num / 1000000000;
        	int y = num - x*1000000000;
        	return numberToWords(x) + SPACE + NUM_1000_000_000 + (y == 0 ? "" : SPACE + numberToWords(y));
        }
        
    }
	

}
