package com.chuanlong.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class E163_MissingRanges {

    public static void main(String[] args) {
        E163_MissingRanges obj = new E163_MissingRanges();

        System.out.println("Test1, [0,1,3,50,75], 0, 99, expect:" + "[2,4->49,51->74,76->99]"
                + ", result:" + obj.findMissingRanges(new int[]{0,1,3,50,75}, 0, 99));


    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<int[]> list = new ArrayList<>();
        int index = 0;
        int start = lower;
        while(index < nums.length) {
            if(start < nums[index]) {
                list.add(new int[]{start, nums[index]-1});
            }
            start = nums[index]+1;
            index++;
        }
        if(start <= upper) {
            list.add(new int[]{start, upper});
        }

        List<String> result = new ArrayList<>();
        for(int i=0; i<list.size(); i++) {
            int[] item = list.get(i);
            if(item[0] == item[1]) {
                result.add(item[0] + "");
            } else {
                result.add(item[0] + "->" + item[1]);
            }
        }
        return result;
    }

}
