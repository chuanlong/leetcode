package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class M863_AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> paths = new ArrayList<TreeNode>();
        findTarget(root, target, paths);

        List<Integer> list = path(target, k);
        TreeNode prev = target;
        int distance = k-1;
        while(distance>=0 && paths.size()>0) {
            TreeNode node = paths.remove(paths.size()-1);
            boolean isLeft=false;
            if(node.left == prev) {
                node.left = null;
                isLeft = true;
            } else {
                node.right = null;
                isLeft = false;
            }

            list.addAll(path(node, distance));
            distance--;

            if(isLeft) {
                node.left = prev;
            } else {
                node.right = prev;
            }
            prev = node;
        }
        return list;
    }

    private boolean findTarget(TreeNode node, TreeNode target, List<TreeNode> list) {
        if(node == null) return false;
        if(node == target) return true;
        list.add(node);
        if(findTarget(node.left, target, list)) return true;
        if(findTarget(node.right, target, list)) return true;
        list.remove(list.size()-1);
        return false;
    }


    private List<Integer> path(TreeNode root, int k) {
        List<Integer> items = new ArrayList<>();
        path(root, k, items);
        return items;
    }

    private void path(TreeNode node, int k, List<Integer> list) {
        if(node == null) return;
        if(k==0) {
            list.add(node.val);
            return;
        }
        path(node.left, k-1, list);
        path(node.right, k-1, list);

    }

}
