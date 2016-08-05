package com.chuanlong.leetcode.easy;

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
    
    class ListNode {
    	 int val;
    	 ListNode next;
    	 ListNode(int x) { val = x; }
    }

}
