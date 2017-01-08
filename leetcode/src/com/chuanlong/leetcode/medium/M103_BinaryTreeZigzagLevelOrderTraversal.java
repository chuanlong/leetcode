package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.chuanlong.leetcode.bean.TreeNode;

public class M103_BinaryTreeZigzagLevelOrderTraversal {

	/**
	 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
	 * */
	public static void main(String[] args) {

	}
	
	
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<>();
    	
    	List<List<Integer>> data = new ArrayList<>();
    	
    	if(root != null){
    		queue.add(root);
    		while(!queue.isEmpty()){
        		List<Integer> level = new ArrayList<>();
        		int size = queue.size();
        		for(int i=0; i<size; i++){
        			TreeNode cur = queue.poll();
        			if(data.size() % 2 == 1){
        				level.add(0, cur.val);
        			}else{
        				level.add(cur.val);
        			}
        			if(cur.left != null) queue.add(cur.left);
        			if(cur.right != null) queue.add(cur.right);
        		}
        		data.add(level);
    		}
    	}
    	return data;
    }
	

}
