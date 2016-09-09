package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.ListNode;

public class M328_OddEvenLinkedList {

	/**
	 * https://leetcode.com/problems/odd-even-linked-list/
	 */
	public static void main(String[] args) {

	}
	
	
    public ListNode oddEvenList(ListNode head) {
    	if(head == null || head.next == null || head.next.next == null){
    		return head;
    	}
    	
    	ListNode endNode1 = head;
    	
    	ListNode startNode2 = head.next;
    	ListNode endNode2 = head.next;
    	
    	ListNode curNode = head.next.next;
    	while(curNode != null){
    		endNode1.next = curNode;
    		endNode1 = endNode1.next;
    		
    		curNode = curNode.next;
    		if(curNode != null){
    			endNode2.next = curNode;
    			endNode2 = endNode2.next;
    			curNode = curNode.next;
    		}
    	}
    	
    	endNode1.next = startNode2;
    	endNode2.next = null;    	
        return head;
    }
	

}
