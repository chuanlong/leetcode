package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.ListNode;

public class M143_ReorderList {

	/**
	 * https://leetcode.com/problems/reorder-list/
	 */
	public static void main(String[] args) {

		M143_ReorderList obj = new M143_ReorderList();
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		obj.reorderList(n1);
		
	}
	
	
	/**
	 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
	 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
	 * */
    public void reorderList(ListNode head) {
    	if(head == null || head.next == null){
    		return;
    	}
    	
    	ListNode x = head, y = head.next;
    	while(y != null && y.next != null){
    		x = x.next;
    		y = y.next;
    		y = y.next;
    	}
    	
    	/**
    	 * reverse the ListNode
    	 * i->...->j->k change to i<-...<-j<-k
    	 * */ 
    	ListNode i = x.next;
    	x.next = null;
    	if(i.next != null){
    		ListNode j = i.next;
    		i.next = null;
    		while(j.next != null){
    			ListNode temp = j.next;
    			j.next = i;
    			i = j;
    			j = temp;    			
    		}
    		j.next = i;
    		i = j;
    	}
    	
    	ListNode left = head;
    	ListNode right = i;
    	
    	left = head.next;
    	head.next = right;
    	right = right.next;
    	ListNode node = head.next;
    	
    	while(right != null){
    		node.next = left;
    		left = left.next;
    		node.next.next = right;
    		right = right.next;
    		node = node.next.next;
    	}
    	
    	if(left != null){
    		node.next = left;
    		left.next = null;
    	}
    	
    }
    

}
