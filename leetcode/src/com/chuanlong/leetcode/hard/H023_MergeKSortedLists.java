package com.chuanlong.leetcode.hard;

import com.chuanlong.leetcode.bean.ListNode;

public class H023_MergeKSortedLists {

	/**
	 * https://leetcode.com/problems/merge-k-sorted-lists/
	 */
	public static void main(String[] args) {

	}
	
	class ListListNode{
		 public ListNode val;
		 public ListListNode next;
		 public ListListNode(ListNode x) { val = x; }
	}

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
        	return null;
        }else if(lists.length == 1){
        	return lists[0];
        }
        
        ListNode[] ls = new ListNode[lists.length];
        for(int i=0; i<ls.length; i++){
        	ls[i] = lists[i];
        }
        
        quickSort(ls, 0, ls.length-1);
        
        ListListNode lln = null, llnEnd = null;
        for(int i=0; i<ls.length; i++){
        	if(ls[i] != null){
            	if(llnEnd == null){
            		lln = new ListListNode(ls[i]);
            		llnEnd = lln;
            	}else{
            		llnEnd.next = new ListListNode(ls[i]);
            		llnEnd = llnEnd.next;
            	}
        	}
        }
        
        ListNode head = null, end = null;
        
        while(lln != null){
        	if(end == null){
        		head = lln.val;
        		end = lln.val;
        	}else{
        		end.next = lln.val;
        		end = end.next;
        	}
        	
        	ListNode insert = lln.val.next;
        	lln = lln.next;
        	
        	if(insert != null){
        		ListListNode newListListNode = new ListListNode(insert);
        		if(lln == null){
        			lln = newListListNode;
        		}else{
            		if(compare(insert, lln.val) >= 0){
            			newListListNode.next = lln;
            			lln = newListListNode;
            		}else{
            			ListListNode pos = lln;
            			while(pos.next != null && compare(insert, pos.next.val) == -1){
            				pos = pos.next;
            			}
            			newListListNode.next = pos.next;
            			pos.next = newListListNode;
            		}
        		}
        	}
        }

        return head;   
    }
	
    
    private void quickSort(ListNode[] ls, int start, int end){
    	if(start < end){
    		ListNode key = ls[start];
    		int i=start, j=end;
    		
    		while(i < j){
    			while(i < j && compare(ls[j], key)<=0) j--;
    			ls[i] = ls[j];
    			while(i < j && compare(ls[i], key)>=0) i++;
    			ls[j] = ls[i];
    		}
    		ls[i] = key;
    		
    		quickSort(ls, start, i-1);
    		quickSort(ls, i+1, end);
    		
    	}
    }
    
    // 0:equal, -1:l1>l2, 1: l1<l2
    private int compare(ListNode l1, ListNode l2){
    	if(l1 == null && l2 == null){
    		return 0;
    	}else if(l1 == null){
    		return -1;
    	}else if(l2 == null){
    		return 1;
    	}

    	if(l1.val == l2.val){
    		return 0;
    	}else if(l1.val > l2.val){
    		return -1;
    	}else{
    		return 1;  // l1.val < l2.val
    	}
    }
	
	
}
