package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeLinkNode;

public class M116_PopulatingNextRightPointersInEachNode {

	public static void main(String[] args) {

	}

    public void connect(TreeLinkNode root) {
        if(root == null) return;
        root.next = null;
        TreeLinkNode left = root, cur = root;
        while(cur.left != null){
        	while(cur.next != null){
        		cur.left.next = cur.right;
        		cur.right.next = cur.next.left;
        		cur = cur.next;
        	}
        	cur.left.next = cur.right;
        	cur.right.next = null;
        	
        	left = left.left;
        	cur = left;
        }
    }
    
}
