package com.chuanlong.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.chuanlong.leetcode.bean.TreeNode;

public class E111_MinimumDepthOfBinaryTree {

	/**
	 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
	 * */
	public static void main(String[] args) {

	}

    public int minDepth(TreeNode root) {
        if(root == null){
        	return 0;
        }
        
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	int level = 1;
    	
    	while(!queue.isEmpty()){
    		int size = queue.size();
    		for(int i=0; i<size; i++){
    			TreeNode cur = queue.poll();
    			if(cur.left == null && cur.right == null){
    				return level;
    			}else{
    				if(cur.left != null) queue.add(cur.left);
    				if(cur.right != null) queue.add(cur.right);
    			}
    		}
    		level++;
    	}
    	return level;
    }
	
}
