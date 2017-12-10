package com.chuanlong.leetcode.medium;

public class M221_MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        	return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int max = 0;
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<m+1; i++){
        	dp[i][0] = 0;
        }
        for(int j=0; j<n+1; j++){
        	dp[0][j] = 0;
        }
    	
        for(int i=1; i<m+1; i++){
        	for(int j=1; j<n+1; j++){
        		if(matrix[i-1][j-1] == '0'){
        			dp[i][j] = 0;
        		}else{
        			int x = i - dp[i-1][j-1];
        			int xx = i;
        			int y = j - dp[i-1][j-1];
        			int yy = j;
        			while(x<xx && !isSquare(matrix, x, xx, y, yy)){
        				x++;
        				y++;
        			}
        			dp[i][j] = xx-x+1;
        		}
        		max = Math.max(max, dp[i][j]*dp[i][j]);
        	}
        }
        return max;
    }

    private boolean isSquare(char[][] matrix, int i, int ii, int j, int jj){
    	for(int x=i; x<=ii; x++){
    		for(int y=j; y<=jj; y++){
    			if(matrix[x-1][y-1] == '0'){
    				return false;
    			}
    		}
    	}
    	return true;
    }
	
}
