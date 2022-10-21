package com.chuanlong.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E1200_MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i=1; i<arr.length; i++) {
            if(arr[i]-arr[i-1] < min) {
                result.clear();
                result.add(Arrays.asList(arr[i-1], arr[i]));
                min = arr[i]-arr[i-1];
            } else if (arr[i]-arr[i-1] == min) {
                result.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }
        return result;
    }

}
