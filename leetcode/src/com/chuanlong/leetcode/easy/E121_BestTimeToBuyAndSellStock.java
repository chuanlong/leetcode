package com.chuanlong.leetcode.easy;

public class E121_BestTimeToBuyAndSellStock {

	/**
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	 */
	public static void main(String[] args) {

	}
	
	
	
    public int maxProfit(int[] prices) {
    	if(prices == null || prices.length <= 1){
    		return 0;
    	}

    	int minPrice = Integer.MAX_VALUE;
    	int maxProfit = 0;
    	for(int i=0; i<prices.length; i++){
//    		minPrice = prices[i] < minPrice ? prices[i] : minPrice;
//    		maxProfit = (prices[i]-minPrice) > maxProfit ? (prices[i]-minPrice) : maxProfit;
    		minPrice = Math.min(prices[i], minPrice);
    		maxProfit = Math.max(prices[i]-minPrice, maxProfit);
    	}
    	return maxProfit;
    }
 
	

}
