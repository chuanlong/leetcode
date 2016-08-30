package com.chuanlong.leetcode.medium;

public class M055_JumpGame {

	/**
	 * https://leetcode.com/problems/jump-game/
	 */
	public static void main(String[] args) {

		M055_JumpGame obj = new M055_JumpGame();
		
		obj.canJump(new int[]{1,2,3});
		
	}
		
	
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length <= 1){
        	return true;
        }
        
        int reach = 0;
        for(int i=0; i<nums.length && i<=reach; i++){
        	reach = (i+nums[i]) > reach ? (i+nums[i]) : reach;
        	if(reach >= nums.length-1){
        		return true;
        	}
        }
        
        return reach >= nums.length-1;
    }

}
