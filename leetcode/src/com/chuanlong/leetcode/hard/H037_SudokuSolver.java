package com.chuanlong.leetcode.hard;

public class H037_SudokuSolver {

    public void solveSudoku(char[][] board) {
    	solveSudoku(board, 0, 0);
    }
    
    private boolean solveSudoku(char[][] board, int i, int j){
    	if(i==9){
    		return true;
    	}
    	
    	int x, y;
		if(j == 8){
			x = i+1;
			y = 0;
		}else{
			x = i;
			y = j+1;
		}
    	
    	if(board[i][j] != '.'){
    		return solveSudoku(board, x, y);
    	}
    	
    	for(int k=0; k<9; k++){
    		board[i][j] = (char)('1'+k);
    		if(checkValid(board, i, j)){
    			if(solveSudoku(board, x, y)){
    				return true;
    			}
    		}
    		board[i][j] = '.';
    	}

    	return false;
    }
    
    private boolean checkValid(char[][] board, int i, int j){
    	int iStart = 0, iEnd = 2;
    	if(i>=3 && i<=5){
    		iStart = 3;
    		iEnd = 5;
    	}else if(i>=6 && i<=8){
    		iStart = 6;
    		iEnd = 8;
    	}
    	int jStart = 0, jEnd = 2;
    	if(j>=3 && j<=5){
    		jStart = 3;
    		jEnd = 5;
    	}else if(j>=6 && j<=8){
    		jStart = 6;
    		jEnd = 8;
    	}
    	boolean[] mark1 = new boolean[9];
    	for(int x=iStart; x<=iEnd; x++){
    		for(int y=jStart; y<=jEnd; y++){
    			if(board[x][y] != '.'){
    				if(!mark1[board[x][y]-'1']){
        				mark1[board[x][y]-'1'] = true;
    				}else{
    					return false;
    				}
    			}
    		}
    	}
    	
    	boolean[] mark2 = new boolean[9];
    	for(int x=0; x<9; x++){
    		if(board[x][j] != '.'){
    			if(!mark2[board[x][j]-'1']){
    				mark2[board[x][j]-'1'] = true;
    			}else{
    				return false;
    			}
    		}
    	}
    	
    	boolean[] mark3 = new boolean[9];
    	for(int y=0; y<9; y++){
    		if(board[i][y] != '.'){
    			if(!mark3[board[i][y]-'1']){
    				mark3[board[i][y]-'1'] = true;
    			}else{
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
	
}
