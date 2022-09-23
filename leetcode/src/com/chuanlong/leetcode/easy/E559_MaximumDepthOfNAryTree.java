package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.Node;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class E559_MaximumDepthOfNAryTree {
    public int maxDepth(Node root) {
        Queue<Node> queue = new LinkedBlockingQueue<>();
        if(root != null) queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                Node node = queue.poll();
                for(int j=0;j<node.children.size(); j++) {
                    queue.offer(node.children.get(j));
                }
            }
        }
        return depth;
    }
}
