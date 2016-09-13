package com.chuanlong.leetcode.medium;

public class M167_TwoSum2 {

	/**
	 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
	 */
	public static void main(String[] args) {

		M167_TwoSum2 obj = new M167_TwoSum2();
		
		obj.twoSum(new int[]{2,3,4}, 6);
		
	}
	
    public int[] twoSum(int[] numbers, int target) {
        
    	for(int i=0; i<numbers.length; i++){
    		if(target - numbers[i] >= 0){
    			int j = search(numbers, target-numbers[i], i+1, numbers.length-1);
    			if(j != -1){
    				return new int[]{i+1, j+1};
    			}
    		}else{
    			break;
    		}
    	}

    	return new int[]{0, 0};
    }
    
    
    private int search(int[] numbers, int val, int start, int end){
  	
    	while(start < end){
    		int mid = (start+end) / 2;
    		
    		if(numbers[mid] == val){
    			return mid;
    		}else if(numbers[mid] > val){
    			end = mid-1;
    		}else{
    			start = mid+1;
    		}
    	}
    	
    	if(start == end){
    		if(numbers[start] == val){
    			return start;
    		}else{
    			return -1;
    		}
    	}else{
    		return -1;
    	}
    	
    }

}
