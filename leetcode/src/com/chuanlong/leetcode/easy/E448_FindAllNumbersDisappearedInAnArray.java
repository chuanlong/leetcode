package com.chuanlong.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E448_FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], true);
        }
        for(int i=1; i<nums.length+1; i++) {
            if(!map.containsKey(i)) {
                list.add(i);
            }
        }
        return list;
    }


}
