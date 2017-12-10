package com.chuanlong.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import com.chuanlong.leetcode.bean.RandomListNode;

public class M138_CopyListWithRandomPointer {

	
    public RandomListNode copyRandomList(RandomListNode head) {
    	RandomListNode root = null; 
    	Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    	
    	if(head != null){
    		root = new RandomListNode(head.label);
    		map.put(head, root);

        	RandomListNode curr = head;
        	RandomListNode copy = root;
        	while(curr != null){
        		if(curr.next != null){
            		if(!map.containsKey(curr.next)){
            			map.put(curr.next, new RandomListNode(curr.next.label));
            		}
            		copy.next = map.get(curr.next);
        		}
        		if(curr.random != null){
        			if(!map.containsKey(curr.random)){
        				map.put(curr.random, new RandomListNode(curr.random.label));
        			}
        			copy.random = map.get(curr.random);
        		}
        		curr = curr.next;
        		copy = copy.next;
        	}
    	}
    	
        return root;
    }
    

}
