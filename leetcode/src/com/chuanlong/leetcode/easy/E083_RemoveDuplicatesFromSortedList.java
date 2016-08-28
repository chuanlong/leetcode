package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.ListNode;

public class E083_RemoveDuplicatesFromSortedList {

	/**
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
	 * */
	public static void main(String[] args) {

	}
	
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while(node != null && node.next != null){
        	if(node.val == node.next.val){
        		node.next = node.next.next;
        	}else{
        		node = node.next;
        	}
        }
        
        return head;
    }
	

}
