package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class M1382_BalanceABinarySearchTree {

    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        traverse(root, list);
        return constructBalancedBST(list, 0, list.size()-1);
    }

    private TreeNode constructBalancedBST(List<TreeNode> list, int i, int j) {
        if(i>j) return null;
        int mid = (i+j)/2;
        TreeNode root = list.get(mid);
        root.left = constructBalancedBST(list, i, mid-1);
        root.right = constructBalancedBST(list, mid+1, j);
        return root;
    }

    private void traverse(TreeNode root, List<TreeNode> list) {
        if(root == null) return;
        traverse(root.left, list);
        list.add(root);
        traverse(root.right, list);
    }
}
