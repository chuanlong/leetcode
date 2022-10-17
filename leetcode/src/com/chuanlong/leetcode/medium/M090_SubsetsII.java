package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M090_SubsetsII {

	public static void main(String[] args) {

	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : nums) {
			int cnt = map.getOrDefault(num, 0);
			map.put(num, cnt+1);
		}
		List<Integer> keys = new ArrayList<>(map.keySet());

		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		backtrack(keys, map, 0, new ArrayList<>(), result);
		return result;
	}

	private void backtrack(List<Integer> keys, Map<Integer, Integer> map, int index, List<Integer> item, List<List<Integer>> result) {
		if(index >= keys.size()) return;
		backtrack(keys, map, index+1, item, result);
		int key = keys.get(index);
		int cnt = map.get(key);
		for(int i=1; i<=cnt; i++) {
			item.add(key);
			result.add(new ArrayList<>(item));
			backtrack(keys, map, index+1, item, result);
		}
		for(int i=1; i<=cnt; i++) item.remove(item.size()-1);
	}
	
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
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
        	for(Integer key : map.keySet()){
        		Integer count = map.get(key);
            	List<List<Integer>> newList = new ArrayList<List<Integer>>();
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
