package com.chuanlong.leetcode.medium;


public class M179_LargestNumber {

	/**
	 * https://leetcode.com/problems/largest-number/
	 * */
	public static void main(String[] args) {
		
		M179_LargestNumber obj = new M179_LargestNumber();
		
		System.out.println("[3, 30, 34, 5, 9] -> 9534330, result:" + obj.largestNumber(new int[]{3, 30, 34, 5, 9}));
		System.out.println("[0,0] -> 0, result:" + obj.largestNumber(new int[]{0, 0}));
	
		System.out.println("[824,938,1399,5607,6973,5703,9609,4398,8247] -> \n"
				+ "9609938824824769735703560743981399, -> \n" 
				+ obj.largestNumber(new int[]{824,938,1399,5607,6973,5703,9609,4398,8247}));
	
		System.out.println("[12,121] -> 12121, result:" + obj.largestNumber(new int[]{12, 121}));
		
	}
	
	
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
        	return "";
        }
        
        for(int i=0; i<nums.length; i++){
        	for(int j=i+1; j<nums.length; j++){
        		if(!compare1(nums[i], nums[j])){
        			int t = nums[i];
        			nums[i] = nums[j];
        			nums[j] = t;
        		}
        	}
        }
    	
        String token = "";
        if(nums[0] == 0){
        	token = "0";
        }else{
            for(int i=0; i<nums.length; i++){
            	token += nums[i];
            }
        }
    	
    	return token;
    }
    
    /**
     * true  x is before y, x is larger than y
     * false x is after  y, x is smaller or equal than y 
     * */
    public boolean compare1(int x, int y){
    	String xx = x + "" + y;
    	String yy = y + "" + x;
    	
    	for(int i=0; i<xx.length(); i++){
        	int x1 = Integer.parseInt(xx.substring(i, i+1));
        	int y1 = Integer.parseInt(yy.substring(i, i+1));
    		
    		if(x1 > y1){
    			return true;
    		}else if(x1 < y1){
    			return false;
    		}else{
    			// x1 equal y1
    		}
    	}
    	
    	return false;
    }
    
    /**
     * true  x is before y, x is larger than y
     * false x is after  y, x is smaller or equal than y 
     * */
    public boolean compare(int x, int y){
    	String xx = x+"";
    	String yy = y+"";
    	
    	int leastCommonMultiple = getLeastCommonMultiple(xx.length(), yy.length());
    	while(xx.length() < leastCommonMultiple){
    		xx = xx + x;
    	}
    	while(yy.length() < leastCommonMultiple){
    		yy = yy + y;
    	}
    	
    	for(int i=0; i<leastCommonMultiple; i++){
        	int x1 = Integer.parseInt(xx.substring(i, i+1));
        	int y1 = Integer.parseInt(yy.substring(i, i+1));
    		
    		if(x1 > y1){
    			return true;
    		}else if(x1 < y1){
    			return false;
    		}else{
    			// x1 equal y1
    		}
    	}
    	
    	return false;
    }
    
    /**
     * get the least common multiple of x and y
     * x=4, y=6, output 12
     * */
    public int getLeastCommonMultiple(int x, int y){
    	if(x > y){
    		int temp = x;
    		x = y;
    		y = temp;
    	}
    	
    	// x < y
    	for(int i=y; i<=x*y; i++){
    		if(i%x==0 && i%y==0){
    			return i;
    		}
    	}
    	return x*y;
    }


}
