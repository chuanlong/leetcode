package com.chuanlong.leetcode.medium;

public class M331_VerifyPreorderSerializationOfABinaryTree {

	/**
	 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
	 * */
	public static void main(String[] args) {

	}
	
	public final static String LEAF = "#";
	
    public boolean isValidSerialization(String preorder) {
        String[] tokens = preorder.split(",");
    	if(tokens.length % 2 == 1){
    		int size = 0;
    		int[] mark = new int[tokens.length];
    		String[] node = new String[tokens.length];
    		
    		for(int i=0; i<tokens.length; i++){
    			if(LEAF.equals(tokens[i])){
    				while(size > 0 && mark[size-1] == 1){
    					size--;
    				}
    				if(size == 0){
    					if(i != tokens.length-1){
    						return false;
    					}
    				}else{
    					mark[size-1]++;
    				}
    			}else{
    				node[size] = tokens[i];
    				mark[size] = 0;
    				size++;
    			}
    		}
    		
    		if(size == 0){
    			return true;
    		}else{
    			return false;
    		}
    	}
    	return false;
    }
	

}
