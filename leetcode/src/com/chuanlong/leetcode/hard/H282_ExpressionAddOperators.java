package com.chuanlong.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class H282_ExpressionAddOperators {

	/**
	 * https://leetcode.com/problems/expression-add-operators/
	 */
	public static void main(String[] args) {
		
		H282_ExpressionAddOperators obj = new H282_ExpressionAddOperators();

		
		System.out.println("123, 6 -> [1+2+3, 1*2*3], result:" + List2String(obj.addOperators("123", 6)));
		System.out.println("232, 8 -> [2*3+2, 2+3*2], result:" + List2String(obj.addOperators("232", 8)));
		System.out.println("105, 5 -> [1*0+5, 10-5], result:" + List2String(obj.addOperators("105", 5)));
		System.out.println("00, 0 -> [0+0, 0-0, 0*0], result:" + List2String(obj.addOperators("00", 0)));
		System.out.println("3456237490, 9191 -> [], result:" + List2String(obj.addOperators("3456237490", 9191)));
		System.out.println("56789, 21 -> [5+6-7+8+9], result:" + List2String(obj.addOperators("56789", 21)));
		
		System.out.println("123456789, 45 -> [...], result:" + List2String(obj.addOperators("123456789", 45)));
		
//		System.out.println("45623, 9123 -> [], result:" + List2String(obj.addOperators("45623", 9123)));
//		System.out.println("56789, 35 -> [], result:" + List2String(obj.addOperators("56789", 35)));
		
//		System.out.println("2+3*2, calc:8, result:" + (new Expression("2+3*2").value));
//		System.out.println("1+23-4*5-6+7*8-9, calc:45, result:" + new Expression("1+23-4*5-6+7*8-9").value);
//		System.out.println("-1+23-4*5-6+7*8-9, calc:43, result:" + new Expression("-1+23-4*5-6+7*8-9").value);
		
	}
	
	
    public List<String> addOperators(String num, int target) {
        List<Expression> x = new ArrayList<Expression>();
        if(num != null){
            for(int i=0; i<num.length(); i++){
            	x.add(new Expression(num.charAt(i)+""));
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
        		a.add(x.get(0).exp);
        	}
        }else if(x.size() == 2){
        	Expression x1 = x.get(0);
        	Expression x2 = x.get(1);
        	        	
        	if(x1.value-x2.value == target){
        		a.add(x1.exp+"-"+x2.exp);
        	}
        	if(x1.value+x2.value == target){
        		a.add(x1.exp+"+"+x2.exp);
        	}
        	if(x1.value*x2.value == target){
        		a.add(x1.exp+"*"+x2.exp);
        	}

            Expression newExp4 = new Expression(x1.exp+x2.exp);
            if(newExp4.valid && newExp4.value == target){
        		a.add(x1.exp + x2.exp);
            	
            }

        }else{
        	Expression x1 = x.get(0);
        	Expression x2 = x.get(1);
        	             
        	Expression newExp1 = new Expression("-" + x2.exp);
        	if(newExp1.valid){
            	List<Expression> subX1 = SubList(x, 2, x.size());
            	subX1.add(0, newExp1);
            	List<String> a1 = calculate(subX1, target - x1.value);
                if(a1.size() > 0){
                	for(int i=0; i<a1.size(); i++){
                		a.add(x1.exp + a1.get(i));
                	}
                }
        	}
                    	
            List<Expression> subX2 = SubList(x, 2, x.size());
            subX2.add(0, new Expression(x2.exp));
            List<String> a2 = calculate(subX2, target - x1.value);
            if(a2.size() > 0){
            	for(int i=0; i<a2.size(); i++){
            		a.add(x1.exp + "+" + a2.get(i));
            	}
            }
            
            List<Expression> subX3 = SubList(x, 2, x.size());
            subX3.add(0, new Expression(x1.exp+"*"+x2.exp));
            List<String> a3 = calculate(subX3, target);
            if(a3.size() > 0){
            	for(int i=0; i<a3.size(); i++){
            		a.add(a3.get(i));
            	}
            }
            
            Expression newExp4 = new Expression(x1.exp+x2.exp);
            if(newExp4.valid){
                List<Expression> subX4 = SubList(x, 2, x.size());
                subX4.add(0, newExp4);
                List<String> a4 = calculate(subX4, target);
                if(a4.size() > 0){
                	for(int i=0; i<a4.size(); i++){
                		a.add(a4.get(i));
                	}
                }
            }

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

	
	class Expression {
		String exp;
		int value = 0;
		boolean valid = false;
		
		final char RESERVED = '@';
	    
		public Expression(String exp){
			this.exp = exp;
			
			try{
				getValue();				
			}catch(Exception e){
			}
		}
		
		public void getValue() throws Exception{
			if(exp == null || exp.equals("")){
				return;
			}
			
			char[] tokens = exp.toCharArray();
			for(int i=0; i<tokens.length; i++){
				if((tokens[i] >= '0' && tokens[i] <= '9') 
						|| tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' ){
					// right format
				}else{
					return;
				}					
			}
			
			boolean isStartWithMinu = false;
			if(exp.startsWith("-")){
				isStartWithMinu = true;
				tokens = exp.substring(1).toCharArray();
			}
						
			Stack<Integer> nums = new Stack<Integer>();
			Stack<Character> symbols = new Stack<Character>();
			
			String token = "";
			for(int i=0; i<tokens.length+1; i++){
				char ch = RESERVED;
				if(i<tokens.length){
					 ch = tokens[i];
				}
				if(ch == '+' || ch == '-' || ch == '*' || ch == RESERVED){
					if(token.length() == 0){
						return;
					}else if(token.length() > 1 && token.startsWith("0")){
						return;
					}else{
						int num = Integer.parseInt(token);
						if(isStartWithMinu){
							num = 0-num;
							isStartWithMinu = false;
						}
						nums.push(num);
						symbols.push(ch);
						token = "";
					}
				}else{
					token += ch;
				}
			}
			
			if(nums.size() == symbols.size() && symbols.size() > 0 && symbols.pop() == RESERVED){
			}else{
				return;
			}
			
			int result = nums.pop();
			
			int cacheNum = 0;
			char cacheSymbol = RESERVED;			
			while(!nums.empty() && !symbols.isEmpty()){
				int tempNum = nums.pop();
				char tempSymbol = symbols.pop();
				
				if(cacheSymbol == RESERVED){
					if(tempSymbol == '*'){
						result = cal(tempNum, result, '*');
					}else{
						cacheNum = tempNum;
						cacheSymbol = tempSymbol;						
					}
				}else{
					if(cacheSymbol != '+' && cacheSymbol != '-'){
						return;
					}
					
					if(tempSymbol == '-'){
						result = cal(0-cacheNum, result, cacheSymbol);
						cacheNum = tempNum;
						cacheSymbol = '+';
					}else if(tempSymbol == '+'){
						result = cal(cacheNum, result, cacheSymbol);
						cacheNum = tempNum;
						cacheSymbol = tempSymbol;						
					}else if(tempSymbol == '*'){
						cacheNum = cal(tempNum, cacheNum, '*');
					}else{
						return;
					}
					
				}
			}
			if(cacheSymbol != RESERVED){
				result = cal(cacheNum, result, cacheSymbol);
			}
			
			valid = true;
			value = result;
		}

		private int cal(int x1, int x2, char s) throws Exception{
			if(s == '-'){
				return x1-x2;
			}else if(s == '+'){
				return x1+x2;
			}else if(s == '*'){
				return x1*x2;
			}else{
				throw new Exception();
			}
		}

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




	public List<String> addOperators2(String num, int target) {
		List<String> list = new ArrayList<>();
		dfs(0, 0, 0, 0, num, target, "", list);
		return list;
	}

	private void dfs(int deep, int val, int prev, int curr, String num, int target, String exp, List<String> list) {
		if(deep == num.length()) {
			if(val == target && curr == 0 && !exp.startsWith("-")) {
				list.add(exp);
			}
			return;
		}

		curr = curr * 10 + (num.charAt(deep) - '0');

		if(curr > 0) dfs(deep+1, val, prev, curr, num, target, exp, list);

		if(exp.equals("")) {

			// +
			dfs(deep+1, curr, curr, 0, num, target, "" + curr, list);

		} else {
			// +
			dfs(deep+1, val+curr, curr, 0, num, target, exp + "+" + curr, list);

			// -
			dfs(deep+1, val-curr, 0-curr, 0, num, target, exp + "-" + curr, list);

			// *
			dfs(deep+1, val-prev + (prev*curr), prev*curr, 0, num, target, exp + "*" + curr, list);
		}
	}


}
