package com.chuanlong.leetcode.medium;

public class M063_UniquePaths2 {

	/**
	 * https://leetcode.com/problems/unique-paths-ii/
	 */
	public static void main(String[] args) {

	}

	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	
    	int[][] a = new int[m][n];
    	for(int i=0; i<m; i++){
    		for(int j=0; j<n; j++){
    			if(obstacleGrid[i][j] == 1){
    				a[i][j] = 0;
    			}else{
    				if(i==0 && j==0){
    					a[0][0] = 1;
    				}else{
        				int path = 0;
        				if(i-1 >= 0) path += a[i-1][j];
        				if(j-1 >= 0) path += a[i][j-1];
        				a[i][j] = path;
    				}
    			}
    		}
    	}
    	
    	return a[m-1][n-1];
    }
	
}
