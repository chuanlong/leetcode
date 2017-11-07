package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.chuanlong.leetcode.bean.TreeNode;

public class M144_BinaryTreePreorderTraversal {

	/**
	 * https://leetcode.com/problems/binary-tree-preorder-traversal/
	 */
	public static void main(String[] args) {

		M144_BinaryTreePreorderTraversal obj = new M144_BinaryTreePreorderTraversal();
		
		TreeNode right = new TreeNode(2);
		right.left = new TreeNode(3);
		right.right = null;
		
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = right;
		
		System.out.println("{1,#,2,3} -> [1,2,3], result:" + obj.preorderTraversal(root));
		System.out.println("{1,#,2,3} -> [1,2,3], result:" + obj.preorderTraversal1(root));
		
	}
	
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> orders = new ArrayList<Integer>();
    	preorderTraversal(root, orders);
        return orders;
    }
    
    public void preorderTraversal(TreeNode root, List<Integer> orders) {
        if(root == null){
        	return;
        }
        orders.add(root.val);
        preorderTraversal(root.left, orders);
        preorderTraversal(root.right, orders);
    }
    
    
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> orders = new ArrayList<Integer>();

        int size = 0;
        List<TreeNode> stacks = new ArrayList<TreeNode>();
        if(root != null){
        	orders.add(root.val);
        	stacks.add(size++, root);
        }
        
        while(size > 0){
        	TreeNode child = stacks.get(size-1);
        	if(child.left != null){
        		orders.add(child.left.val);
        		stacks.add(size++, child.left);
        		continue;
        	}
        	
        	if(child.right != null){
        		orders.add(child.right.val);
        		stacks.add(size++, child.right);
        		continue;
        	}

        	size--;
        	while(size > 0){
        		TreeNode parent = stacks.get(size-1);
        		if(parent.left == child){
        			if(parent.right != null){
        				orders.add(parent.right.val);
        				stacks.add(size++, parent.right);
        				break;
        			}else{
        				child = parent;
        				size--;
        			}
        		}else if(parent.right == child){
        			child = parent;
        			size--;
        		}else{
        			// exception
        			child = parent;
        			size--;
        		}
        	}        	
        }
        
        return orders;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode cur = root;
    	while(cur != null || !stack.isEmpty()){
    		if(cur != null){
    			list.add(cur.val);
    			stack.add(cur);
    			cur = cur.left;
    		}else{
    			cur = stack.pop();
    			cur = cur.right;
    		}
    	}
    	return list;
    }
    
}
