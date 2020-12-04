package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class M865_SmallestSubtreeWithAllTheDeepestNodes {

    public static void main(String[] args) {

        M865_SmallestSubtreeWithAllTheDeepestNodes obj = new M865_SmallestSubtreeWithAllTheDeepestNodes();

        TreeNode root1 = new TreeNode(1);
        TreeNode subRoot1 = obj.subtreeWithAllDeepest(root1);

        System.out.println("test1, expect:1, result:" + subRoot1.val);


        TreeNode left2 = new TreeNode(1, null, new TreeNode(2));
        TreeNode right2 = new TreeNode(3);
        TreeNode root2 = new TreeNode(0, left2, right2);
        TreeNode subRoot2 = obj.subtreeWithAllDeepest(root2);

        System.out.println("test2, expect:2, result:" + subRoot2.val);


    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        return subtreeWithAllDeepest(root, 0, map);
    }

    private TreeNode subtreeWithAllDeepest(TreeNode root, int depth, Map<Integer, Integer> map) {
        if (root == null) {
            return null;
        }

        TreeNode subLeft = subtreeWithAllDeepest(root.left, depth+1, map);
        TreeNode subRight = subtreeWithAllDeepest(root.right, depth+1, map);

        if (subLeft == null && subRight == null) {
            map.put(root.val, depth);
            return root;
        } else if (subLeft == null && subRight != null) {
            map.put(root.val, map.get(root.right.val));
            return subRight;
        } else if (subLeft != null && subRight == null) {
            map.put(root.val, map.get(root.left.val));
            return subLeft;
        } else {
            int leftDepth = map.get(root.left.val);
            int rightDepth = map.get(root.right.val);

            if (leftDepth > rightDepth) {
                map.put(root.val, leftDepth);
                return subLeft;
            }else if (rightDepth > leftDepth) {
                map.put(root.val, rightDepth);
                return subRight;
            }else {
                map.put(root.val, leftDepth);
                return root;
            }
        }
    }
}
