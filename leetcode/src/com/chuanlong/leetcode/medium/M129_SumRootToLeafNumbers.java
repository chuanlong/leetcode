package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import com.chuanlong.leetcode.bean.TreeNode;

public class M129_SumRootToLeafNumbers {

	
	/**
	 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
	 * */
	public static void main(String[] args) {

	}
	
	
    public int sumNumbers(TreeNode root) {
        
    	List<Integer> path = new ArrayList<>();
    	List<Integer> nums = new ArrayList<>();
    	
    	traverse(root, path, nums);
    	int sum = 0;
    	for(int i=0; i<nums.size(); i++){
    		sum += nums.get(i);
    	}
    	return sum;
    }
    
    
    public void traverse(TreeNode root, List<Integer> path, List<Integer> nums){
    	if(root == null){
    		return;
    	}
    	if(root.left == null && root.right == null){
    		int num = 0;
    		for(int i=0; i<path.size(); i++){
    			num = num*10 + path.get(i);
    		}
    		num = num*10 + root.val;
    		
    		nums.add(num);
    	}else{
    		path.add(root.val);
    		if(root.left != null) traverse(root.left, path, nums);
    		if(root.right != null) traverse(root.right, path, nums);
    		path.remove(path.size()-1);
    	}
    }
	

}
