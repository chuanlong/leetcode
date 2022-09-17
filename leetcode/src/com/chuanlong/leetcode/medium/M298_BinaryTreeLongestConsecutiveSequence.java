package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

public class M298_BinaryTreeLongestConsecutiveSequence {

    public static void main(String[] args) {
        M298_BinaryTreeLongestConsecutiveSequence obj = new M298_BinaryTreeLongestConsecutiveSequence();

        // Test 1
        TreeNode root1 = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        root1.left = left1;
        System.out.println("Test1, expect:2, output:" + obj.longestConsecutive(root1));

    }

    public int longestConsecutive(TreeNode root) {
        max = 1;
        cur = 0;
        prev = 0;
        traverse(root);
        return max;
    }

    private int max;

    private int cur;
    private int prev;
    private void traverse(TreeNode root) {
        if(root == null) return;
        int tempCur = cur;
        int tempPrev = prev;

        if(cur>0 && prev+1 == root.val) {
            cur++;
            prev = root.val;
            max = Math.max(max, cur);
        } else {
            cur = 1;
            prev = root.val;
        }

        traverse(root.right);
        traverse(root.left);
        cur = tempCur;
        prev = tempPrev;
    }
}
