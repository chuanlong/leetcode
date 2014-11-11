package com.chuanlong.leetcode;

import java.util.Stack;

public class SymmetricTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSymmetric1(TreeNode root) {
		if (root == null)
			return true;
		TreeNode p = root.left;
		TreeNode q = root.right;
		Stack<TreeNode> ps = new Stack<TreeNode>();
		Stack<TreeNode> qs = new Stack<TreeNode>();
		if (!isEqual(p, q))
			return false;
		while (p != null || ps.size() > 0) {
			while (p != null) {
				ps.push(p);
				qs.push(q);
				if (!isEqual(p.left, q.right))
					return false;
				p = p.left;
				q = q.right;
			}
			if (ps.size() > 0) {
				p = ps.pop();
				q = qs.pop();
				if (!isEqual(p.right, q.left))
					return false;
				p = p.right;
				q = q.left;
			}
		}
		return true;
	}
	
	public boolean isEqual(TreeNode p, TreeNode q) {
		return (p == null && q == null) || (p != null && q != null && p.val == q.val);
	}
	
	
	public boolean isSymmetric2(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}
	
	public boolean isSymmetric(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p != null && q != null) {
			if (p.val != q.val)
				return false;
			if (!isSymmetric(p.left, q.right))
				return false;
			return isSymmetric(p.right, q.left);
		}
		return false;
	}
	
	
}


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
