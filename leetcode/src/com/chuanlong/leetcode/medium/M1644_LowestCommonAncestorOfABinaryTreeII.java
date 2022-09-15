package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M1644_LowestCommonAncestorOfABinaryTreeII {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        boolean found1 = traverse(root, p, list1);
        if(!found1) return null;
        boolean found2 = traverse(root, q, list2);
        if(!found2) return null;

        assert list1.get(0) == list2.get(0);
        TreeNode parent = list1.get(0);
        for(int i=1; i<list1.size() && i<list2.size(); i++) {
            if(list1.get(i) == list2.get(i)) parent = list1.get(i);
            else break;
        }
        return parent;
    }

    private boolean traverse(TreeNode root, TreeNode node, List<TreeNode> list) {
        if(root == null) return false;
        list.add(root);
        if(root == node) return true;
        if(traverse(root.left, node, list)) return true;
        if(traverse(root.right, node, list)) return true;
        list.remove(list.size()-1);
        return false;
    }

}
