package com.chuanlong.leetcode.hard;

public class H135_Candy {

	/**
	 * https://leetcode.com/problems/candy/
	 */
	public static void main(String[] args) {

	}
	
	
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0){
        	return 0;
        }
    	
        int[] candys = new int[ratings.length];
        candys[0] = 1;
        for(int i=1; i<candys.length; i++){
        	candys[i] = (ratings[i] > ratings[i-1]) ? candys[i-1]+1 : 1;
        }
        
        for(int i=candys.length-2; i>=0; i--){
        	candys[i] = (ratings[i] > ratings[i+1] && candys[i] < candys[i+1]+1) ? candys[i+1]+1 : candys[i]; 
        }
        
        int sum = 0;
        for(int i=0; i<candys.length; i++){
        	sum += candys[i];
        }
        return sum;
    }
	

}
