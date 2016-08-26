package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.ListNode;

public class E206_ReverseLinkedList {

	/**
	 * https://leetcode.com/problems/reverse-linked-list/
	 */
	public static void main(String[] args) {

	}
	
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        
        ListNode x = head, y = head.next;
        x.next = null;
        while(y.next != null){
        	ListNode temp = y.next;
        	y.next = x;
        	x = y;
        	y = temp;
        }
        y.next = x;
    	return y;
    }

}
