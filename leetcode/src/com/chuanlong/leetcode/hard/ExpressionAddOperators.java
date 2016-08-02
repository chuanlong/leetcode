package com.chuanlong.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

	/**
	 * https://leetcode.com/problems/expression-add-operators/
	 */
	public static void main(String[] args) {


	}
	
	
    public List<String> addOperators(String num, int target) {
        List<String> a = new ArrayList<String>();
        
        if(num.length() == 1){
        	int x = num.charAt(0) - '0';
        	if(x == target){
        		a.add(num);
        	}
        }else if(num.length() == 2){
        	int x1 = num.charAt(0) - '0';
        	int x2 = num.charAt(1) - '0';
        	
        	
        }else{
            int[] x = new int[num.length()];
            for(int i=0; i<num.length(); i++){
            	x[i] = num.charAt(i) - '0';
            }
            
            List<Integer>[] y = new List[num.length()];
            for(int i=0; i<num.length(); i++){
            	y[i] = new ArrayList<Integer>();
            }
            
            
            
            
            for(int i=1; i<x.length; i++){
            	String s1 = num.substring(0, i);
            	String s2 = num.substring(i, x.length);
            	
            	
            }
        }
        
               
    	
    	return a;
    }
    
    

}
