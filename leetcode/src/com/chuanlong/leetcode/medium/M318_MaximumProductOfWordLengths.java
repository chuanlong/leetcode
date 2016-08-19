package com.chuanlong.leetcode.medium;

public class M318_MaximumProductOfWordLengths {

	/**
	 * https://leetcode.com/problems/maximum-product-of-word-lengths/
	 */
	public static void main(String[] args) {
		
		M318_MaximumProductOfWordLengths obj = new M318_MaximumProductOfWordLengths();
		
		System.out.println("['abcw', 'baz', 'foo', 'bar', 'xtfn', 'abcdef'] -> 16, result:"
				+ obj.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
		
		System.out.println("['a','ab','abc','d','cd','bcd','abcd'] -> 4, result:"
				+ obj.maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}));
		
	}
	
    public int maxProduct(String[] words) {
    	quickSort(words);

    	int maxI = words.length;
    	int maxJ = words.length;
    	int max = 0;
    	for(int i=0; i<words.length; i++){
    		for(int j=i+1; j<words.length && j<maxJ; j++){
    			if(!isShare(words[i], words[j]) 
    					&& words[i].length() * words[j].length() > max){
    				max = words[i].length() * words[j].length();
    				maxI = i;
    				maxJ = j;
    			}
    		}
    	}
    	
    	return max;
    }
    
    
    private void quickSort(String[] words){
    	if(words == null || words.length == 0){
    		return;
    	}
    	
    	for(int i=0; i<words.length; i++){
    		for(int j=i+1; j<words.length; j++){
    			if(words[i].length() < words[j].length()){
    				String temp = words[i];
    				words[i] = words[j];
    				words[j] = temp;
    			}
    		}
    	}
    }
    
    private boolean isShare(String x, String y){
    	if(x == null || y == null){
    		return false;
    	}
    	
    	char[] xx = x.toCharArray();
    	char[] yy = y.toCharArray();
    	
    	for(int i=0; i<xx.length; i++){
    		for(int j=0; j<yy.length; j++){
    			if(xx[i] == yy[j]){
    				return true;
    			}
    		}
    	}
    	
    	return false;
    }
    

}
