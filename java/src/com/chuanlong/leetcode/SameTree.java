package com.chuanlong.leetcode;

public class SameTree {

	/**
	 * https://oj.leetcode.com/problems/same-tree/
	 */
	public static void main(String[] args) {



	}

	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;

		if (p != null && q != null) {
			boolean isSame = (p.val == q.val);
			if (!isSame)
				return isSame;
			isSame = isSame && isSameTree(p.left, q.left);
			if (!isSame)
				return isSame;
			isSame = isSame && isSameTree(p.right, q.right);
			return isSame;
		}

		return false;
	}
	
	
	
	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {val = x;}
	}
	
}
