package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

import java.util.*;

public class M1123_LowestCommonAncestorOfDeepestLeaves {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Map<TreeNode, List<TreeNode>> paths = new HashMap<>();
        List<TreeNode> depths = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        deepest = 1;
        traverse(root, 1, stack, paths, depths);

        TreeNode parent = paths.get(depths.get(0)).get(0); // root
        for(int i=1; i<deepest; i++) {
            for(int j=1; j<depths.size(); j++) {
                if(paths.get(depths.get(j)).get(i) != paths.get(depths.get(0)).get(i)) {
                    return parent;
                }
            }
            parent = paths.get(depths.get(0)).get(i);
        }
        return parent;
    }

    private int deepest;
    private void traverse(TreeNode root, int depth,
                          Stack<TreeNode> stack,
                          Map<TreeNode, List<TreeNode>> paths,
                          List<TreeNode> depths) {
        stack.push(root);
        if(root.left == null && root.right == null && depth >= deepest) {
            if(depth > deepest) {
                depths.clear();
                paths.clear();
                deepest = depth;
            }
            depths.add(root);

            List<TreeNode> path = new ArrayList<>();
            for(Object node : stack.toArray()) {
                path.add((TreeNode) node);
            }
            paths.put(root, path);
        } else {
            if(root.left != null) traverse(root.left, depth+1, stack, paths, depths);
            if(root.right != null) traverse(root.right, depth+1, stack, paths, depths);
        }

        stack.pop();
    }


    public TreeNode lcaDeepestLeaves2(TreeNode root) {
        Map<TreeNode, List<TreeNode>> paths = new HashMap<>();
        Map<Integer, List<TreeNode>> depths = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        traverse2(root, 1, stack, paths, depths);

        int deepest = Integer.MIN_VALUE;
        for(Integer depth : depths.keySet()) {
            deepest = Math.max(deepest, depth);
        }

        List<TreeNode> list = depths.get(deepest);
        TreeNode parent = paths.get(list.get(0)).get(0); // root
        for(int i=1; i<deepest; i++) {
            for(int j=1; j<list.size(); j++) {
                if(paths.get(list.get(j)).get(i) != paths.get(list.get(0)).get(i)) {
                    return parent;
                }
            }
            parent = paths.get(list.get(0)).get(i);
        }
        return parent;
    }


    private void traverse2(TreeNode root, int depth,
                           Stack<TreeNode> stack,
                           Map<TreeNode, List<TreeNode>> paths,
                           Map<Integer, List<TreeNode>> depths) {
        stack.push(root);
        if(root.left == null && root.right == null) {
            if(!depths.containsKey(depth)) depths.put(depth, new ArrayList<>());
            depths.get(depth).add(root);
            List<TreeNode> path = new ArrayList<>();
            for(Object node : stack.toArray()) {
                path.add((TreeNode) node);
            }
            paths.put(root, path);
        }

        if(root.left != null) traverse2(root.left, depth+1, stack, paths, depths);
        if(root.right != null) traverse2(root.right, depth+1, stack, paths, depths);

        stack.pop();
    }
}
