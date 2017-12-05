package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeLinkNode;

public class M117_PopulatingNextRightPointersInEachNodeII {
	
    public void connect(TreeLinkNode root) {
    	if(root == null) return;
        TreeLinkNode left = root;
        while(getNext(left) != null){
        	TreeLinkNode cur = left;
        	while(cur != null){
            	if(cur.left != null && cur.right != null){
            		cur.left.next = cur.right;
            		cur.right.next = getNext(cur.next);
            	}else if(cur.left != null && cur.right == null){
            		cur.left.next = getNext(cur.next);
            	}else if(cur.left == null && cur.right != null){
            		cur.right.next = getNext(cur.next);
            	}
        		cur = cur.next;
        	}
        	left = getNext(left);
        }
    }
    
    private TreeLinkNode getNext(TreeLinkNode root){
    	if(root == null) return null;
    	TreeLinkNode k = null;
    	TreeLinkNode next = root;
    	while(next != null){
    		if(next.left != null) {
    			k = next.left;
    			break;
    		}
    		if(next.right != null) {
    			k = next.right;
    			break;
    		}
    		next = next.next;
    	}
    	return k;
    }
    
}
