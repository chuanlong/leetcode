package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

public class M108_ConvertSortedArrayToBinarySearchTree {

	/**
	 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
	 */
	public static void main(String[] args) {

	}
	
	
    public TreeNode sortedArrayToBST(int[] nums) {
    	return array2bst(nums, 0, nums.length-1);
    }
    
    private TreeNode array2bst(int[] nums, int start, int end){
    	if(start == end){
    		return new TreeNode(nums[start]);
    	}else if(start > end){
    		return null;
    	}else{
    		int mid = (start+end) / 2;
    		TreeNode root = new TreeNode(nums[mid]);
    		root.left = array2bst(nums, start, mid-1);
    		root.right = array2bst(nums, mid+1, end);
    		return root;
    	}
    }

}
