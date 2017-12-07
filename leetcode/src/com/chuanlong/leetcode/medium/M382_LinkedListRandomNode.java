package com.chuanlong.leetcode.medium;

import java.util.Random;

import com.chuanlong.leetcode.bean.ListNode;

public class M382_LinkedListRandomNode {

	private ListNode head;
	private Random random;
	
	public M382_LinkedListRandomNode(ListNode head) {
		this.head = head;
		this.random = new Random();
	}

	public int getRandom() {
		int count = 0;
		int val = Integer.MIN_VALUE;
		ListNode node = head;
		while(node != null){
			val = random.nextInt(++count) == 0 ? node.val : val;
			node = node.next;
		}
		return val;
	}
	
}
