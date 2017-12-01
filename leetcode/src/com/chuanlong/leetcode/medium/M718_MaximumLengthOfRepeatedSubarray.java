package com.chuanlong.leetcode.medium;

public class M718_MaximumLengthOfRepeatedSubarray {

	public static void main(String[] args) {

	}
	
    public int findLength(int[] A, int[] B) {
    	if(A == null || A.length == 0 || B == null || B.length == 0){
    		return 0;
    	}
    	
    	int max = 0;
    	int[][] dp = new int[A.length+1][B.length+1];
    	for(int i=0; i<A.length+1; i++){
    		for(int j=0; j<B.length+1; j++){
    			if(i == 0 || j == 0){
    				dp[i][j] = 0;
    			}else{
    				if(A[i-1] == B[j-1]){
    					dp[i][j] = dp[i-1][j-1] + 1;
    					max = Math.max(max, dp[i][j]);
    				}else{
    					dp[i][j] = 0;
    				}
    			}
    		}
    	}
        
    	return max;
    }

}
