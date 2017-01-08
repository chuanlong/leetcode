package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.TreeNode;

public class E112_PathSum {

	/**
	 * https://leetcode.com/problems/path-sum/
	 * */
	public static void main(String[] args) {

	}
	
	
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
        	return false;
        }
        if(root.left == null && root.right == null){
        	return sum == root.val;
        }
        
        if(root.left != null){
            boolean isLeft = hasPathSum(root.left, sum-root.val);
            if(isLeft) return true;
        }
        
        if(root.right != null){
            boolean isRight = hasPathSum(root.right, sum-root.val);
            if(isRight) return true;
        }
        
        return false;
    }

}
