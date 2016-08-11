package com.chuanlong.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

import com.chuanlong.leetcode.bean.TreeNode;

public class H145_BinaryTreePostorderTraversal {

	/**
	 * https://leetcode.com/problems/binary-tree-postorder-traversal/
	 */
	public static void main(String[] args) {

		H145_BinaryTreePostorderTraversal obj = new H145_BinaryTreePostorderTraversal();
		
		TreeNode right = new TreeNode(2);
		right.left = new TreeNode(3);
		right.right = null;
		
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = right;
		
		System.out.println("{1,#,2,3} -> [3,2,1], result:" + obj.postorderTraversal(root));
		System.out.println("{1,#,2,3} -> [3,2,1], result:" + obj.postorderTraversal1(root));
	}
	
	
	
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> orders = new ArrayList<Integer>();
        
        postorderTraversal(root, orders);
        
        return orders;
    }
    
    public void postorderTraversal(TreeNode node, List<Integer> orders){
    	if(node == null){
    		return;
    	}
    	
    	postorderTraversal(node.left, orders);
    	postorderTraversal(node.right, orders);
    	orders.add(node.val);
    }

    
    
    public List<Integer> postorderTraversal1(TreeNode root){
    	List<Integer> orders = new ArrayList<Integer>();
    	
    	int size = 0;
    	List<TreeNode> stacks = new ArrayList<TreeNode>();
    	if(root != null){
    		size++;
        	stacks.add(root);    		
    	}
    	
    	while(size > 0){
    		TreeNode child = stacks.get(size-1);
    		if(child.left != null){
    			stacks.add(size++, child.left);
    			continue;
    		}
    		if(child.right != null){
    			stacks.add(size++, child.right);
    			continue;
    		}
    		
    		orders.add(child.val);
    		size--;
    		while(size > 0){
        		TreeNode parent = stacks.get(size-1);    			
    			if(parent.left == child){
    				if(parent.right != null){
    					stacks.add(size++, parent.right);
    					break;
    				}else{
    					orders.add(parent.val);
    					size--;
    					child = parent;
    				}
    			}else if(parent.right == child){
    				orders.add(parent.val);
    				size--;
    				child = parent;
    			}
    		}
    		
    	}
    	
    	return orders;
    }
    
}
