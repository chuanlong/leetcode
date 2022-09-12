package com.chuanlong.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class M146_LRUCache {

	/**
	 * https://leetcode.com/problems/lru-cache/
	 */
	public static void main(String[] args) {

	}

	class LRUCache {

		class LRUNode {
			LRUNode prev, next;
			int key;
			int value;
			public LRUNode(LRUNode prev, LRUNode next, int key, int value) {
				this.prev = prev;
				this.next = next;
				this.key = key;
				this.value = value;
			}
		}

		private LRUNode head, tail;
		private Map<Integer, LRUNode> map;
		private int capacity;
		private int size;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			size = 0;
			head = tail = new LRUNode(null, null, -1, -1);
			map = new HashMap<>();
		}

		public int get(int key) {
			if(size == 0) return -1;
			LRUNode node = map.get(key);
			if(node == null) return -1;
			removeNode(node);
			addNode(node);
			return node.value;
		}

		public void put(int key, int value) {
			if (map.containsKey(key)) {
				LRUNode node = map.get(key);
				removeNode(node);
				node.value = value;
				addNode(node);
			} else {
				LRUNode node = new LRUNode(null, null, key, value);
				addNode(node);
				map.put(key, node);
				if(size == capacity) {
					map.remove(head.next.key);
					removeNode(head.next);
				} else {
					size++;
				}
			}
		}

		private void removeNode(LRUNode node) {
			if(node == tail) tail = node.prev;
			if(node.prev != null) node.prev.next = node.next;
			if(node.next != null) node.next.prev = node.prev;
		}

		private void addNode(LRUNode node) {
			node.prev = tail;
			node.next = null;
			tail.next = node;
			tail = node;
		}
	}



	public class LRUNode1 {
		int key;
		int value;
		LRUNode1 prev;
		LRUNode1 next;
		public LRUNode1(int key, int value){
			this.key = key;
			this.value = value;
			this.prev = this.next = null;
		}
	}
	
	public class LRUCache1 {
		
		private final int INVALID = -1;
		
		private Map<Integer, LRUNode1> map;
		private LRUNode1 head, tail;
		private int capacity;
		
	    
	    public LRUCache1(int capacity) {
	    	this.capacity = capacity;
	    	this.head = this.tail = new LRUNode1(-1, -1);
	    	this.map = new HashMap<>();
	    }
	    
	    public int get(int key) {
	    	LRUNode1 node = map.get(key);
	    	if(node != null){
	    		if(node != tail){
		    		LRUNode1 prev = node.prev;
		    		LRUNode1 next = node.next;
		    		
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
	    		
	    		LRUNode1 node = map.get(key);
	    		node.value = value;
	    	}else{
		    	LRUNode1 node = new LRUNode1(key, value);
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
