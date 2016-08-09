package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import com.chuanlong.leetcode.bean.TreeNode;


public class M094_BinaryTreeInorderTraversal {

	/**
	 * https://leetcode.com/problems/binary-tree-inorder-traversal/
	 */
	public static void main(String[] args) {

	}
	
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> orders = new ArrayList<Integer>();
        
        inorderTraversal(root, orders);
        
        return orders;
    }
    
    
    public void inorderTraversal(TreeNode node, List<Integer> orders){
    	if(node == null){
    		return;
    	}
    	
    	inorderTraversal(node.left, orders);
    	orders.add(node.val);
    	inorderTraversal(node.right, orders);
    }
    

}
