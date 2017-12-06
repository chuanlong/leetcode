package com.chuanlong.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class H212_WordSearchII {
	
	public static void main(String[] args) {

		char[][] board = new char[][]{
			{'o', 'a', 'a', 'n'}, 
			{'e', 't', 'a', 'e'}, 
			{'i', 'h', 'k', 'r'},
			{'i', 'f', 'l', 'v'}};
			
		String[] words = new String[]{"oath","pea","eat","rain"};
			
		H212_WordSearchII obj = new H212_WordSearchII();
		obj.findWords(board, words);
		
	}

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<String>();
        for(String word : words){
        	if(findWords(board, word) && !list.contains(word)){
        		list.add(word);
        	}
        }
    	return list;
    }
    
    private boolean findWords(char[][] board, String word){
    	if(board == null || board.length == 0 || board[0].length == 0){
    		return false;
    	}
    	if(word == null || word.length() == 0){
    		return true;
    	}
    	
    	for(int i=0; i<board.length; i++){
    		for(int j=0; j<board[0].length; j++){
    			if(findWords(board, word, i, j, 0)){
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    private boolean findWords(char[][] board, String word, int i, int j, int index){
    	if(index == word.length()){
    		return true;
    	}
    	if(i>=0 && i<board.length && j>=0 && j<board[0].length
    			&& board[i][j] == word.charAt(index)){
    		char ch = board[i][j];
    		board[i][j] = '0';
    		if(findWords(board, word, i+1, j, index+1)
    				|| findWords(board, word, i-1, j, index+1)
    				|| findWords(board, word, i, j+1, index+1)
    				|| findWords(board, word, i, j-1, index+1)){
        		board[i][j] = ch;
    			return true;
    		}
    		board[i][j] = ch;
    	}
    	return false;
    }
	
}
