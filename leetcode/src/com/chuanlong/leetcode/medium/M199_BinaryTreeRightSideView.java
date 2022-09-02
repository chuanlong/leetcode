package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class M199_BinaryTreeRightSideView {

    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();

        List<TreeNode> queue = new ArrayList<>();
        if(root != null) queue.add(root);

        while(!queue.isEmpty()) {
            nodes.add(queue.get(queue.size()-1).val);
            queue = traversal(queue);
        }
        return nodes;
    }

    public List<TreeNode> traversal(List<TreeNode> queue) {
        List<TreeNode> nextQueue = new ArrayList<>();
        for(int i=0; i<queue.size(); i++) {
            TreeNode node = queue.get(i);
            if(node.left != null) nextQueue.add(node.left);
            if(node.right != null) nextQueue.add(node.right);
        }
        return nextQueue;
    }

}
