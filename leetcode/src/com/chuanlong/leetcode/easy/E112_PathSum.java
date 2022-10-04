package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.TreeNode;

public class E112_PathSum {

	/**
	 * https://leetcode.com/problems/path-sum/
	 * */
	public static void main(String[] args) {

	}

    public boolean hasPathSum(TreeNode root, int targetSum) {
        flag = false;
        traverse(root, 0, targetSum);
        return flag;
    }

    boolean flag = false;
    private void traverse(TreeNode root, int sum, int targetSum) {
        if(flag) return;
        if(root == null) return;
        if(root.left == null && root.right == null && targetSum == sum+root.val) {
            flag = true;
            return;
        }
        traverse(root.left, sum+root.val, targetSum);
        traverse(root.right, sum+root.val, targetSum);
    }
	
    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null){
        	return false;
        }
        if(root.left == null && root.right == null){
        	return sum == root.val;
        }
        
        if(root.left != null){
            boolean isLeft = hasPathSum2(root.left, sum-root.val);
            if(isLeft) return true;
        }
        
        if(root.right != null){
            boolean isRight = hasPathSum2(root.right, sum-root.val);
            if(isRight) return true;
        }
        
        return false;
    }

}
