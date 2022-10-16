package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> list, List<List<Integer>> result) {
        if(i >= nums.length) return;
        backtrack(nums, i+1, list, result);
        list.add(nums[i]);
        result.add(copy(list));
        backtrack(nums, i+1, list, result);
        list.remove(list.size()-1);
    }

    private List<Integer> copy(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        newList.addAll(list);
        return newList;
    }
}
