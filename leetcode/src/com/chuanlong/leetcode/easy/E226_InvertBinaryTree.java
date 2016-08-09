package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.TreeNode;

public class E226_InvertBinaryTree {

	/**
	 * https://leetcode.com/problems/invert-binary-tree/
	 */
	public static void main(String[] args) {

	}
	
    public TreeNode invertTree(TreeNode root) {
    	if(root == null){
    		return root;
    	}
    	
    	TreeNode leftNode = invertTree(root.left);
    	TreeNode rightNode = invertTree(root.right);
    	
    	root.left = rightNode;
    	root.right = leftNode;
        
    	return root;
    }

}
