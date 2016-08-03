package com.chuanlong.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class H282_ExpressionAddOperators2 {

	/**
	 * https://leetcode.com/problems/expression-add-operators/
	 */
	public static void main(String[] args) {
		
		H282_ExpressionAddOperators2 obj = new H282_ExpressionAddOperators2();
		
//		System.out.println("123, 6 -> [1+2+3, 1*2*3], result:" + List2String(obj.addOperators("123", 6)));
//		System.out.println("232, 8 -> [2*3+2, 2+3*2], result:" + List2String(obj.addOperators("232", 8)));
//		System.out.println("105, 5 -> [1*0+5, 10-5], result:" + List2String(obj.addOperators("105", 5)));
//		System.out.println("00, 0 -> [0+0, 0-0, 0*0], result:" + List2String(obj.addOperators("00", 0)));
//		System.out.println("3456237490, 9191 -> [], result:" + List2String(obj.addOperators("3456237490", 9191)));
//		System.out.println("56789, 21 -> [5+6-7+8+9], result:" + List2String(obj.addOperators("56789", 21)));
		
//		System.out.println("45623, 9123 -> [], result:" + List2String(obj.addOperators("45623", 9123)));
//		System.out.println("56789, 35 -> [], result:" + List2String(obj.addOperators("56789", 35)));
		
		System.out.println("2+3*2, calc:8, result:" + (new Expression1("2+3*2").getValue()));
		
	}
	
	
    public List<String> addOperators(String num, int target) {
        List<Expression> x = new ArrayList<Expression>();
        if(num != null){
            for(int i=0; i<num.length(); i++){
            	x.add(new Expression(true, num.charAt(i)-'0'));
            }
        }        
        return calculate(x, target);
    }

    
    public List<String> calculate(List<Expression> x, int target) {
        List<String> a = new ArrayList<String>();
        
        if(x == null || x.size() == 0){
        	//
        }else if(x.size() == 1){
        	if(x.get(0).value == target){
        		a.add(x.get(0).value+"");
        	}
        }else if(x.size() == 2){
        	Expression x1 = x.get(0);
        	Expression x2 = x.get(1);
        	        	
        	if(x1.value-x2.value == target){
        		a.add(x1.value+"-"+x2.value);
        	}
        	if(x1.value+x2.value == target){
        		a.add(x1.value+"+"+x2.value);
        	}
        	if(x1.value*x2.value == target){
        		a.add(x1.value+"*"+x2.value);
        	}
        	if(x1.isNum && x2.isNum && x2.value >= 0
        			&& ((x1.value > 0 && x1.value*10+x2.value == target) || (x1.value < 0 && x1.value*10-x2.value == target)) ){
        		a.add(x1.value+""+x2.value);
        	}
        }else{
        	Expression x1 = x.get(0);
        	Expression x2 = x.get(1);
        	             
        	

        }
        
        return a;    	
    }
    
    public static List<Expression> SubList(List<Expression> a, int fromIndex, int toIndex){
    	List<Expression> x = new ArrayList<Expression>();
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
   
	
	static class Expression1 {
		String exp;
		
		public int getValue(){
			String[] tokens = toReversePolishNotation(exp);
			return evaluate(tokens);
		}
	    
		public Expression1(String exp){
			this.exp = exp;
			
	        operatorLevel = new HashMap<String,Integer>();
	        operatorLevel.put("(", 5);
	        operatorLevel.put(")", 5);
	        operatorLevel.put("*", 4);
	        operatorLevel.put("/", 4);
	        operatorLevel.put("+", 3);
	        operatorLevel.put("-", 3);
		}
		
		HashMap<String,Integer> operatorLevel;

	    public int eval(String[] tokens){
	        int result = 0;
	        String operators = "+-*/";
	        Stack<String> stack = new Stack<String>();
	        for(String t : tokens)
	        {
	            if(!operators.contains(t))
	            {
	                stack.push(t);
	            }else
	            {
	                int a = Integer.valueOf(stack.pop());
	                int b = Integer.valueOf(stack.pop());
	                switch(t)
	                {
	                case "+":
	                    stack.push(String.valueOf(a+b));
	                    break;
	                case "-":
	                    stack.push(String.valueOf(b-a));
	                    break;
	                case "*":
	                    stack.push(String.valueOf(a*b));
	                    break;
	                case "/":
	                    stack.push(String.valueOf(b/a));
	                    break;
	                }
	            }
	        }
	        result = Integer.valueOf(stack.pop());
	        return result;
	    }
	     
	    public int evaluate(String[] tokens)
	    {
	        int result = 0;
	        String operators = "+-*/";
	        Stack<String> stack = new Stack<String>();
	        for(String t : tokens)
	        {
	            if(!operators.contains(t))
	            {
	                stack.push(t);
	            }else
	            {
	                int a = Integer.valueOf(stack.pop());
	                int b = Integer.valueOf(stack.pop());
	                int index = operators.indexOf(t);
	                switch(index)
	                {
	                case 0:
	                    stack.push(String.valueOf(a+b));
	                    break;
	                case 1:
	                    stack.push(String.valueOf(b-a));
	                    break;
	                case 2:
	                    stack.push(String.valueOf(a*b));
	                    break;
	                case 3:
	                    stack.push(String.valueOf(b/a));
	                    break;
	                }
	            }
	        }
	        result = Integer.valueOf(stack.pop());
	        return result;
	    }
	     
	    public String[]  toReversePolishNotation(String input){
	        input = input.replaceAll(" ", "").replaceAll("=", "");//去除表达式中的空格和=号
	        String[] newArr = input.replaceAll("([/\\+\\-\\*\\/\\(\\)])"," $1 ").trim().replaceAll("  ", " ").split(" "); //先把字符串中的操作符左右加空格，再去除最左和最后的空格，在把由于括号和运算符连在一起造成2个空格换成一个空格，最后根据空格分开
	        ArrayList<String> output = new ArrayList<String>();
	        Stack<String> stack = new Stack<String>();
	        for(String t:newArr)
	        {
	            switch(t)
	            {
	            case "(":
	                stack.push(t);
	                break;
	            case "+":
	                if(!stack.empty()&&operatorLevel.get(stack.peek())>=operatorLevel.get(t))
	                {
	                    do{
	                        if(stack.peek().equals("("))
	                        {
	                            break;
	                        }
	                        output.add(stack.pop());
	                         
	                    }while(!stack.empty()&&operatorLevel.get(stack.peek())>=operatorLevel.get(t));
	                    stack.push(t);
	                }else
	                {
	                    stack.push(t);
	                }
	                break;
	            case "-":
	                if(!stack.empty()&&operatorLevel.get(stack.peek())>=operatorLevel.get(t))
	                {
	                    do{
	                        if(stack.peek().equals("("))
	                        {
	                            break;
	                        }
	                        output.add(stack.pop());
	                    }while(!stack.empty()&&operatorLevel.get(stack.peek())>=operatorLevel.get(t));
	                    stack.push(t);
	                }else
	                {
	                    stack.push(t);
	                }
	                break;
	            case "*":
	                if(!stack.empty()&&operatorLevel.get(stack.peek())>=operatorLevel.get(t))
	                {
	                    do{
	                        if(stack.peek().equals("("))
	                        {
	                            break;
	                        }
	                        output.add(stack.pop());
	                    }while(!stack.empty()&&operatorLevel.get(stack.peek())>=operatorLevel.get(t));
	                    stack.push(t);
	                }else
	                {
	                    stack.push(t);
	                }
	                break;
	            case "/":
	                if(!stack.empty()&&operatorLevel.get(stack.peek())>=operatorLevel.get(t))
	                {
	                    do{
	                        if(stack.peek().equals("("))
	                        {
	                            break;
	                        }
	                        output.add(stack.pop());
	                    }while(!stack.empty()&&operatorLevel.get(stack.peek())>=operatorLevel.get(t));
	                    stack.push(t);
	                }else
	                {
	                    stack.push(t);
	                }
	                break;
	            case ")":
	                while(!stack.isEmpty()&&!stack.peek().equals("("))
	                {
	                    output.add(stack.pop());
	                }
	                stack.pop();
	                break;
	                default:
	                    output.add(t);
	                    break;               
	            }
//	            System.out.println(t);
//	            System.out.println("stack="+stack);
//	            System.out.println("output="+output);
	        }
	        while(!stack.isEmpty())
	        {
	            output.add(stack.pop());
	        }
	        String[] result = new String[output.size()];
	        output.toArray(result);
	        return result;
	    }
	}
	

}
