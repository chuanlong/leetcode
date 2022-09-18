package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.chuanlong.leetcode.bean.TreeNode;

public class M102_BinaryTreeLevelOrderTraversal {

	/**
	 * https://leetcode.com/problems/binary-tree-level-order-traversal/
	 * */
	public static void main(String[] args) {

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedBlockingQueue<>();
		if(root != null) queue.add(root);
		while(!queue.isEmpty()) {
			List<Integer> row = new ArrayList<>();
			int size = queue.size();
			for(int i=0; i<size; i++) {
				TreeNode node = queue.poll();
				row.add(node.val);
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
			list.add(row);
		}

		return list;
	}
	
    public List<List<Integer>> levelOrder1(TreeNode root) {
    	
    	List<TreeNode> order = new ArrayList<>();
    	List<Integer> level = new ArrayList<>();
    	
    	if(root != null){
    		int size = 0;
    		order.add(root);
    		level.add(1);
    		
    		while(size < order.size()){
    			TreeNode currentNode = order.get(size);
    			TreeNode left = currentNode.left;
    			TreeNode right = currentNode.right;
    			int childLevel = level.get(size)+1;
    			
    			if(left != null){
    				order.add(left);
    				level.add(childLevel);
    			}
    			if(right != null){
    				order.add(right);
    				level.add(childLevel);
    			}
    			size++;
    		}
    		
    	}
    	
    	List<List<Integer>> data = new ArrayList<>();
    	int currentLevel = -1;
    	List<Integer> currentData = null;
    	for(int i=0; i<order.size(); i++){
    		if(level.get(i) != currentLevel){
    			if(currentLevel != -1){
    				data.add(currentData);
    			}
    			currentData = new ArrayList<>();
    			currentLevel = level.get(i);
    		}
    		currentData.add(order.get(i).val);
    	}
    	if(currentData != null){
    		data.add(currentData);
    	}
    	
    	return data;
    }
    

}
