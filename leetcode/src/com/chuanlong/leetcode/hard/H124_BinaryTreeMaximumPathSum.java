package com.chuanlong.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

import com.chuanlong.leetcode.bean.TreeNode;

public class H124_BinaryTreeMaximumPathSum {

	/**
	 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
	 * */
	public static void main(String[] args) {

	}
	

    public int maxPathSum(TreeNode root){

        Map<TreeNode, Integer> maxPathSumMap = new HashMap<>();
        Map<TreeNode, Integer> maxRootPathSumMap = new HashMap<>();
    	
        return maxPathSum(root, maxPathSumMap, maxRootPathSumMap);
    }
    
    
    public int maxPathSum(TreeNode root, 
    		Map<TreeNode, Integer> maxPathSumMap, 
    		Map<TreeNode, Integer> maxRootPathSumMap) {
        if(root == null){
        	return Integer.MIN_VALUE;
        }
        if(maxPathSumMap.containsKey(root)){
        	return maxPathSumMap.get(root);
        }

        int leftMax = maxPathSum(root.left, maxPathSumMap, maxRootPathSumMap);
        int rightMax = maxPathSum(root.right, maxPathSumMap, maxRootPathSumMap);
        
        int leftRootMax = maxRootPathSum(root.left, maxPathSumMap, maxRootPathSumMap);
        int rightRootMax = maxRootPathSum(root.right, maxPathSumMap, maxRootPathSumMap);
        int mixMax = root.val;
        if(leftRootMax > 0){
        	mixMax = mixMax + leftRootMax;
        }
        if(rightRootMax > 0){
        	mixMax = mixMax + rightRootMax;
        }
        
    	int max = Math.max(mixMax, Math.max(leftMax, rightMax));
    	maxPathSumMap.put(root, max);
    	return max;
    }
    
    
    public int maxRootPathSum(TreeNode root, 
    		Map<TreeNode, Integer> maxPathSumMap, 
    		Map<TreeNode, Integer> maxRootPathSumMap){
    	if(root == null){
        	return Integer.MIN_VALUE;
    	}
    	if(maxRootPathSumMap.containsKey(root)){
    		return maxRootPathSumMap.get(root);
    	}
    	
    	int left = maxRootPathSum(root.left, maxPathSumMap, maxRootPathSumMap);
    	int right = maxRootPathSum(root.right, maxPathSumMap, maxRootPathSumMap);
    	
    	int max = root.val;
    	if(left > 0 || right > 0){
    		max += Math.max(left, right);
    	}
    	
    	maxRootPathSumMap.put(root, max);
    	return max;
    }
    
    
    
    
    

}
