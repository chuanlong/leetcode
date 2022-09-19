package com.chuanlong.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class H051_NQueens {

	/**
	 * https://leetcode.com/problems/n-queens/
	 */
	public static void main(String[] args) {
		
		H051_NQueens obj = new H051_NQueens();
		
		obj.solveNQueens2(4);

	}

	public List<List<String>> solveNQueens(int n) {
		char[][] grid = new char[n][n];
		for(int i=0; i<n; i++) for(int j=0; j<n; j++) grid[i][j] = '.';
		List<List<String>> all = new ArrayList<>();
		backtrack(all, grid, 0, n);
		return all;
	}

	private void backtrack(List<List<String>> all, char[][] grid, int row, int n) {
		if(row >= n) {
			List<String> list = new ArrayList<>();
			for(int i=0; i<n; i++) {
				StringBuilder sb = new StringBuilder();
				for(int j=0; j<n; j++) {
					sb.append(grid[i][j]);
				}
				list.add(sb.toString());
			}
			all.add(list);
			return;
		}

		for(int j=0; j<n; j++) {
			int i = row;
			grid[i][j] = 'Q';
			if(isValid(grid, n, i, j)) backtrack(all, grid, row+1, n);
			grid[i][j] = '.';
		}
	}

	private boolean isValid(char[][] grid, int n, int x, int y) {
		// left up
		for(int i=x-1, j=y-1; i>=0 && j>=0; i--, j--) {
			if(grid[i][j] == 'Q') return false;
		}
		// right up
		for(int i=x-1, j=y+1; i>=0 && j<n; i--, j++) {
			if(grid[i][j] == 'Q') return false;
		}
		for(int i=x-1, j=y; i>=0; i--) {
			if(grid[i][j] == 'Q') return false;
		}
		return true;
	}
	
	private final static String CHESS_QUEEN = "Q";
	private final static String CHESS_DOT = ".";
	
	private final static int QUEEN = -1;
	private final static int DEFAULT = 0;

    public List<List<String>> solveNQueens2(int n) {
    	List<List<String>> list = new ArrayList<List<String>>();
    	int[][] chessboard = new int[n][n];
    	
    	// initialize the chessboard to default
    	for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				chessboard[i][j] = DEFAULT;
			}
		}
    	
    	traversal2(0, n, chessboard, list);
    	return list;
    }
    

    private void traversal2(int level, int n, int[][] chessboard, List<List<String>> list){
    	if(level == n){
    		// add current chessboard to list
    		List<String> solution = new ArrayList<String>();
    		for(int i=0; i<n; i++){
    			String line = "";
    			for(int j=0; j<n; j++){
    				if(chessboard[i][j] == QUEEN){
    					line += CHESS_QUEEN;
    				}else{
    					line += CHESS_DOT;
    				}
    			}
    			solution.add(line);
    		}
    		list.add(solution);
    		return;
    	}
    	    	
    	for(int j=0; j<n; j++){
    		if(chessboard[level][j] == DEFAULT){
    			// set [level, j] as QUEEN
    			chessboard[level][j] = QUEEN;
    			
    			// impact of the QUEEN
    			impactQueen2(level, j, n, chessboard, 1);
    			
    			traversal2(level+1, n, chessboard, list);
    			
    			// set [level, j] to default, try next
    			chessboard[level][j] = DEFAULT;
    			
    			// cancel impact of the QUEEN
    			impactQueen2(level, j, n, chessboard, -1);
    		}
    	}	
    	
    }
    
    private void impactQueen2(int x, int y, int n, int[][] chessboard, int impact){
    	// set the QUEEN disable chessboard
		
		// row
		for(int j=0; j<n; j++){
			if(j != y){
				chessboard[x][j] += impact;
			}
		}
		
		// column
		for(int i=0; i<n; i++){
			if(i != x){
				chessboard[i][y] += impact;
			}
		}
		
		// left-up of four direction
		for(int i=x-1, j=y-1; i>=0 && j>=0; i--, j--){
			chessboard[i][j] += impact;
		}
		
		// right-up of four direction
		for(int i=x-1, j=y+1; i>=0 && j<n; i--, j++){
			chessboard[i][j] += impact;
		}
		
		// right-down of four direction
		for(int i=x+1, j=y+1; i<n && j<n; i++, j++){
			chessboard[i][j] += impact;
		}
		
		// left-down of four direction
		for(int i=x+1, j=y-1; i<n && j>=0; i++, j--){
			chessboard[i][j] += impact;
		}
    }
    
    
}
