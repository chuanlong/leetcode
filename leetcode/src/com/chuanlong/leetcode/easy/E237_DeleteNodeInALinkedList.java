package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.ListNode;

public class E237_DeleteNodeInALinkedList {

	/**
	 * https://leetcode.com/problems/delete-node-in-a-linked-list/
	 */
	public static void main(String[] args) {

	}
	
    public void deleteNode(ListNode node) {
        if(node == null || node.next == null){
        	return;
        }
    	
    	ListNode next = node.next;
    	node.val = next.val;
    	node.next = next.next;
    }

}
