package com.chuanlong.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class H146_LRUCache {

	/**
	 * https://leetcode.com/problems/lru-cache/
	 */
	public static void main(String[] args) {

	}
	
	
	public class LRUNode{
		int key;
		int value;
		LRUNode prev;
		LRUNode next;
		public LRUNode(int key, int value){
			this.key = key;
			this.value = value;
			this.prev = this.next = null;
		}
	}
	
	public class LRUCache {
		
		private final int INVALID = -1;
		
		private Map<Integer, LRUNode> map;
		private LRUNode head, tail;
		private int capacity;
		
	    
	    public LRUCache(int capacity) {
	    	this.capacity = capacity;
	    	this.head = this.tail = new LRUNode(-1, -1);
	    	this.map = new HashMap<>();
	    }
	    
	    public int get(int key) {
	    	LRUNode node = map.get(key);
	    	if(node != null){
	    		if(node != tail){
		    		LRUNode prev = node.prev;
		    		LRUNode next = node.next;
		    		
		    		prev.next = next;
		    		next.prev = prev;
		    		
		    		tail.next = node;
		    		node.prev = tail;
		    		
		    		tail = node;
	    		}
	    		return node.value;
	    	}
	        return INVALID;
	    }

	    public void put(int key, int value) {
	    	if(map.containsKey(key)){
	    		get(key);
	    		
	    		LRUNode node = map.get(key);
	    		node.value = value;
	    	}else{
		    	LRUNode node = new LRUNode(key, value);
		    	tail.next = node;
		    	node.prev = tail;
		    	tail = node;
		    	map.put(key, node);
		    	
		    	if(map.size() > capacity){
		    		// remove head
		    		map.remove(head.next.key);
		    		
		    		head.next.next.prev = head;
		    		head.next = head.next.next;	    		
		    	}
	    	}
	    }
	}

}
