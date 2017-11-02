package com.chuanlong.leetcode.medium;

public class M033_SearchInRotatedSortedArray {

	public static void main(String[] args) {

		M033_SearchInRotatedSortedArray obj = new M033_SearchInRotatedSortedArray();
		
		int[] nums1 = new int[]{4,5,6,7,0,1,2};
		int[] nums2 = new int[]{3,4,5,6,1,2};
		
//		int index1 = obj.search(nums1, 5);
//		System.out.println("[4,5,6,7,0,1,2], 5 ->" + index1);

		int index2 = obj.search(nums2, 2);
		System.out.println("[3,4,5,6,1,2], 2 ->" + index2);
		
	}
	
    public int search(int[] nums, int target) {
    	if (nums == null || nums.length == 0){
    		return -1;
    	}
        return search(nums, 0, nums.length-1, target);
    }
    
    public int search(int[] nums, int start, int end, int target){
    	if(start > end){
    		return -1;
    	}
    	int middle = (start+end) / 2;
    	if(nums[middle] == target){
    		return middle;
    	}else if(start <= middle-1
    			&& nums[start] <= nums[middle-1]
    			&& nums[start] <= target 
    			&& target <= nums[middle-1]){
    		return search(nums, start, middle-1, target);
    	}else if(start <= middle-1
    			&& nums[start] > nums[middle-1]
    			&& (nums[start] <= target || nums[middle-1] >= target)){
    		return search(nums, start, middle-1, target);
    	}else if(middle+1 <= end
    			&& nums[middle+1] <= nums[end]
    			&& nums[middle+1] <= target 
    			&& target <= nums[end]){
    		return search(nums, middle+1, end, target);
    	}else if(middle+1 <= end
    			&& nums[middle+1] > nums[end]
    			&& (nums[middle+1] <= target || nums[end] >= target)){
    		return search(nums, middle+1, end, target);
    	}
    	
    	return -1;
    }

}
