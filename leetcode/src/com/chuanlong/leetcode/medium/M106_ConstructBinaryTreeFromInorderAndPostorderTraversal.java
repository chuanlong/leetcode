package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

public class M106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2) {
        if (start1 > end1) {
            return null;
        }

        int root = postorder[end2];
        int rootIndexInorder = indexOf(inorder, start1, end1, root);
        TreeNode left = buildTree(inorder, start1, rootIndexInorder-1, postorder, start2, start2 + rootIndexInorder-1-start1);
        TreeNode right = buildTree(inorder, rootIndexInorder+1, end1, postorder, start2 + rootIndexInorder-start1, end2-1);
        return new TreeNode(root, left, right);
    }

    private int indexOf(int[] array, int start, int end, int val) {
        for (int i=start; i<=end; i++) {
            if (array[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
