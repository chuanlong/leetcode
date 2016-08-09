package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import com.chuanlong.leetcode.bean.TreeNode;

public class M144_BinaryTreePreorderTraversal {

	/**
	 * https://leetcode.com/problems/binary-tree-preorder-traversal/
	 */
	public static void main(String[] args) {

	}
	
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> orders = new ArrayList<Integer>();
    	preorderTraversal(root, orders);
        return orders;
    }
    
    public void preorderTraversal(TreeNode root, List<Integer> orders) {
        if(root == null){
        	return;
        }
        orders.add(root.val);
        preorderTraversal(root.left, orders);
        preorderTraversal(root.right, orders);
    }

}
