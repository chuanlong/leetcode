package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M090_SubsetsII {

	public static void main(String[] args) {

	}
	
	
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if(nums != null && nums.length > 0){
        	for(int i=0; i<nums.length; i++){
        		if(map.containsKey(nums[i])){
        			map.put(nums[i], map.get(nums[i])+1);
        		}else{
        			map.put(nums[i], 1);
        		}
        	}
        }
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(new ArrayList<Integer>());
        if(map.keySet().size() > 0){
        	List<List<Integer>> newList = new ArrayList<List<Integer>>();
        	for(Integer key : map.keySet()){
        		Integer count = map.get(key);
        		for(int i=0; i<=count; i++) {
        			for(int j=0; j<list.size(); j++){
        				List<Integer> newItem = new ArrayList<Integer>(list.get(j));
        				for(int k=0; k<i; k++){
        					newItem.add(key);
        				}
        				newList.add(newItem);
        			}
        		}
            	list = newList;
        	}
        }
        return list;
    }
    
    

}
