package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M046_Permutations {

    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), all);
        return all;
    }

    private void backtrack(int[] nums, List<Integer> list, List<List<Integer>> all) {
        if(list.size() == nums.length) {
            all.add(new ArrayList<>(list));
            return;
        }

        int k = list.size();
        int num = nums[k];
        for(int i=0; i<k+1; i++) {
            list.add(i, num);
            backtrack(nums, list, all);
            list.remove(i);
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return list;
        }

        if (nums.length == 1) {
            List<Integer> subList = new ArrayList<>();
            subList.add(nums[0]);
            list.add(subList);
            return list;
        }

        for(int i=0; i<nums.length; i++) {
            int x = nums[i];
            int[] subNums = subArray2(i, nums);
            List<List<Integer>> subPermute = permute2(subNums);
            for(int j=0; j<subPermute.size(); j++) {
                List<Integer> item = subPermute.get(j);
                item.add(0, x);
                list.add(item);
            }
        }

        return list;
    }

    private int[] subArray2(int index, int[] nums) {
        int[] subNums = new int[nums.length-1];
        for(int i=0, j=0; i<nums.length; i++) {
            if(i!=index) {
                subNums[j++] = nums[i];
            }
        }
        return subNums;
    }



}
