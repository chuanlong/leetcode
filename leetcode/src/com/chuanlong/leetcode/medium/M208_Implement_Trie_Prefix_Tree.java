package com.chuanlong.leetcode.medium;

public class M208_Implement_Trie_Prefix_Tree {

	class Trie {
		
		class TrieNode{
			public char ch;
			public boolean isWord;
			public TrieNode[] childs;
			public TrieNode(char ch){
				this.ch = ch;
				this.isWord = false;
				this.childs = new TrieNode[26];
			}
		}
		
		private TrieNode root;
		private final char MARK = '#';
		private final char EMPTY = ' ';

	    /** Initialize your data structure here. */
	    public Trie() {
	        this.root = new TrieNode(MARK);
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	    	if(word.length() == 0){
	    		this.root.ch = EMPTY;
	    	}
	    	
	    	TrieNode node = root;
	    	char[] chs = word.toCharArray();
	    	for(int i=0; i<chs.length; i++){
	    		if(node.childs[chs[i]-'a'] == null){
	    			node.childs[chs[i]-'a'] = new TrieNode(chs[i]);
	    		}
	    		node = node.childs[chs[i]-'a'];
	    	}
	    	node.isWord = true;
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	    	if(word.length() == 0){
	    		return root.ch == EMPTY;
	    	}
	    	
	    	TrieNode node = root;
	    	char[] chs = word.toCharArray();
	    	for(int i=0; i<chs.length; i++){
	    		if(node.childs[chs[i]-'a'] != null){
	    			node = node.childs[chs[i]-'a'];
	    		}else{
	    			return false;
	    		}
	    	}
	    	return node.isWord;
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	    	if(prefix.length() == 0){
	    		return root.ch == EMPTY;
	    	}
	    	
	    	TrieNode node = root;
	    	char[] chs = prefix.toCharArray();
	    	for(int i=0; i<chs.length; i++){
	    		if(node.childs[chs[i]-'a'] != null){
	    			node = node.childs[chs[i]-'a'];
	    		}else{
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	}
	
}
