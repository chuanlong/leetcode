package com.chuanlong.leetcode.medium;

public class M122_BestTimeToBuyAndSellStock2 {

	/**
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
	 */
	public static void main(String[] args) {

	}
	
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){
        	return 0;
        }
        
        int profit = 0;
    	int buyIndex = -1;
    	for(int i=0; i<prices.length; i++){
    		if(buyIndex == -1){
    			// waiting stock
    			if(i+1 < prices.length && prices[i] < prices[i+1]){
    				// buy
    				buyIndex = i;
    			}    			    			
    		}else{
    			// holding stock
    			if(i == prices.length-1 || (i+1<prices.length && prices[i] > prices[i+1]) ){
    				// sell 
    				profit += prices[i] - prices[buyIndex];
    				buyIndex = -1;
    			}
    		}
    	}
        
        return profit;
    }

}
