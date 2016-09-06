package com.chuanlong.leetcode.easy;

public class E235_LowestCommonAncestorOfABinarySearchTree {

	/**
	 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
	 */
	public static void main(String[] args) {

	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
        	return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
        	return lowestCommonAncestor(root.right, p, q);
        }else{
        	return root;
        }
    }

}
