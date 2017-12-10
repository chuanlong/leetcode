package com.chuanlong.leetcode;

public class H010_RegularExpressionMatching {

	public static void main(String[] args) {
		H010_RegularExpressionMatching obj = new H010_RegularExpressionMatching();
		obj.isMatch("aab", "*a*b");
	}
	
	// TODO
    public boolean isMatch(String s, String p) {
    	if(s == null || p == null){
    		return false;
    	}

    	int m = p.length();
    	int n = s.length();
    	char[] chs1 = p.toCharArray();
    	char[] chs2 = s.toCharArray();
    	
    	boolean dp[][] = new boolean[m+1][n+1];
    	dp[0][0] = true;
    	for(int j=1; j<n+1; j++){
    		dp[0][j] = false;
    	}
    	for(int i=1; i<m+1; i++){
    		dp[i][0] = dp[i-1][0] && (chs1[i-1] == '*' || chs1[i-1] == '.');
    	}
    	
    	for(int i=1; i<m+1; i++){
    		for(int j=1; j<n+1; j++){
    			if(chs1[i-1] == '*'){
    				dp[i][j] = dp[i][j-1] || dp[i-1][j];
    			}else if(chs1[i-1] == '.'){
    				dp[i][j] = dp[i-1][j-1];
    			}else{
    				if(chs1[i-1] == chs2[j-1]){
    					dp[i][j] = dp[i-1][j-1];
    				}else{
    					dp[i][j] = false;
    				}
    			}
    		}
    	}
    	
    	return dp[m][n];
    }
    

}
