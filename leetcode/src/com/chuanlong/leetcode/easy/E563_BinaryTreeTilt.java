package com.chuanlong.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.chuanlong.leetcode.bean.TreeNode;

public class E563_BinaryTreeTilt {

	public static void main(String[] args) {

	}
	
    public int findTilt(TreeNode root) {
        if(root == null){
        	return 0;
        }else{
            Map<TreeNode, Integer> mapSum = new HashMap<TreeNode, Integer>();
            Map<TreeNode, Integer> mapTilt = new HashMap<TreeNode, Integer>();
            findTiltSum(root, mapSum, mapTilt);
            int sumTilt = 0;
            for(Integer tilt : mapTilt.values()){
            	sumTilt += tilt;
            }
        	return sumTilt;
        }
    }
    
    public void findTiltSum(TreeNode root, Map<TreeNode, Integer> mapSum, Map<TreeNode, Integer> mapTilt){
    	if(root == null || mapTilt.containsKey(root)){
    		return;
    	}

        int sumLeft = 0, sumRight = 0;
        if(root.left != null){
        	findTiltSum(root.left, mapSum, mapTilt);
        	sumLeft = mapSum.get(root.left);
        }
        
        if(root.right != null){
        	findTiltSum(root.right, mapSum, mapTilt);
        	sumRight = mapSum.get(root.right);
        }
    	
        int sum = sumLeft + sumRight + root.val;
        int tilt = Math.abs(sumLeft-sumRight);
        
        mapSum.put(root, sum);
        mapTilt.put(root, tilt);
    }
    
    
    public int findTilt2(TreeNode root) {
    	Map<TreeNode, Integer> sumsMap = new HashMap<TreeNode, Integer>();
    	Map<TreeNode, Integer> tiltMap = new HashMap<TreeNode, Integer>();
    	
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
    			int sumLeft = 0, sumRight = 0;
    			if(top.left != null) sumLeft = sumsMap.get(top.left);
    			if(top.right != null) sumRight = sumsMap.get(top.right);
    			
    			sumsMap.put(top, sumLeft + sumRight + top.val);
    			tiltMap.put(top, Math.abs(sumLeft - sumRight));
    			stack.pop();
    		}
    	}
    	
    	int tiltSum = 0;
    	for(Integer tilt : tiltMap.values()){
    		tiltSum += tilt;
    	}
    	return tiltSum;
    }
    

}
