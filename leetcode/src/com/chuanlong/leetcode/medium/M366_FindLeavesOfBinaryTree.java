package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

import java.util.*;

public class M366_FindLeavesOfBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<TreeNode> leafs = new ArrayList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        traverse(null, root, leafs, map);
        HashSet<TreeNode> visited = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        while(leafs.size() > 0) {
            List<Integer> item = new ArrayList<>();
            List<TreeNode> newLeafs = new ArrayList<>();
            for(TreeNode node : leafs) {
                visited.add(node);
                item.add(node.val);
                TreeNode newParent = map.get(node);
                if(newParent != null
                        && (newLeafs.size() == 0 || newParent != newLeafs.get(newLeafs.size()-1))
                        && isLeaf(visited, newParent) && !visited.contains(newParent)) {
                    newLeafs.add(newParent);
                }
            }
            leafs=newLeafs;
            result.add(item);
        }

        return result;
    }

    private boolean isLeaf(HashSet<TreeNode> visited, TreeNode node) {
        if(node.left != null && !visited.contains(node.left)) return false;
        if(node.right != null && !visited.contains(node.right)) return false;
        return true;
    }


    private void traverse(TreeNode parent, TreeNode node, List<TreeNode> leafs, Map<TreeNode, TreeNode> map) {
        map.put(node, parent);
        if(node.left == null && node.right == null) {
            leafs.add(node);
            return;
        }
        if(node.left != null) traverse(node, node.left, leafs, map);
        if(node.right != null) traverse(node, node.right, leafs, map);
    }



    // Wrong
    public List<List<Integer>> findLeaves2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> leafs = new ArrayList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        traverse(null, root, leafs, map);
        List<TreeNode> parents = new ArrayList<>();

        while(leafs.size() > 0) {
            List<Integer> row = new ArrayList<>();
            for(int i=0; i<leafs.size(); i++) {
                TreeNode leaf = leafs.get(i);
                if(leaf.left == null && leaf.right == null) {
                    row.add(leaf.val);
                    if(map.get(leaf) != null && (parents.size()==0 || parents.get(parents.size()-1) != map.get(leaf))) {
                        parents.add(map.get(leaf));
                    }
                } else {
                    if(parents.size()==0 || parents.get(parents.size()-1) != leaf) {
                        parents.add(leaf);
                    }
                }
            }
            for(int i=0; i<leafs.size(); i++) {
                TreeNode leaf = leafs.get(i);
                if(leaf.left == null && leaf.right == null && map.get(leaf) != null) {
                    TreeNode p = map.get(leaf);
                    if(p.left == leaf) p.left = null;
                    else if (p.right == leaf) p.right = null;
                }
            }

            result.add(row);
            leafs = parents;
            parents = new ArrayList<>();
        }

        return result;
    }

}
