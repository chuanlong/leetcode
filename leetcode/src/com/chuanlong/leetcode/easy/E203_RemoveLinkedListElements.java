package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.ListNode;

public class E203_RemoveLinkedListElements {

	/**
	 * https://leetcode.com/problems/remove-linked-list-elements/
	 */
	public static void main(String[] args) {

	}
	
	
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = head;
    	
        while(newHead != null && newHead.val == val){
        	newHead = newHead.next;
        }
        
        ListNode node = newHead;
        while(node != null && node.next != null){
        	if(node.next.val == val){
        		node.next = node.next.next;
        	}else{
        		node = node.next;
        	}
        }
        
    	return newHead;
    }

}
