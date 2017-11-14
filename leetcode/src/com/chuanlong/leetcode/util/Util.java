package com.chuanlong.leetcode.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.chuanlong.leetcode.bean.ListNode;
import com.chuanlong.leetcode.bean.TreeNode;

public class Util {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] nums = new int[]{3,2,5,2,1,5,8,2,7,4};
		System.out.print(Array2String(nums) + " -> ");
		quickSort(nums, 0, nums.length-1);
		System.out.println(Array2String(nums));
		
	}

	
    public static String Array2String(int[] a){
    	if(a == null){
    		return "";
    	}
    	String str = "[";
    	for(int i=0; i<a.length; i++){
    		str += a[i] + ",";
    	}
    	if(a.length > 0){
    		str = str.substring(0, str.length()-1);
    	}
    	
    	str += "]";
    	return str;
    }
    
    public static <T> String Array2String(T[] a){
    	if(a == null){
    		return "";
    	}
    	String str = "[";
    	for(int i=0; i<a.length; i++){
    		str += a[i] + ",";
    	}
    	if(a.length > 0){
    		str = str.substring(0, str.length()-1);
    	}
    	
    	str += "]";
    	return str;
    }
    
    public static <T> String List2String(List<T> a){
    	if(a == null){
    		return "";
    	}
    	String str = "[";
    	for(int i=0; i<a.size(); i++){
    		str += a.get(i) + ",";
    	}
    	if(a.size() > 0){
    		str = str.substring(0, str.length()-1);
    	}
    	
    	str += "]";
    	return str;
    }
    
    public static String ListNode2String(ListNode node){
    	if(node == null){
    		return "";
    	}
    	String str = "[";
    	for(ListNode n = node; n != null; n=n.next){
    		str += n.val + ",";
    	}
    	str = str.substring(0, str.length()-1);
    	str += "]";
    	return str;    	
    }
    
    
    public static void quickSort(int[] nums, int start, int end){
    	if(start < end){
    		int key = nums[start];
    		int i = start, j = end;
    		while(i < j){
    			while(i < j && nums[j] >= key) j--;
    			nums[i] = nums[j];
    			while(i < j && nums[i] <= key) i++;
    			nums[j] = nums[i];
    		}
    		nums[i] = key;
    		
    		quickSort(nums, start, i-1);
    		quickSort(nums, i+1, end);
    	}
    }
    
    public static int splitSearch(int[] nums, int val, int start, int end){
    	if(start > end){
    		return -1;
    	}
    	
    	int mid = (start + end)/2;
    	if(nums[mid] == val){
    		return mid;
    	}else{
    		if(nums[mid] < val){
    			return splitSearch(nums, val, mid+1, end);
    		}else{
    			return splitSearch(nums, val, start, mid-1);
    		}
    	}
    }

    
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		TreeNode cur = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				list.add(cur.val);
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				cur = cur.right;
			}
		}
		return list;
	}

	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root != null) stack.push(root);
		while(!stack.isEmpty()){
			TreeNode top = stack.pop();
			list.add(top.val);
			if(top.right != null) stack.push(top.right);
			if(top.left != null) stack.push(top.left);
		}
		return list;
	}
	
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	TreeNode cur = root;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
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
    
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		TreeNode cur = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(cur != null || !stack.isEmpty()){
			if(cur != null){
				stack.push(cur);
				list.add(0, cur.val);
				cur = cur.right;
			}else{
				cur = stack.pop();
				cur = cur.left;
			}
		}
		return list;
	}

	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null) stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			list.add(0, cur.val);
			if (cur.left != null) stack.push(cur.left);
			if (cur.right != null) stack.push(cur.right);
		}
		return list;
	}
}
