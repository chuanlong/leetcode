package com.chuanlong.leetcode.easy;

import com.chuanlong.leetcode.bean.TreeNode;

public class E572_SubtreeOfAnotherTree {

	public static void main(String[] args) {

	}
	
    public boolean isSubtree(TreeNode s, TreeNode t) {
    	if(s == null && t == null){
    		return true;
    	}else if(s == null){
    		return false;
    	}else if(t == null){
    		return false;
    	}else{
            if(isSame(s, t)){
            	return true;
            }else{
            	if(isSubtree(s.left, t)){
            		return true;
            	}
            	if(isSubtree(s.right, t)){
            		return true;
            	}
            	return false;
            }
    	}
    }
    
    public boolean isSame(TreeNode s, TreeNode t){
    	if(s == null && t == null){
    		return true;
    	}else if(s == null){
    		return false;
    	}else if(t == null){
    		return false;
    	}else{
        	if(s.val != t.val){
        		return false;
        	}
        	
        	if(!isSame(s.left, t.left)){
        		return false;
        	}
        	
        	if(!isSame(s.right, t.right)){
        		return false;
        	}
        	
        	return true;
    	}
    }

}
