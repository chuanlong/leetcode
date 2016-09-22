package com.chuanlong.leetcode.medium;

public class M062_UniquePaths {

	/**
	 * https://leetcode.com/problems/unique-paths/
	 */
	public static void main(String[] args) {

	}
	
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0){
        	return 0;
        }
        
        int[][] a = new int[m][n];
    	
        for(int i=0; i<m; i++){
        	for(int j=0; j<n; j++){
        		if(i==0 || j== 0){
        			a[i][j] = 1;
        		}else{
        			a[i][j] = a[i][j-1] + a[i-1][j];
        		}
        	}
        }
    	
        return a[m-1][n-1];
    }

}
