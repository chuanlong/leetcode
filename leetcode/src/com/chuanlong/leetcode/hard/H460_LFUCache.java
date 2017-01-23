package com.chuanlong.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class H460_LFUCache {

	/**
	 * https://leetcode.com/problems/lfu-cache/
	 */
	public static void main(String[] args) {
		
//		H460_LFUCache obj = new H460_LFUCache();
//		LFUCache mLFUCache = obj.new LFUCache(3);
//		mLFUCache.put(2, 2);
//		mLFUCache.put(1, 1);
//		int get1 = mLFUCache.get(2);
//		int get2 = mLFUCache.get(1);
//		int get3 = mLFUCache.get(2);
//		mLFUCache.put(3, 3);
//		mLFUCache.put(4, 4);
//		int get4 = mLFUCache.get(3);
//		
//		System.out.println("get1:" + get1 
//				+ ",get2:" + get2 
//				+ ",get3:" + get3 
//				+ ",get4:" + get4);
		
				
		String[] actions = new String[]{"LFUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"};
		int[][] datas = new int[][]{{10},{10,13},{3,17},{6,11},{10,5},{9,10},{13},{2,19},{2},{3},{5,25},{8},{9,22},{5,5},{1,30},{11},{9,12},{7},{5},{8},{9},{4,30},{9,3},{9},{10},{10},{6,14},{3,1},{3},{10,11},{8},{2,14},{1},{5},{4},{11,4},{12,24},{5,18},{13},{7,23},{8},{12},{3,27},{2,12},{5},{2,9},{13,4},{8,18},{1,7},{6},{9,29},{8,21},{5},{6,30},{1,12},{10},{4,15},{7,22},{11,26},{8,17},{9,29},{5},{3,4},{11,30},{12},{4,29},{3},{9},{6},{3,4},{1},{10},{3,29},{10,28},{1,20},{11,13},{3},{3,12},{3,8},{10,9},{3,26},{8},{7},{5},{13,17},{2,27},{11,15},{12},{9,19},{2,15},{3,16},{1},{12,17},{9,1},{6,19},{4},{5},{5},{8,1},{11,7},{5,2},{9,28},{1},{2,2},{7,4},{4,22},{7,24},{9,26},{13,28},{11,26}};

		H460_LFUCache obj = new H460_LFUCache();
		LFUCache mLFUCache = null;
		for(int i=0; i<actions.length; i++){
			String action = actions[i];
			int[] data = datas[i];
			
			if(action.equals("LFUCache")){
				mLFUCache = obj.new LFUCache(data[0]);
			}else if(action.equals("get")){
				mLFUCache.get(data[0]);
			}else if(action.equals("put")){
				mLFUCache.put(data[0], data[1]);
			}
			
			System.out.println("Line:" + i + ", " + mLFUCache.descrition());
		}
		
		
	}
	
	public class LFUCache {
		
		private Map<Integer, LFUNode> map;
		private Map<Integer, Integer> counts;
		private LFUNode head, tail;
		private int capacity;

	    public LFUCache(int capacity) {
	        this.capacity = capacity;
	        this.map = new HashMap<>();
	        this.counts = new HashMap<>();
	        head = tail = new LFUNode(-1, -1);
	    }
	    
	    public int get(int key) {
	    	addCount(key);
	    	
	    	int value = -1;
	        if(map.containsKey(key)){
	        	LFUNode node = map.get(key);
	        	
	        	move(node.key);
	        	
	        	value = node.value;
	        }
	        
	        return value;
	    }
	    
	    public void put(int key, int value) {
	    	if(capacity > 0){		    	
		    	if(map.containsKey(key)){
		    		map.get(key).value = value;
		    		
		    		move(key);
		    	}else{

		    		if(map.size() == capacity){
		    			map.remove(head.next.key);
		    			counts.remove(head.next.key);
		    			if(capacity == 1){
		    				head.next = null;
		    				tail = head;
		    			}else{	
			    			head.next.next.prev = head;
			    			head.next = head.next.next;
		    			}
		    		}	
		    		
		    		LFUNode node = new LFUNode(key, value);
		    		map.put(key, node);

		    		LFUNode replace = head;
		    		while(replace.next != null && getCount(replace.next.key) <= getCount(node.key)){
		    			replace = replace.next;
		    		}
		    		
		    		if(replace != tail){
		    			replace.next.prev = node;
		    			node.next = replace.next;
		    		}else{
		    			node.next = null;
		    			tail = node;
		    		}
		    		
		    		replace.next = node;
		    		node.prev = replace;		
		    	}
		    	
		    	addCount(key);		    	
	    	}
	    }
	    
	    private int getCount(int key){
	    	if(counts.containsKey(key)){
	    		return counts.get(key);
	    	}else{
	    		return 0;
	    	}
	    }
	    
	    private void addCount(int key){
	    	if(counts.containsKey(key)){
	    		counts.put(key, counts.get(key)+1);
	    	}else{
	    		counts.put(key, 1);
	    	}
	    }
	    	    
	    
	    private void move(int key){
	    	LFUNode node = map.get(key);
	    	
        	if(node != tail){
        		LFUNode prev = node.prev;
	        	prev.next.next.prev = prev;
	        	prev.next = prev.next.next;

	        	LFUNode replace = prev;
	        	while(replace.next != null && getCount(replace.next.key) <= getCount(node.key)){
	        		replace = replace.next;
	        	}
	        	
	        	if(replace != tail){
	        		replace.next.prev = node;
	        		node.next = replace.next;		        		
	        	}else{
	        		node.next = null;
	        		tail = node;
	        	}
	        	
	        	replace.next = node;
	        	node.prev = replace;	        		
        	}
	    }
	    
	    private String descrition(){
	    	String str = "[";
	    	LFUNode node = head;
	    	while(node.next != null){
	    		str = str + node.next.key + ",";
	    		node = node.next;
	    	}
	    	str = str + "]";
	    	return "size:" + map.size() +  ", " + str;
	    }

		
		public class LFUNode{
			int key;
			int value;
			LFUNode prev, next;
			public LFUNode(int key, int value){
				this.key = key;
				this.value = value;
				this.prev = this.next = null;
			}
		}	    
	    
	    
	}

}
