package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M1110_DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i=0; i<to_delete.length; i++) {
            map.put(to_delete[i], true);
        }
        List<TreeNode> list = new ArrayList<>();
        traverse(root, null, map, list);
        return list;
    }

    private void traverse(TreeNode root, TreeNode parent, Map<Integer, Boolean> map, List<TreeNode> list) {
        if(root == null) return;

        TreeNode childParent;
        if(map.containsKey(root.val)) {
            childParent = null;
            if(parent != null && parent.left == root) parent.left = null;
            if(parent != null && parent.right == root) parent.right = null;
        } else {
            childParent = root;
            if(parent == null) list.add(root);
        }

        traverse(root.left, childParent, map, list);
        traverse(root.right, childParent, map, list);

        if(map.containsKey(root.val)) {
            root.left = null;
            root.right = null;
        }
    }
}
