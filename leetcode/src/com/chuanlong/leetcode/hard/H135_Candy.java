package com.chuanlong.leetcode.hard;

public class H135_Candy {

	/**
	 * https://leetcode.com/problems/candy/
	 */
	public static void main(String[] args) {
        H135_Candy obj = new H135_Candy();

        System.out.println("Test1, expect:5, output:" + obj.candy(new int[]{1,0,2}));
        System.out.println("Test2, expect:4, output:" + obj.candy(new int[]{1,2,2}));

	}


    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        int sum = 0;
        for(int i=0; i<ratings.length; i++) {
            sum += candy(ratings, candies, i);
        }
        return sum;
    }

    private int candy(int[] ratings, int[] candies, int index) {
        if(candies[index] > 0) return candies[index];
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(index>0) left = ratings[index-1];
        if(index<ratings.length-1) right = ratings[index+1];

        if(ratings[index]<=left) {
            if(ratings[index]<=right) {
                candies[index] = 1;
            } else {
                candies[index] = candy(ratings, candies, index+1)+1;
            }
        } else {
            candies[index] = candy(ratings, candies, index-1)+1;
            if(ratings[index] > right) {
                candies[index] = Math.max(candy(ratings, candies, index+1)+1, candies[index]);
            }
        }
        return candies[index];
    }


	
    public int candy2(int[] ratings) {
        if(ratings == null || ratings.length == 0){
        	return 0;
        }
    	
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for(int i=1; i<candies.length; i++){
        	candies[i] = (ratings[i] > ratings[i-1]) ? candies[i-1]+1 : 1;
        }
        
        for(int i=candies.length-2; i>=0; i--){
        	candies[i] = (ratings[i] > ratings[i+1] && candies[i] < candies[i+1]+1) ? candies[i+1]+1 : candies[i];
        }
        
        int sum = 0;
        for(int i=0; i<candies.length; i++){
        	sum += candies[i];
        }
        return sum;
    }
	

}
