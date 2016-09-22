package com.chuanlong.leetcode.medium;

public class M309_BestTimeToBuyAndSellStockWithCooldown {

	/**
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
	 */
	public static void main(String[] args) {

	}
	
    public int maxProfit(int[] prices) {
        
    	/**
    	 * buys[i] = max(rest[i-1]-price, buys[i-1]) 
		 * sell[i] = max(buys[i-1]+price, sell[i-1])
		 * rest[i] = max(rest[i-1], buys[i-1], sell[i-1]);
    	 * */
    	
    	if(prices.length < 2){
    		return 0;
    	}else{
        	int n = prices.length;
        	int[] buys = new int[n];
        	int[] sell = new int[n];
        	int[] rest = new int[n];
        	
        	buys[0] = 0-prices[0];
        	sell[0] = Integer.MIN_VALUE;
        	rest[0] = 0;
        	buys[1] = Math.max(0-prices[0], 0-prices[1]);
        	sell[1] = prices[1] - prices[0];
        	rest[1] = 0;
        	
        	for(int i=2; i<n; i++){
        		buys[i] = Math.max(rest[i-1]-prices[i], buys[i-1]);
        		sell[i] = Math.max(buys[i-1]+prices[i], sell[i-1]);
        		rest[i] = Math.max(rest[i-1], Math.max(buys[i-1], sell[i-1]));
        	}
        	
        	return Math.max(rest[n-1], Math.max(buys[n-1], sell[n-1]));
    	}

    }

}
