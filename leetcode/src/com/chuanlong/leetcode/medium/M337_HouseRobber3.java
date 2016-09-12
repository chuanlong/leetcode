package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

public class M337_HouseRobber3 {

	/**
	 * https://leetcode.com/problems/house-robber-iii/
	 */
	public static void main(String[] args) {

	}
	
	
    public int rob(TreeNode root) {
    	Rob rob = rob2(root);
        return Math.max(rob.withRoot, rob.withoutRoot);
    }
    
    private Rob rob2(TreeNode root){
    	if(root == null){
    		return new Rob(0, 0);
    	}
    	    	
    	Rob left = rob2(root.left);
    	Rob right = rob2(root.right);
    	
    	int withRoot = left.withoutRoot + right.withoutRoot + root.val;
    	int withoutRoot = Math.max(left.withRoot, left.withoutRoot) + Math.max(right.withRoot, right.withoutRoot);
    	    	
    	return new Rob(withRoot, withoutRoot);
    }
    
    
    class Rob{
    	int withRoot;
    	int withoutRoot;
    	public Rob(int withRoot, int withoutRoot){
    		this.withRoot = withRoot;
    		this.withoutRoot = withoutRoot;
    	}
    }

}
