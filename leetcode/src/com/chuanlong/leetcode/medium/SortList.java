package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.ListNode;

public class SortList {

	/**
	 * https://leetcode.com/problems/sort-list/
	 */
	public static void main(String[] args) {

		SortList instance = new SortList();
		
		ListNode l = instance.getList();
		ListNode l1 = instance.sortList(l);	// 0,1,2,3,4,5
		ListNode l2 = instance.sortList(null); // null;				

	}
	
	public ListNode sortList(ListNode head) {
		if (head == null)
			return null;

		ListNode min = null;
		ListNode max = null;

		ListNode pMin = null;
		ListNode pMax = null;
		ListNode pMid = head;

		ListNode p = head.next;
		while (p != null) {
			if (p.val == head.val) {
				pMid.next = p;
				pMid = p;
			} else if (p.val < head.val) {
				if (min == null) {
					min = p;
				} else {
					pMin.next = p;
				}
				pMin = p;
			} else {
				if (max == null) {
					max = p;
				} else {
					pMax.next = p;
				}
				pMax = p;
			}
			p = p.next;
		}
		if (pMin != null)
			pMin.next = null;
		if (pMax != null)
			pMax.next = null;
		if (pMid != null)
			pMid.next = null;

		ListNode sortMin = sortList(min);
		ListNode sortMax = sortList(max);

		ListNode newHead = head;
		pMid.next = sortMax;

		if (sortMin != null) {
			newHead = sortMin;
			p = sortMin;
			while (p.next != null)
				p = p.next;
			p.next = head;
		}

		return newHead;
	}

	
	
	// 3, 2, 4, 5, 0, 1;
	public ListNode getList(){

		ListNode l0 = new ListNode(0);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		
		l3.next = l2;
		l2.next = l4;
		l4.next = l5;
		l5.next = l0;
		l0.next = l1;
		
		return l3;
	}

}
