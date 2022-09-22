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


	public int maxPathSum(TreeNode root) {
		return max(root, new HashMap<>())[1];
	}

	// [maxPathSum, maxFromRoot]
	private int[] max(TreeNode root, Map<TreeNode, int[]> map) {
		if(root == null) return new int[]{Integer.MIN_VALUE, 0};
		if(map.containsKey(root)) return map.get(root);

		int[] max;
		if(root.left == null && root.right == null) {
			max = new int[]{root.val, root.val};
		} else if (root.left != null && root.right == null) {
			max = max(root.left, map);
			int max0 = root.val + Math.max(max[0], 0);
			int max1 = Math.max(max[1], max0);
			max = new int[]{max0, max1};
		} else if (root.left == null && root.right != null) {
			max = max(root.right, map);
			int max0 = root.val + Math.max(max[0], 0);
			int max1 = Math.max(max[1], max0);
			max = new int[]{max0, max1};
		} else {
			int[] maxLeft = max(root.left, map);
			int[] maxRight = max(root.right, map);

			int max0 = root.val + Math.max(Math.max(maxLeft[0], maxRight[0]), 0);
			int max1 = Math.max(Math.max(maxLeft[1], maxRight[1]), Math.max(maxLeft[0],0)+Math.max(maxRight[0],0)+root.val);

			max = new int[]{max0, max1};
		}
		map.put(root, max);
		return max;
	}

    public int maxPathSum2(TreeNode root){

        Map<TreeNode, Integer> maxPathSumMap = new HashMap<>();
        Map<TreeNode, Integer> maxRootPathSumMap = new HashMap<>();
    	
        return maxPathSum2(root, maxPathSumMap, maxRootPathSumMap);
    }
    
    
    public int maxPathSum2(TreeNode root,
						   Map<TreeNode, Integer> maxPathSumMap,
						   Map<TreeNode, Integer> maxRootPathSumMap) {
        if(root == null){
        	return Integer.MIN_VALUE;
        }
        if(maxPathSumMap.containsKey(root)){
        	return maxPathSumMap.get(root);
        }

        int leftMax = maxPathSum2(root.left, maxPathSumMap, maxRootPathSumMap);
        int rightMax = maxPathSum2(root.right, maxPathSumMap, maxRootPathSumMap);
        
        int leftRootMax = maxRootPathSum2(root.left, maxPathSumMap, maxRootPathSumMap);
        int rightRootMax = maxRootPathSum2(root.right, maxPathSumMap, maxRootPathSumMap);
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
    
    
    public int maxRootPathSum2(TreeNode root,
							   Map<TreeNode, Integer> maxPathSumMap,
							   Map<TreeNode, Integer> maxRootPathSumMap){
    	if(root == null){
        	return Integer.MIN_VALUE;
    	}
    	if(maxRootPathSumMap.containsKey(root)){
    		return maxRootPathSumMap.get(root);
    	}
    	
    	int left = maxRootPathSum2(root.left, maxPathSumMap, maxRootPathSumMap);
    	int right = maxRootPathSum2(root.right, maxPathSumMap, maxRootPathSumMap);
    	
    	int max = root.val;
    	if(left > 0 || right > 0){
    		max += Math.max(left, right);
    	}
    	
    	maxRootPathSumMap.put(root, max);
    	return max;
    }
    
    
    
    
    

}
