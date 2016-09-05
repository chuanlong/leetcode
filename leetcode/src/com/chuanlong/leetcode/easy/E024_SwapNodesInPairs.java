package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.ListNode;

public class E024_SwapNodesInPairs {

	/**
	 * https://leetcode.com/problems/swap-nodes-in-pairs/
	 */
	public static void main(String[] args) {

	}
	
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        
        ListNode newHead = head.next;
        ListNode endNode = head;
        endNode.next = newHead.next;
        newHead.next = endNode;
        
        while(endNode.next != null && endNode.next.next != null){
        	ListNode tempNode = endNode.next;
        	endNode.next = endNode.next.next;
        	tempNode.next = endNode.next.next;
        	endNode.next.next = tempNode;
        	endNode = tempNode;
        }
        
        return newHead;
    }

}
