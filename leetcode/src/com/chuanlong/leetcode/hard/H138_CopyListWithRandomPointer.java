package com.chuanlong.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

import com.chuanlong.leetcode.bean.RandomListNode;

public class H138_CopyListWithRandomPointer {

	/**
	 * https://leetcode.com/problems/copy-list-with-random-pointer/
	 */
	public static void main(String[] args) {

	}

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
        	return head;
        }
    	
    	// map old pointer to new
    	Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    	
    	RandomListNode newHead = new RandomListNode(head.label);
    	map.put(head, newHead);
    	map.put(null, null);
    	
    	RandomListNode oldNode = head, newNode = newHead;
    	while(oldNode.next != null){
    		newNode.next = new RandomListNode(oldNode.next.label);
    		newNode = newNode.next;
    		oldNode = oldNode.next;
    		map.put(oldNode, newNode);
    	}

    	oldNode = head;
    	newNode = newHead;
    	while(oldNode != null){
    		newNode.random = map.get(oldNode.random);
    		newNode = newNode.next;
    		oldNode = oldNode.next;
    	}
    	
    	return newHead;
    }
	
}
