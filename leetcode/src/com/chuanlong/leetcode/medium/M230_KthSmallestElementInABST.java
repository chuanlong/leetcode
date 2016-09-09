package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.bean.TreeNode;

public class M230_KthSmallestElementInABST {

	/**
	 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
	 */
	public static void main(String[] args) {

		M230_KthSmallestElementInABST obj = new M230_KthSmallestElementInABST();
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		
		
		obj.kthSmallest(root, 2);
	}
	
	
    public int kthSmallest(TreeNode root, int k) {
    	return kthSmallest1(root, k).kNode.val;
    }
    
    private Res kthSmallest1(TreeNode root, int k){
    	if(root == null){
    		return new Res(null, 0);
    	}else{
    		if(root.left != null){
    			Res leftRes = kthSmallest1(root.left, k);
    			if(leftRes.kNode != null){
    				return leftRes;
    			}else{
    				if(leftRes.size + 1 == k){
    					return new Res(root, -1); 
    				}else{
        				Res rightRes = kthSmallest1(root.right, k-leftRes.size-1); 
        				if(rightRes.kNode != null){
        					return rightRes;
        				}else{
        					return new Res(null, leftRes.size + 1 + rightRes.size);
        				}
    				}
    			}
    		}else{
    			if(1 == k){
    				return new Res(root, -1);
    			}else{
        			Res rightRes = kthSmallest1(root.right, k-1);
        			if(rightRes.kNode != null){
        				return rightRes;
        			}else{
        				return new Res(null, 1 + rightRes.size);
        			}
    			}
    		}
    	}
    }
    
    public static class Res{
    	TreeNode kNode;
    	int size;
    	
    	public Res(TreeNode kNode, int size){
    		this.kNode = kNode;
    		this.size = size;
    	}
    }
    
    

}
