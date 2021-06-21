package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class E1296_DivideArrayInSetsOfKConsecutiveNumbers {

    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0) {
            return false;
        }
        Arrays.sort(nums);

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        int n = list.size() / k;
        for(int i=0; i<n; i++) {
            int start = list.get(0);
            for(int j=0; j<k; j++) {
                int index = list.indexOf(start);
                if(index >= 0) {
                    list.remove(index);
                    start++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private void quickSort(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }

        int key = nums[start];
        int i = start;
        int j = end;
        while(i<j) {
            while(i<j && nums[j] >= key) j--;
            nums[i] = nums[j];
            while(i<j && nums[i] <= key) i++;
            nums[j] = nums[i];
        }
        nums[i] = key;

        quickSort(nums, start, i-1);
        quickSort(nums, i+1, end);
    }

}
