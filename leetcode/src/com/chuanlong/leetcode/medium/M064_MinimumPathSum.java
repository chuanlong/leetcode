package com.chuanlong.leetcode.medium;

public class M064_MinimumPathSum {

	/**
	 * https://leetcode.com/problems/minimum-path-sum/
	 * */
	public static void main(String[] args) {

	}

    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
        	return 0;
        }
        
        int x = grid[0].length;
        int y = grid.length;
        
        int[][] mins = new int[y][x];
        for(int i=0; i<y; i++){
        	for(int j=0; j<x; j++){
        		int min = Integer.MAX_VALUE;
        		min = (i-1>=0 && min > mins[i-1][j]) ? mins[i-1][j] : min;
        		min = (j-1>=0 && min > mins[i][j-1]) ? mins[i][j-1] : min;
        		
        		min = (min == Integer.MAX_VALUE) ? 0 : min;
        		mins[i][j] = min + grid[i][j];
        	}
        }
    	
    	return mins[y-1][x-1];
    }
	
}
