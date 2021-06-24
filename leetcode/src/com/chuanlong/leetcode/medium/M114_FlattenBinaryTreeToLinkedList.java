package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

public class M114_FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        flatten2(root);
    }

    private TreeNode flatten2(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = flatten2(root.left);
        TreeNode right = flatten2(root.right);

        root.left = null;
        TreeNode tail = root;
        if(left != null) {
            root.right = left;
            tail = left;
            while(tail.right != null) {
                tail = tail.right;
            }
        }
        tail.right = right;
        return root;
    }
}
