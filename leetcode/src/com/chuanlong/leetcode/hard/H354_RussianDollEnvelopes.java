package com.chuanlong.leetcode.hard;


public class H354_RussianDollEnvelopes {

	/**
	 * https://leetcode.com/problems/russian-doll-envelopes/
	 */
	public static void main(String[] args) {

		H354_RussianDollEnvelopes obj = new H354_RussianDollEnvelopes();
		
//		obj.maxEnvelopes(new int[][]{{5,4}, {6,4}, {6,7}, {2,3}});
//		obj.maxEnvelopes(new int[][]{{1,1}, {1,1}, {1,1}});
		obj.maxEnvelopes(new int[][]{{10,8}, {1,12}, {6,15}, {2,18}});
				
	}
	
	public int maxEnvelopes(int[][] envelopes) {
    	if(envelopes.length > 0){
    		int n = envelopes.length;
        	quickSort(envelopes, 0, n-1);
        	int[] max = new int[n];
        	
        	for(int i=0; i<n; i++){
        	    max[i] = 1;
        		for(int j=i-1; j>=0; j--){
        			if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
        				max[i] = Math.max(max[i], max[j]+1);
        			}
        		}
        	}
    		
        	int max1 = 0;
        	for(int i=0; i<n; i++){
        		max1 = Math.max(max1, max[i]);
        	}
        	return max1;
    	}else{
    		return 0;
    	}
    }
    
    
    private void quickSort(int[][] nums, int start, int end){
    	if(start < end){
    		int[] key = nums[start];
    		int i=start, j=end;
    		while(i < j){
    			while(i < j && compare(nums[j], key) >= 0) j--;
    			nums[i] = nums[j];
    			while(i < j && compare(nums[i], key) <= 0) i++;
    			nums[j] = nums[i];
    		}
    		nums[i] = key;
    		
    		quickSort(nums, start, i-1);
    		quickSort(nums, i+1, end);
    	}
    }
    
    // 1 a1>a2, 0 a1=a2, -1 a1<a2
    private int compare(int[] a1, int[] a2){
    	if(a1[0] == a2[0] && a1[1] == a2[1]){
    		return 0;
    	}else if(a1[0] > a2[0] || (a1[0] == a2[0] && a1[1] > a2[1])){
    		return 1;
    	}else{
    		return -1;
    	}
    }

}
