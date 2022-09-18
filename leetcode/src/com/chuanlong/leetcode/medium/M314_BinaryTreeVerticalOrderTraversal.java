package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class M314_BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedBlockingQueue();
        if(root != null) queue.add(new Pair<>(root, 0));

        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int column = pair.getValue();
            if(!map.containsKey(column)) map.put(column, new ArrayList<Integer>());
            List<Integer> list = map.get(column);
            list.add(node.val);
            if(node.left != null) queue.add(new Pair<>(node.left, column-1));
            if(node.right != null) queue.add(new Pair<>(node.right, column+1));
        }


        List<List<Integer>> list = new ArrayList<>();
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for(Integer key : keys) {
            list.add(map.get(key));
        }
        return list;
    }
}
