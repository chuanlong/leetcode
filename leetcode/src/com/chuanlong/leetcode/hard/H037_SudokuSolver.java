package com.chuanlong.leetcode.hard;

public class H037_SudokuSolver {

    public void solveSudoku2(char[][] board) {
    	solveSudoku2(board, 0, 0);
    }

	public void solveSudoku(char[][] board) {
		solveSudoku(board, 0, 0);
	}

	private boolean solveSudoku(char[][] board, int x, int y) {
		if(x == 9) return true;

		int xx, yy;
		if(y==8) {
			xx = x+1;
			yy = 0;
		} else {
			xx = x;
			yy = y+1;
		}

		char ch = board[x][y];
		if(ch == '.') {
			for(int d=1; d<10; d++) {
				if(isValid(board, x, y, d)) {
					board[x][y] = (char)('1'+d-1);
					if(solveSudoku(board, xx, yy)) return true;
					board[x][y] = '.';
				}
			}
			return false;
		} else {
			return solveSudoku(board, xx, yy);
		}
	}

	private boolean isValid(char[][] board, int x, int y, int digit) {
		if(board[x][y] != '.') return false;

		for(int i=0; i<9; i++) {
			boolean[] visited = new boolean[9];
			visited[digit-1] = true;
			char ch = board[i][y];
			if(i!=x && ch != '.') {
				if(visited[ch-'1']) return false;
				else visited[ch-'1'] = true;
			}
		}

		for(int j=0; j<9; j++) {
			boolean[] visited = new boolean[9];
			visited[digit-1] = true;
			char ch = board[x][j];
			if(j!=y && ch != '.') {
				if(visited[ch-'1']) return false;
				else visited[ch-'1'] = true;
			}
		}

		int u=(x/3)*3, v=(y/3)*3;
		boolean[] visited = new boolean[9];
		visited[digit-1] = true;
		for(int i=u; i<u+3; i++) {
			for(int j=v; j<v+3; j++) {
				char ch = board[i][j];
				if(!(i==x && j==y) && ch != '.') {
					if(visited[ch-'1']) return false;
					else visited[ch-'1'] = true;
				}
			}
		}

		return true;
	}


	private boolean solveSudoku2(char[][] board, int i, int j){
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
    		return solveSudoku2(board, x, y);
    	}
    	
    	for(int k=0; k<9; k++){
    		board[i][j] = (char)('1'+k);
    		if(checkValid2(board, i, j)){
    			if(solveSudoku2(board, x, y)){
    				return true;
    			}
    		}
    		board[i][j] = '.';
    	}

    	return false;
    }
    
    private boolean checkValid2(char[][] board, int i, int j){
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
