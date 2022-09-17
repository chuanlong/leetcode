package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.TreeNode;

import java.util.Arrays;
import java.util.List;

public class E783_MinimumDistanceBetweenBSTNodes {

    public int minDiffInBST(TreeNode root) {
        return traverse(root).get(2);
    }

    private List<Integer> traverse(TreeNode root) {
        if(root == null) return null;
        int min = root.val, max = root.val, diff = Integer.MAX_VALUE;
        List<Integer> left = traverse(root.left);
        if(left != null) {
            diff = Math.min(diff, Math.min(left.get(2), root.val-left.get(1)));
            min = left.get(0);
        }

        List<Integer> right = traverse(root.right);
        if(right != null) {
            diff = Math.min(diff, Math.min(right.get(2), right.get(0)-root.val));
            max = right.get(1);
        }
        return Arrays.asList(min, max, diff);
    }
}
