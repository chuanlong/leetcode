package com.chuanlong.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.chuanlong.leetcode.bean.TreeNode;

public class E102_BinaryTreeLevelOrderTraversal {

	/**
	 * https://leetcode.com/problems/binary-tree-level-order-traversal/
	 * */
	public static void main(String[] args) {

	}
	
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	
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
