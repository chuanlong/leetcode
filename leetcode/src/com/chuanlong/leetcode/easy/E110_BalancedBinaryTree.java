package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.TreeNode;

public class E110_BalancedBinaryTree {

	/**
	 * @param https://leetcode.com/problems/balanced-binary-tree/
	 */
	public static void main(String[] args) {

	}
	
    public boolean isBalanced(TreeNode root) {
    	return getHeight(root) != -1;
    }
    
    // return -1 if not balanced or its height
    private int getHeight(TreeNode root){
    	if(root == null){
    		return 0;
    	}
    	
    	int leftHeight = getHeight(root.left);
    	int rightHeight = getHeight(root.right);
    	
    	if(leftHeight != -1 && rightHeight != -1 && Math.abs(leftHeight-rightHeight) <= 1){
    		return Math.max(leftHeight, rightHeight) + 1;
    	}else{
    		return -1;
    	}
    }
    

}
