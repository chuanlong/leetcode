package com.chuanlong.leetcode.medium;

import java.util.Stack;

import com.chuanlong.leetcode.bean.TreeNode;

public class M173_BinarySearchTreeIterator {

	/**
	 * https://leetcode.com/problems/binary-search-tree-iterator/
	 * */
	public static void main(String[] args) {

	}
	
	public class BSTIterator {
		
		private Stack<TreeNode> stack = null;

	    public BSTIterator(TreeNode root) {
	        stack = new Stack<TreeNode>();
	        TreeNode node = root;
	        while(node != null){
	        	stack.push(node);
	        	node = node.left;
	        }
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	    	TreeNode leaf = stack.pop();
	    	TreeNode node = leaf.right;
	    	while(node != null){
	    		stack.push(node);
	    		node = node.left;
	    	}
	    	return leaf.val;
	    }
	    
	}

}
