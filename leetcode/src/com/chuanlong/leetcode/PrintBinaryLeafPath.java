package com.chuanlong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chuanlong.leetcode.bean.TreeNode;
import com.chuanlong.leetcode.util.Util;

public class PrintBinaryLeafPath {

	public static void main(String[] args) throws Exception {
		
		String str1 = "[1,null,2,3,4,6,7,null,9,null,11,12,13,null,15,16]";
		TreeNode root1 = Util.String2TreeNode(str1);
		PrintBinaryLeafPath obj = new PrintBinaryLeafPath();
		List<String> list1 = obj.scanAllPath(root1);
		Util.printList(list1);
		
//		List<String> list1a = obj.scanAllPath1(root1);
//		Util.printList(list1a);
	}

	public List<String> scanAllPath1(TreeNode root){
		List<String> list = new ArrayList<String>();
		scanAllPathRecursion(root, "", list);
		return list;
	}
	
	private void scanAllPathRecursion(TreeNode root, String prefix, List<String> list){
		if(root == null){
			return;
		}
		String path = prefix + "->" + root.val;
		
		if(root.left == null && root.right == null){
			list.add(path);
		}else{
			if(root.left != null) scanAllPathRecursion(root.left, path, list);
			if(root.right != null) scanAllPathRecursion(root.right, path, list);
		}
	}
	
	public List<String> scanAllPath(TreeNode root){
		List<String> list = new ArrayList<String>();
		
		List<TreeNode> stack = new ArrayList<TreeNode>();
		Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
		if(root != null) stack.add(root);
		while(!stack.isEmpty()){
			TreeNode top = stack.get(stack.size()-1);
			Integer mark = map.get(top);
			if(mark == null){
				// scan left
				if(top.left != null){
					stack.add(top.left);
				}
				map.put(top, 1);
			}else if(mark == 1){
				// scan right
				if(top.right != null){
					stack.add(top.right);
				}
				map.put(top, 2);
			}else{
				// add leaf path to list
				if(top.left == null && top.right == null){
					String path = "";
					for(int i=0; i<stack.size(); i++){
						path = path + stack.get(i).val + "->";
					}
					list.add(path);
				}
				
				// assert mark is 2, pop
				stack.remove(stack.size()-1);
			}
			
			
		}

		return list;
	}

}
