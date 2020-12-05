package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

public class M1026_MaximumDifferenceBetweenNodeAndAncestor {


    public static void main(String[] args) {
        M1026_MaximumDifferenceBetweenNodeAndAncestor obj = new M1026_MaximumDifferenceBetweenNodeAndAncestor();

        TreeNode root1 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(0, new TreeNode(3), null)));
        int max1 = obj.maxAncestorDiff(root1);
        System.out.println("test1, expect:3, result:" + max1);

    }


    public int maxAncestorDiff(TreeNode root) {
        int[] key = maxDiff(root);
        return key[0];
    }


    private int[] maxDiff(TreeNode root) {
        int[] key = {0, root.val, root.val};

        if (root.left != null) {
            int[] left = maxDiff(root.left);
            cal(root.val, key, left);
        }

        if (root.right != null) {
            int[] right = maxDiff(root.right);
            cal(root.val, key, right);
        }

        return key;
    }

    private void cal(int val, int[] array1, int[] array2){
        array1[0] = max(array1[0], max(array2[0], max(abs(val, array2[1]), abs(val, array2[2]))));
        array1[1] = min(array1[1], min(val, array2[1]));
        array1[2] = max(array1[2], max(val, array2[2]));
    }

    private int abs(int x, int y) {
        int xy = x - y;
        if (xy > 0) {
            return xy;
        } else {
            return 0-xy;
        }
    }

    private int max(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }

    private int min(int x, int y) {
        if (x > y) {
            return y;
        } else {
            return x;
        }
    }

}
