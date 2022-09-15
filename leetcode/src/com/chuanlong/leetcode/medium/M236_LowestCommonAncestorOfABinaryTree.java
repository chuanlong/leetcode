package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class M236_LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        traverse(root, p, list1);
        traverse(root, q, list2);
        assert list1.get(0) == list2.get(0);
        TreeNode parent = list1.get(0);
        for(int i=1; i<list1.size() && i<list2.size(); i++) {
            if(list1.get(i) != list2.get(i)) {
                break;
            } else {
                parent = list1.get(i);
            }
        }
        return parent;
    }

    private Boolean traverse(TreeNode root, TreeNode node, List<TreeNode> list) {
        if(root == null) return false;
        list.add(root);
        if(root == node) return true;
        if(traverse(root.left, node, list)) return true;
        if(traverse(root.right, node, list)) return true;
        list.remove(list.size()-1);
        return false;
    }


}
