package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.TreeNode;

public class E270_ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        return closestValue(root, target, null, null);
    }

    public int closestValue(TreeNode root, double target, Integer less, Integer more) {
        if(root == null) {
            if(less == null) {
                return more;
            } else if (more == null) {
                return less;
            } else {
                return target-less < more-target ? less : more;
            }
        }

        if(target < root.val) {
            return closestValue(root.left, target, less, root.val);
        } else if (target > root.val) {
            return closestValue(root.right, target, root.val, more);
        } else {
            return root.val;
        }
    }



}
