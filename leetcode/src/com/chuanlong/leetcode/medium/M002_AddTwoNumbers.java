package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.ListNode;

public class M002_AddTwoNumbers {

	/**
	 * https://leetcode.com/problems/add-two-numbers/
	 */
	public static void main(String[] args) {

	}
	
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
    	
        ListNode n1 = l1, n2 = l2, n = root;
        int added = 0;
        while(n1 != null || n2 != null || added == 1){
        	int val = added;
        	if(n1 != null){
        		val += n1.val;
        		n1 = n1.next;
        	} 
        	if(n2 != null){
        		val += n2.val;
        		n2 = n2.next;
        	} 
        	
        	if(val > 9){
        		val = val - 10;
        		added = 1;
        	}else{
        		added = 0;
        	}
        	
        	if(n == null){
        		n = new ListNode(val);
        		root = n;
        	}else{
        		n.next = new ListNode(val);
        		n = n.next;
        	}
        }
    	return root;
    }

}
