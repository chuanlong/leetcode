package com.chuanlong.leetcode.easy;

public class E104_MaximumDepthOfBinaryTree {

	/**
	 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
	 */
	public static void main(String[] args) {

	}

	public int maxDepth(TreeNode root) {
		if(root == null){
			return 0;
		}
		
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		
		return leftDepth > rightDepth ? (leftDepth+1) : (rightDepth+1);
	}

	
	// Definition for a binary tree node.
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	

}
