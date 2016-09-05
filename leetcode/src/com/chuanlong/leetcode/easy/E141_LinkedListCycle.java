package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.ListNode;

public class E141_LinkedListCycle {

	/**
	 * https://leetcode.com/problems/linked-list-cycle/
	 */
	public static void main(String[] args) {

	}
	
    public boolean hasCycle(ListNode head) {
        if(head == null){
        	return false;
        }
    	
    	ListNode walker = head, runner = head;
    	while(runner.next != null && runner.next.next != null){
    		walker = walker.next;
    		runner = runner.next.next;
    		
    		if(walker == runner){
    			return true;
    		}
    	}
    	
    	return false;
    }

}
