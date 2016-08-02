package com.chuanlong.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class H282_ExpressionAddOperators {

	/**
	 * https://leetcode.com/problems/expression-add-operators/
	 */
	public static void main(String[] args) {
		
		H282_ExpressionAddOperators obj = new H282_ExpressionAddOperators();
		
//		System.out.println("123, 6 -> [1+2+3, 1*2*3], result:" + List2String(obj.addOperators("123", 6)));
//		System.out.println("232, 8 -> [2*3+2, 2+3*2], result:" + List2String(obj.addOperators("232", 8)));
//		System.out.println("105, 5 -> [1*0+5, 10-5], result:" + List2String(obj.addOperators("105", 5)));
//		System.out.println("00, 0 -> [0+0, 0-0, 0*0], result:" + List2String(obj.addOperators("00", 0)));
//		System.out.println("3456237490, 9191 -> [], result:" + List2String(obj.addOperators("3456237490", 9191)));
		System.out.println("45623, 9123 -> [], result:" + List2String(obj.addOperators("45623", 9123)));

	}
	
	
    public List<String> addOperators(String num, int target) {
        List<Integer> x = new ArrayList<Integer>();
        for(int i=0; i<num.length(); i++){
        	x.add(num.charAt(i)-'0');
        }
        return calculate(x, target);
    }

    
    public List<String> calculate(List<Integer> x, int target) {
        List<String> a = new ArrayList<String>();
        
        if(x.size() == 1){
        	if(x.get(0) == target){
        		a.add(x+"");
        	}
        }else if(x.size() == 2){
        	int x1 = x.get(0);
        	int x2 = x.get(1);
        	
        	if(x1-x2 == target){
        		a.add(x1+"-"+x2);
        	}
        	if(x1+x2 == target){
        		a.add(x1+"+"+x2);
        	}
        	if(x1*x2 == target){
        		a.add(x1+"*"+x2);
        	}
        	if(x1 != 0 && x1*10+x2 == target){
        		a.add(x1+""+x2);
        	}
        }else{
        	int x1 = x.get(0);
        	int x2 = x.get(1);
                    
            List<String> a1 = calculate(SubList(x, 1, x.size()), x1-target);
            if(a1.size() > 0){
            	for(int i=0; i<a1.size(); i++){
            		a.add(x1 + "-" + a1.get(i));
            	}
            }            
            
            List<String> a2 = calculate(SubList(x, 1, x.size()), target-x1);
            if(a2.size() > 0){
            	for(int i=0; i<a2.size(); i++){
            		a.add(x1 + "+" + a2.get(i));
            	}
            }
                        
            List<Integer> subX1 = SubList(x, 2, x.size());
            subX1.add(0, x1*x2);
            List<String> a3 = calculate(subX1, target);
            if(a3.size() > 0){
            	for(int i=0; i<a3.size(); i++){
            		a.add(x1+"*"+x2+a3.get(i).substring(((x1*x2)+"").length()));
            	}
            }
            
            if(x1 != 0){
                List<Integer> subX2 = SubList(x, 2, x.size());
                subX2.add(0, x1*10+x2);
                List<String> a4 = calculate(subX2, target);
                if(a4.size() > 0){
                	for(int i=0; i<a4.size(); i++){
                		a.add(x1+""+x2+a4.get(i).substring(((x1*10+x2)+"").length()));
                	}
                }            	
            }

        }
        
        return a;    	
    }
    
    public static List<Integer> SubList(List<Integer> a, int fromIndex, int toIndex){
    	List<Integer> x = new ArrayList<Integer>();
    	for(int i=fromIndex; i<toIndex&&i<a.size(); i++){
    		x.add(a.get(i));
    	}
    	return x;
    }
    
    public static String List2String(List<String> a){
    	String x = "[";
    	for(int i=0; i<a.size(); i++){
    		x += a.get(i)+ ", ";
    	}
    	if(a.size() > 0){
    		x = x.substring(0, x.length()-2);
    	}
    	x += "]";
    	return x;
    }

}
