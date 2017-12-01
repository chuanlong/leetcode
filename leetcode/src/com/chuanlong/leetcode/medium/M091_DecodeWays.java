package com.chuanlong.leetcode.medium;

public class M091_DecodeWays {

	/**
	 * https://leetcode.com/problems/decode-ways/
	 */
	public static void main(String[] args) {

		M091_DecodeWays obj = new M091_DecodeWays();
		
		System.out.println("12 -> 2, result:" + obj.numDecodings("12"));
		System.out.println("120 -> 1, result:" + obj.numDecodings("120"));		
		System.out.println("0 -> 0, result:" + obj.numDecodings("0"));				
		System.out.println("7541387519572282368613553811323167125532172369624572591562685959575371877973171856836975137559677665 -> 1769472, result:" + obj.numDecodings("7541387519572282368613553811323167125532172369624572591562685959575371877973171856836975137559677665"));	
		
	}
	
    public int numDecodings1(String s) {
    	if(s == null || s.length() == 0){
    		return 0;
    	}
    	
    	char[] tokens = s.toCharArray();
    	
    	return numDecodings(tokens, 0, tokens.length-1);
    }
    
    public int numDecodings(char[] tokens, int start, int end){
    	
    	if(start >= 0 && start <= end && end < tokens.length){
    		if(start == end){
    			// 1 letter
    			if(tokens[start] >= '1' && tokens[start] <= '9'){
    				return 1;
    			}else{
    				return 0;
    			}
    		}else{
    			// 2 letter or more
    			if((tokens[start] == '1' && tokens[start+1] >= '0' && tokens[start+1] <= '9') 
    					|| (tokens[start] == '2' && tokens[start+1] >= '0' && tokens[start+1] <= '6')){
    				int num = numDecodings(tokens, start+1, end);
    				
    				if(start+1 == end){
    					// 2 letter
    					num += 1;
    				}else{
    					num += numDecodings(tokens, start+2, end);
    				}
    				return num;
    			}else if(tokens[start] >= '1' && tokens[start] <= '9'){
    				return numDecodings(tokens, start+1, end);
    			}else{
    				return 0;
    			}
    		}    		
    	}
    	
    	return 0;
    }
    
    
    public int numDecodings(String s){
    	if(s == null || s.length() == 0){
    		return 0;
    	}
    	
    	char[] tokens = s.toCharArray();
    	int[] nums = new int[tokens.length+1];
    	
//    	for(int i=tokens.length-1; i>=0; i--){
//    		if(i == tokens.length-1){
//    			if(tokens[i] >= '1' && tokens[i] <= '9'){
//    				nums[i] = 1;
//    			}else{
//    				nums[i] = 0;
//    			}
//    		}else if(i == tokens.length-2){
//    			if((tokens[i] == '1' && tokens[i+1] >= '0' && tokens[i+1] <= '9')
//    					|| (tokens[i] == '2' && tokens[i+1] >= '0' && tokens[i+1] <= '6') ){
//    				nums[i] = nums[i+1] + 1;
//    			}else if(tokens[i] >= '1' && tokens[i] <= '9'){
//    				nums[i] = nums[i+1];
//    			}else{
//    				nums[i] = 0;
//    			}
//    		}else{
//    			if((tokens[i] == '1' && tokens[i+1] >= '0' && tokens[i+1] <= '9')
//    					|| (tokens[i] == '2' && tokens[i+1] >= '0' && tokens[i+1] <= '6') ){
//    				nums[i] = nums[i+1] + nums[i+2];
//    			}else if(tokens[i] >= '1' && tokens[i] <= '9'){
//    				nums[i] = nums[i+1];
//    			}else{
//    				nums[i] = 0;
//    			}
//    		}
//    	}   
    	
    	nums[tokens.length] = 1;
    	for(int i=tokens.length-1; i>=0; i--){
    		if((tokens[i] == '1' && i+1 < tokens.length && tokens[i+1] >= '0' && tokens[i+1] <= '9')
    					|| (tokens[i] == '2' && i+1 < tokens.length && tokens[i+1] >= '0' && tokens[i+1] <= '6') ){
    			nums[i] = nums[i+1] + nums[i+2];
    		}else if(tokens[i] >= '1' && tokens[i] <= '9'){
    			nums[i] = nums[i+1];
    		}else{
    			nums[i] = 0;
    		}
    	}   
    	
    	return nums[0];
    }
    

    public int numDecodings2(String s) {
        if(s == null || s.length() == 0){
        	return 0;
        }
        
        char[] tokens = s.toCharArray();
        int n = tokens.length;
        
        // check format
        for(int i=0; i<n; i++){
        	if(tokens[i] < '0' || tokens[i] > '9'){
        		return 0;
        	}
        }
        
        int[] nums = new int[n];
        if(tokens[n-1] > '0'){
    		nums[n-1] = 1;
    	}else{
    		nums[n-1] = 0;
    	}
        if(n>=2){
        	if(tokens[n-2] > '2'){
        		nums[n-2] = nums[n-1];
        	}else if(tokens[n-2] == '2'){
        		if(tokens[n-1] >= '0' && tokens[n-1] <= '6'){
        			nums[n-2] = nums[n-1] + 1;
        		}else{
        			nums[n-2] = nums[n-1];
        		}
        	}else if(tokens[n-2] == '1'){
        		nums[n-2] = nums[n-1] + 1;
        	}else{
        		nums[n-2] = 0;
        	}
        	
        	for(int i=n-3; i>=0; i--){
        		if(tokens[i] > '2'){
        			nums[i] = nums[i+1];
        		}else if(tokens[i] == '2'){
        			if(tokens[i+1] >= '0' && tokens[i+1] <= '6'){
        				nums[i] = nums[i+1] + nums[i+2];
        			}else{
        				nums[i] = nums[i+1];
        			}
        		}else if(tokens[i] == '1'){
        			nums[i] = nums[i+1] + nums[i+2];
        		}else{
        			nums[i] = 0;
        		}
        	}	
        }
    	return nums[0];
    }
    
    
    
    public int numDecodings3(String s) {
        if(s == null || s.length() == 0){
        	return 0;
        }
        
        int n = s.length();
        int[] f = new int[n+2];
        f[n+1] = 0;
        f[n] = 1;
        
        for(int i=n-1; i>=0; i--){
        	char ch = s.charAt(i);
        	if(ch == '1'){
        		if(f[i+2] > 0){
                	f[i] = f[i+1] + f[i+2];
        		}else{
        			f[i] = f[i+1];
        		}
        	}else if(ch == '2'){
        		if(f[i+2] > 0 && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '6'){
            		f[i] = f[i+1] + f[i+2];
        		}else{
        			f[i] = f[i+1];
        		}
        	}else if(ch >= '3' && ch <= '9'){
        		f[i] = f[i+1];
        	}else if(ch == '0'){
        		f[i] = 0;
        	}else{
        		f[i] = 0;
        	}
        }
    	return f[0];
    }
    
    
}
