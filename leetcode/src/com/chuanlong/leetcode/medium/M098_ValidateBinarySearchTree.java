package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

public class M098_ValidateBinarySearchTree {

	public static void main(String[] args) {

	}
	
    public boolean isValidBST(TreeNode root) {
        if(root == null){
        	return true;
        }
    	
        if(root.left != null && !isValidBST(root.left)){
        	return false;
        }
        
        if(root.right != null && !isValidBST(root.right)){
        	return false;
        }
        
        if(root.left != null){
        	TreeNode leftMax = root.left;
        	while(leftMax.right != null) leftMax = leftMax.right;
        	if(root.val <= leftMax.val){
        		return false;
        	}
        }
        
        if(root.right != null){
        	TreeNode rightMin = root.right;
        	while(rightMin.left != null) rightMin = rightMin.left;
        	if(root.val >= rightMin.val){
        		return false;
        	}
        }
        
    	return true;
    }

}
