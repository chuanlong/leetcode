package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class M2415_ReverseOddLevelsOfBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.offer(root);

        while(queue.size() > 0) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                    stack.push(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                    stack.push(node.right);
                }
            }

            size=queue.size();
            for(int i=0; i<size; i++) {
                TreeNode node1 = queue.poll();
                TreeNode node2 = stack.pop();
                if(i<size/2) {
                    int tmp = node1.val;
                    node1.val = node2.val;
                    node2.val = tmp;
                }
                if(node1.left != null) queue.offer(node1.left);
                if(node1.right != null) queue.offer(node1.right);
            }
        }

        return root;
    }
}
