package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.ListNode;

public class E019_RemoveNthNodeFromEndOfList {

	/**
	 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
	 */
	public static void main(String[] args) {

	}
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
        	return head;
        }
        
        ListNode start = null, end = head;
        for(int i=1; i<n; i++){
        	if(end.next != null){
        		end = end.next;
        	}else{
        		return head;
        	}
        }
        
        while(end.next != null){
        	end = end.next;
        	start = (start == null) ? head : start.next;
        }
        
        if(start == null){
        	return head.next;
        }else{
        	start.next = start.next.next;
        	return head;
        }
    }

}
