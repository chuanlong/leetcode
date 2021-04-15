package com.chuanlong.leetcode.hard;

import com.chuanlong.leetcode.bean.ListNode;
import com.chuanlong.leetcode.test.TestByteDance;

public class H025_ReverseNodesInKGroup {

	/**
	 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
	 * */
	public static void main(String[] args) {
		
		H025_ReverseNodesInKGroup obj = new H025_ReverseNodesInKGroup();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		
		obj.reverseKGroup(node1, 2);
	}
	
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(head == null || k == 1){
    		return head;
    	}
    	ListNode newHead = null, newTail = null;
    	ListNode pointer = head;
    	
    	while(pointer != null){
    		ListNode reversedHead = pointer, reversedTail = pointer;
    		int count = 1;
    		while(reversedTail.next != null && count < k){
    			reversedTail = reversedTail.next;
    			count++;
    		}
    		pointer = reversedTail.next;
    		if(count == k){
    			// reverse k
    			ListNode temp = reversedHead;
    			reversedHead = reversedTail;
    			reversedTail = temp;
    			
    			ListNode x = temp, y = temp.next;
    			x.next = null;
    			for(int i=1; i<k; i++){
    				temp = y;
    				y = y.next;
    				temp.next = x;
    				x = temp;
    			}
    		}else{
    			// no reverse
    		}
    		
    		if(newHead == null){
    			newHead = reversedHead;
    			newTail = reversedTail;
    		}else{
    			newTail.next = reversedHead;
    			newTail = reversedTail;
    		}
    	}
    	return newHead;
    }


	// 1,2,3,4,5 -> 3,2,1,4,5
	// null -> null
	// 1,2 -> 1,2
	// 1,2,3,4,5,6 -> 3,2,1,6,5,4
	public ListNode reverse2(ListNode root, int k) {
		if (root == null) {
			return null;
		}
		if (k <= 1) {
			return root;
		}

		ListNode end = root;
		for(int i=1; i<k; i++) {
			if (end.next != null) {
				end = end.next;
			}else {
				return root;
			}
		}

		ListNode curStart = root, curTail = root, curSec = root.next;
		while(true) {
			if (curStart == end) {
				break;
			}

			ListNode newNode = curSec;
			curSec = curSec.next;
			newNode.next = curStart;
			curStart = newNode;
		}
		curTail.next = null;

		ListNode tail = reverse2(curSec, k);
		curTail.next = tail;
		return curStart;
	}

}
