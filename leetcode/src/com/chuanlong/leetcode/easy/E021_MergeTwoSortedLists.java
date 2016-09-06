package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.ListNode;

public class E021_MergeTwoSortedLists {

	/**
	 * https://leetcode.com/problems/merge-two-sorted-lists/
	 */
	public static void main(String[] args) {

	}
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
        	return l2;
        }else if(l2 == null){
        	return l1;
        }
        
        ListNode newHead, node, node1, node2;
    	if(l1.val < l2.val){
    		newHead = l1;
    		node = newHead;
    		node1 = l1.next;
    		node2 = l2;
    	}else{
    		newHead = l2;
    		node = newHead;
    		node1 = l1;
    		node2 = l2.next;
    	}
    	
    	while(node1 != null || node2 != null){
    		if(node2 == null || (node1 != null && node1.val < node2.val)){
    			node.next = node1;
    			node = node.next;
    			node1 = node1.next;
    		}else{
    			node.next = node2;
    			node = node.next;
    			node2 = node2.next;
    		}
    	}
    	
    	return newHead;
    }

}
