package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.chuanlong.leetcode.bean.TreeNode;


public class M094_BinaryTreeInorderTraversal {

	/**
	 * https://leetcode.com/problems/binary-tree-inorder-traversal/
	 */
	public static void main(String[] args) {

	}
	
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> orders = new ArrayList<Integer>();
        
        inorderTraversal(root, orders);
        
        return orders;
    }
    
    
    public void inorderTraversal(TreeNode node, List<Integer> orders){
    	if(node == null){
    		return;
    	}
    	
    	inorderTraversal(node.left, orders);
    	orders.add(node.val);
    	inorderTraversal(node.right, orders);
    }
    

    public List<Integer> inorderTraversal1(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode cur = root;
    	while(cur != null || !stack.isEmpty()){
    		if(cur != null){
    			stack.push(cur);
    			cur = cur.left;
    		}else{
    			cur = stack.pop();
    			list.add(cur.val);
    			cur = cur.right;
    		}
    	}
    	return list;
    }
    
}
