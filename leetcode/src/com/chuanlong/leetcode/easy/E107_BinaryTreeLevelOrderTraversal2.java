package com.chuanlong.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.chuanlong.leetcode.bean.TreeNode;

public class E107_BinaryTreeLevelOrderTraversal2 {

	/**
	 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
	 */
	public static void main(String[] args) {

	}
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<TreeNode>> list = new ArrayList<List<TreeNode>>();
    	if(root != null){
    		List<TreeNode> level1 = new ArrayList<TreeNode>();
    		level1.add(root);
    		list.add(level1);
    		
    		while(true){
    			List<TreeNode> bottomLevel = list.get(list.size()-1);
    			
    			List<TreeNode> newBottomLevel = new ArrayList<TreeNode>();
    			for(int i=0; i<bottomLevel.size(); i++){
    				if(bottomLevel.get(i).left != null){
    					newBottomLevel.add(bottomLevel.get(i).left);
    				}
    				if(bottomLevel.get(i).right != null){
    					newBottomLevel.add(bottomLevel.get(i).right);
    				}
    			}
    			
    			if(newBottomLevel.size() > 0){
    				list.add(newBottomLevel);
    			}else{
    				break;
    			}
    		}
    	}
    	
    	List<List<Integer>> list2 = new ArrayList<List<Integer>>();
    	for(int i=list.size()-1; i>=0; i--){
    		List<Integer> vals = new ArrayList<Integer>();
    		for(int j=0; j<list.get(i).size(); j++){
    			vals.add(list.get(i).get(j).val);
    		}
    		list2.add(vals);
    	}
    	return list2;
    }

}
