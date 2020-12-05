package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.TreeNode;

public class E414_ThirdMaximumNumber {

    public static void main(String[] args) {

    }

    public int thirdMax(int[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        for(int i=1; i<nums.length; i++) {
            add(root, nums[i]);
        }

        if (root.right == null && root.left != null) {
            return root.left.val;
        } else {
            return root.val;
        }
    }

    private void add(TreeNode root, int val) {
        if (val == root.val || (root.left != null && val == root.left.val) || (root.right != null && val == root.right.val)) {
            return;
        }

        if (root.left == null) {
            root.left = new TreeNode(val);
            if (root.val > root.left.val) {
                int val1 = root.val;
                root.val = root.left.val;
                root.left.val = val1;
            }
        } else if (root.right == null) {
            root.right = new TreeNode(val);
            if (root.val > root.right.val) {
                int val1 = root.val;
                root.val = root.right.val;
                root.right.val = val1;
            }
        } else if (val > root.val){
            root.val = val;
            if (root.val > root.left.val) {
                int val1 = root.val;
                root.val = root.left.val;
                root.left.val = val1;
            }
            if (root.val > root.right.val) {
                int val1 = root.val;
                root.val = root.right.val;
                root.right.val = val1;
            }
        }
    }

}
