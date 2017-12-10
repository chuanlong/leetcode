package com.chuanlong.leetcode.unresolve;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.chuanlong.leetcode.bean.TreeNode;

public class H099_RecoverBinarySearchTree {
	
	// TODO
    public void recoverTree(TreeNode root) {
    	List<TreeNode> list = new ArrayList<TreeNode>();
    	
    	int x = Integer.MIN_VALUE;
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode cur = root;
    	while(cur != null || !stack.isEmpty()){
    		if(cur != null){
    			stack.push(cur);
    			cur = cur.left;
    		}else{
    			cur = stack.pop();
    			
    			
    			
    			if(cur.val > x){
    				x = cur.val;
    			}else{
    				list.add(cur);
    			}
    			
    			cur = cur.right;
    		}
    	}
    	
    	if(list.size() == 2){
    		int temp = list.get(0).val;
    		list.get(0).val = list.get(1).val;
    		list.get(1).val = temp;
    	}
    	
    }
	
}
