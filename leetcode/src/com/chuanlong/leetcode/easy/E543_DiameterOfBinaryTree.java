package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.TreeNode;

public class E543_DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] pair = dfs(root);
        return pair[0]-1;
    }

    // [diameter, path]
    private int[] dfs(TreeNode node) {
        if(node == null) return new int[]{0, 0};
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int path = Math.max(left[1], right[1]) + 1;
        int diameter = Math.max(Math.max(left[0], right[0]), left[1]+right[1]+1);
        return new int[]{diameter, path};
    }

}
