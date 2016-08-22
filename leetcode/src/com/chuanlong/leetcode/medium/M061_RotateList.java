package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.ListNode;
import com.chuanlong.leetcode.util.Util;

public class M061_RotateList {

	/**
	 * https://leetcode.com/problems/rotate-list/
	 */
	public static void main(String[] args) {

		M061_RotateList obj = new M061_RotateList();
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		System.out.println("[1,2,3,4,5],2 -> [4,5,1,2,3], result:" + Util.ListNode2String(obj.rotateRight(n1, 2)));
		System.out.println("[1],99 -> [1], result:" + Util.ListNode2String(obj.rotateRight(new ListNode(1), 99)));
		
	}
	
    
    public ListNode rotateRight(ListNode head, int k) {
    	if(head == null || k == 0 || head.next == null){
    		return head;
    	}
    	
    	// if k is too large, k should mode list node size
    	if(k > 100){
    		int size = 1;
    		ListNode n = head;
    		while(n.next != null){
    			size++;
    			n = n.next;
    		}
    		k = k%size;
    	}
    	
    	ListNode x = head, y = head;
    	for(int i=0; i<k; i++){
    		if(y.next != null){
    			y = y.next;
    		}else{
    			y = head;
    		}
    	}
    	
    	while(y.next != null){
    		x = x.next;
    		y = y.next;
    	}
    	
    	ListNode z = head;
    	while(z != x){
    		y.next = z;
    		y = y.next;
    		z = z.next;
    	}
    	
    	ListNode newHead = x.next;
    	y.next = x;
    	x.next = null;
    	
    	return newHead;
    }

}
