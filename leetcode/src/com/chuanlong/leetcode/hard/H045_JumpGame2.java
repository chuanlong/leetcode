package com.chuanlong.leetcode.hard;

public class H045_JumpGame2 {

	/**
	 * https://leetcode.com/problems/jump-game-ii/
	 */
	public static void main(String[] args) {

		H045_JumpGame2 obj = new H045_JumpGame2();
		
		obj.jump(new int[]{2,3,1,1,4});
	}
	
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1){
        	return 0;
        }
    	
        int[] jumps = new int[nums.length];
        
        for(int i=0; i<nums.length; i++){
        	if(i+nums[i] >= nums.length-1){
        		return jumps[i]+1;
        	}else{
            	for(int j=i+nums[i]; j>i; j--){
            		if(jumps[j] == 0 || jumps[j] > (jumps[i]+1)){
            			jumps[j] = jumps[i] + 1;
            		}else{
            			break;
            		}
            	}
        	}
        }
        
    	return jumps[nums.length-1];
    }
	

}
