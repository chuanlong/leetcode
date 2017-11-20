package com.chuanlong.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

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
    			}else{
        			// exception
    				orders.add(parent.val);
    				size--;
    				child = parent;
        		}
    		}
    		
    	}
    	
    	return orders;
    }
    
    public List<Integer> postorderTraversal2(TreeNode root){
    	List<Integer> list = new ArrayList<Integer>();
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode cur = root;
    	while(cur != null || !stack.isEmpty()){
    		if(cur != null){
    			stack.push(cur);
    			cur = cur.left;
    		}else{
    			TreeNode top = stack.peek();
    			if(top.right != null){
    				cur = top.right;
    			}else{
    				TreeNode child = stack.pop();
    				list.add(child.val);
    				while(!stack.isEmpty() && stack.peek().right == child){
    					child = stack.pop();
    					list.add(child.val);
    				}
    			}
    		}
    	}
    	return list;
    }
    
    
    public List<Integer> postorderTraversal3(TreeNode root){
    	List<Integer> list = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	if(root != null){
    		stack.push(root);
    		while(!stack.isEmpty()){
    			TreeNode top = stack.pop();
    			list.add(0, top.val);
    			if(top.left != null) stack.push(top.left);
    			if(top.right != null) stack.push(top.right);
    		}
    	}
    	return list;
    }
    
	
	public static List<Integer> postorderTraversal4(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
		if(root != null) stack.push(root);
		while(!stack.isEmpty()){
			TreeNode top = stack.peek();
			if(!map.containsKey(top)){
				// go left
				if(top.left != null) stack.push(top.left);
				map.put(top, 1);
			}else if(map.get(top) == 1){
				// go right
				if(top.right != null) stack.push(top.right);
				map.put(top, 2);
			}else{
				// add to list and pop
				list.add(top.val);
				stack.pop();
			}
		}
		return list;
	}
	
    
}
