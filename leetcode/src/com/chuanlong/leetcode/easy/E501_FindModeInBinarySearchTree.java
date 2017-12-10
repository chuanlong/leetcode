package com.chuanlong.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.chuanlong.leetcode.bean.TreeNode;

public class E501_FindModeInBinarySearchTree {
	
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        int mode = 0;
        
        int count = 0;
        int val = Integer.MIN_VALUE;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
        	if(cur != null){
        		stack.push(cur);
        		cur = cur.left;
        	}else{
        		cur = stack.pop();
        		
        		if(cur.val == val){
        			count++;
        		}else{
        			count = 1;
        			val = cur.val;
        		}
        		
        		if(count == mode){
        			if(!list.contains(val)){
            			list.add(val);
        			}
        		}else if(count > mode){
        			list.clear();
        			list.add(val);
        			mode = count;
        		}
        		
        		cur = cur.right;
        	}
        }
    	
    	int[] array = new int[list.size()];
    	for(int i=0; i<list.size(); i++){
    		array[i] = list.get(i);
    	}
    	return array;
    }

}
