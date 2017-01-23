package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.ListNode;

public class M147_InsertionSortList {

	/**
	 * https://leetcode.com/problems/insertion-sort-list/
	 */
	public static void main(String[] args) {

	}
	
	
    public ListNode insertionSortList(ListNode head) {
    	if(head == null || head.next == null){
    		return head;
    	}else{
        	ListNode root = new ListNode(Integer.MIN_VALUE);
        	root.next = head;
        	ListNode tail = root.next;
        	
        	while(tail.next != null){
        		if(tail.val <= tail.next.val){
        			// ignore
            		tail = tail.next;
        		}else{
        			ListNode node = tail.next;
        			tail.next = tail.next.next;
        			
        			ListNode start = root;
        			while(start.next != null && start.next.val < node.val){
        				start = start.next;
        			}
        			
        			node.next = start.next;
        			start.next = node;
        		}        		
        	}
        	
        	return root.next;	
    	}    	
    }

}
