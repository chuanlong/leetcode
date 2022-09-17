package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

public class M549_BinaryTreeLongestConsecutiveSequenceII {

    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        int increase = 1+getDepth(root.left, root.val-1, -1) + getDepth(root.right, root.val+1, 1);
        int decrease = 1+getDepth(root.left, root.val+1, 1) + getDepth(root.right, root.val-1, -1);
        int max = Math.max(increase, decrease);
        max = Math.max(max, longestConsecutive(root.left));
        max = Math.max(max, longestConsecutive(root.right));
        return max;
    }

    private int getDepth(TreeNode root, int expect, int diff) {
        if(root == null || root.val != expect) return 0;
        int left = getDepth(root.left, expect+diff, diff);
        int right = getDepth(root.right, expect+diff, diff);
        return Math.max(left, right) + 1;
    }

}
