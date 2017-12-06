package com.chuanlong.leetcode.medium;

public class M079_WordSearch {

	public static void main(String[] args) {

		char[][] board = new char[][]{
			{'A', 'B', 'C', 'E'}, 
			{'S', 'F', 'C', 'S'}, 
			{'A', 'D', 'E', 'E'}};
			
		String word = "SEE";
		
		M079_WordSearch obj = new M079_WordSearch();
		boolean result = obj.exist(board, word);
		System.out.println("'SEE'->" + result);
		
	}

    public boolean exist(char[][] board, String word) {
    	if(board == null || board.length == 0 || board[0].length == 0
    			|| word == null || word.length() == 0){
    		return false;
    	}
    	
    	for(int i=0; i<board.length; i++){
    		for(int j=0; j<board[0].length; j++){
    			if(exist(board, word, i, j, 0)){
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public boolean exist(char[][] board, String word, int i, int j, int index){
    	if(index == word.length()){
    		return true;
    	}
    	
    	if(i>=0 && i<board.length && j>=0 && j<board[0].length 
    			&& board[i][j] != Character.MIN_VALUE 
    			&& word.charAt(index) == board[i][j]){
    		char ch = board[i][j];
    		board[i][j] = Character.MIN_VALUE;
    		if(exist(board, word, i+1, j, index+1)){
    			return true;
    		}
    		if(exist(board, word, i-1, j, index+1)){
    			return true;
    		}
    		if(exist(board, word, i, j+1, index+1)){
    			return true;
    		}
    		if(exist(board, word, i, j-1, index+1)){
    			return true;
    		}
    		board[i][j] = ch;
    	}
    	return false;
    }
    
	
}
