package com.chuanlong.leetcode.medium;

public class M200_NumberOfIslands {

	/**
	 * https://leetcode.com/problems/number-of-islands/
	 */
	public static void main(String[] args) {

	}
	
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid != null){
            int m = grid.length;
            if(m > 0){
                int n = grid[0].length;
                
                for(int y=0; y<m; y++){
                	for(int x=0; x<n; x++){
                		if(grid[y][x] == '1'){
                			count++;
                			grid[y][x] = '0';
                			wipe(grid, y, x, m, n);
                		}
                	}
                }
            }
        }
    	return count;
    }
    
    
    private void wipe(char[][] grid, int y, int x, int m, int n){    	
    	if(y-1>=0 && grid[y-1][x] == '1'){
    		grid[y-1][x] = '0';
    		wipe(grid, y-1, x, m, n);
    	}
    	
    	if(y+1<m && grid[y+1][x] == '1'){
    		grid[y+1][x] = '0';
    		wipe(grid, y+1, x, m, n);
    	}
    	
    	if(x-1>=0 && grid[y][x-1] == '1'){
    		grid[y][x-1] = '0';
    		wipe(grid, y, x-1, m, n);
    	}
    	
    	if(x+1<n && grid[y][x+1] == '1'){
    		grid[y][x+1] = '0';
    		wipe(grid, y, x+1, m, n);
    	}    	
    }
    
    

}
