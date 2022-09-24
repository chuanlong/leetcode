package com.chuanlong.leetcode.contest;

import com.chuanlong.leetcode.bean.TreeNode;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class WeeklyContest311 {
    public int smallestEvenMultiple(int n) {
        if(n%2 == 1) return n*2;
        else return n;
    }

    public int longestContinuousSubstring(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;

        int[] a = new int[n];
        int[] b = new int[n];

        a[0] = 0;
        b[0] = 1;
        for(int i=1; i<n; i++) {
            a[i] = Math.max(a[i-1], b[i-1]);
            if(chs[i]-chs[i-1] == 1) {
                b[i] = b[i-1]+1;
            } else {
                b[i] = 1;
            }
        }

        return Math.max(a[n-1], b[n-1]);
    }

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
