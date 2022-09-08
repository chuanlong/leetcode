package com.chuanlong.leetcode.medium;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class M2369_CheckIfThereIsAValidPartitionForTheArray {

    public boolean validPartition(int[] nums) {
        return validPartition(nums, 0, nums.length-1, new HashMap<Pair, Boolean>());
    }

    private boolean validPartition(int[] nums, int i, int j, Map<Pair, Boolean> map) {
        Pair point = new Pair(i,j);
        if(map.containsKey(point)) return map.get(point);

        if(j-i < 1) {
            return false;
        } else if (j-i == 1) {
            if(nums[i] == nums[j]) {
                return true;
            } else {
                return false;
            }
        } else if (j-i == 2) {
            if(nums[i] == nums[i+1] && nums[i+1] == nums[j]) {
                return true;
            } else if (nums[i+1]-nums[i] == 1 && nums[j] - nums[i+1] == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            if(nums[i] == nums[i+1]) {
                if(validPartition(nums, i+2, j, map)) {
                    map.put(point, true);
                    return true;
                }
            }
            if((nums[i] == nums[i+1] && nums[i+1] == nums[i+2])
                    || (nums[i+1]-nums[i]==1 && nums[i+2]-nums[i+1]==1)) {
                if(validPartition(nums, i+3, j, map)) {
                    map.put(point, true);
                    return true;
                }
            }

            map.put(point, false);
            return false;
        }
    }

}
