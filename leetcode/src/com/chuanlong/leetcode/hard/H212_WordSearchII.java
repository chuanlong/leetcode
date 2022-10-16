package com.chuanlong.leetcode.hard;

import javafx.util.Pair;

import java.util.*;

public class H212_WordSearchII {
	
	public static void main(String[] args) {
		H212_WordSearchII obj = new H212_WordSearchII();
		System.out.println("Test1, expect:[eat,oath], output:" + obj.findWords(
				new char[][]{
				{'o', 'a', 'a', 'n'},
				{'e', 't', 'a', 'e'},
				{'i', 'h', 'k', 'r'},
				{'i', 'f', 'l', 'v'}},
				new String[]{"oath","pea","eat","rain"}));


		System.out.println("Test2, expect:[oa,oaa], output:" + obj.findWords(
				new char[][]{
						{'o', 'a', 'b', 'n'},
						{'o', 't', 'a', 'e'},
						{'a', 'h', 'k', 'r'},
						{'a', 'f', 'l', 'v'}},
				new String[]{"oa","oaa"}));

		System.out.println("Test3, expect:[abc,abcd], output:" + obj.findWords(
				new char[][]{
						{'a', 'b', 'c', 'e'},
						{'x', 'x', 'c', 'd'},
						{'x', 'x', 'b', 'a'}},
				new String[]{"abc","abcd"}));
		
	}

	public List<String> findWords(char[][] board, String[] words) {
		Trie root = new Trie();
		for(String word : words) {
			char[] chs = word.toCharArray();
			Trie node = root;
			for(char ch : chs) {
				if(!node.map.containsKey(ch)) node.map.put(ch, new Trie());
				node = node.map.get(ch);
			}
			node.word = word;
		}

		boolean[][] visited = new boolean[board.length][board[0].length];
		TreeSet<String> result = new TreeSet<>();
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				dfs(board, visited, i, j, root, result);
			}
		}
		List<String> copy = new ArrayList<>();
		copy.addAll(result);
		return copy;
	}

	private void dfs(char[][] board, boolean[][] visited,
					 int i, int j, Trie node, TreeSet<String> result) {
		if(i<0 || i>=board.length || j<0 || j>=board[0].length) return;
		if(visited[i][j]) return;
		Trie child = node.map.get(board[i][j]);
		if(child != null) {
			if(child.word != null) result.add(child.word);
			visited[i][j] = true;
			dfs(board, visited, i-1, j, child, result);
			dfs(board, visited, i+1, j, child, result);
			dfs(board, visited, i, j-1, child, result);
			dfs(board, visited, i, j+1, child, result);
			visited[i][j] = false;
		}
	}

	class Trie {
		Map<Character, Trie> map;
		String word;

		public Trie(){
			map = new HashMap<Character, Trie>();
			word = null;
		}
	}





    public List<String> findWords2(char[][] board, String[] words) {
        List<String> list = new ArrayList<String>();
        for(String word : words){
        	if(!list.contains(word) && findWords2(board, word)){
        		list.add(word);
        	}
        }
    	return list;
    }
    
    private boolean findWords2(char[][] board, String word){
    	if(board == null || board.length == 0 || board[0].length == 0){
    		return false;
    	}
    	if(word == null || word.length() == 0){
    		return true;
    	}
    	
    	for(int i=0; i<board.length; i++){
    		for(int j=0; j<board[0].length; j++){
    			if(findWords2(board, word, i, j, 0)){
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    private boolean findWords2(char[][] board, String word, int i, int j, int index){
    	if(index == word.length()){
    		return true;
    	}
    	if(i>=0 && i<board.length && j>=0 && j<board[0].length
    			&& board[i][j] == word.charAt(index)){
    		char ch = board[i][j];
    		board[i][j] = '0';
    		if(findWords2(board, word, i+1, j, index+1)
    				|| findWords2(board, word, i-1, j, index+1)
    				|| findWords2(board, word, i, j+1, index+1)
    				|| findWords2(board, word, i, j-1, index+1)){
        		board[i][j] = ch;
    			return true;
    		}
    		board[i][j] = ch;
    	}
    	return false;
    }
	
}
