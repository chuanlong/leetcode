package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.TreeNode;

public class E100_SameTree {

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
	
}
