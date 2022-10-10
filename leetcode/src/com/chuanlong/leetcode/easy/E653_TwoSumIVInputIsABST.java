package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.TreeNode;

import java.util.TreeMap;

public class E653_TwoSumIVInputIsABST {

    public boolean findTarget(TreeNode root, int k) {
        map = new TreeMap<>();
        disorder(root);
        for(int num1: map.keySet()) {
            int num2 = k-num1;
            if(num1 == num2) {
                if(map.get(num2) >= 2) return true;
            } else {
                if(map.containsKey(num2)) return true;
            }
        }
        return false;
    }

    TreeMap<Integer, Integer> map = new TreeMap<>();
    private void disorder(TreeNode node) {
        if(node == null) return;
        disorder(node.left);
        int cnt = map.getOrDefault(node.val, 0);
        map.put(node.val, cnt+1);
        disorder(node.right);
    }
}
