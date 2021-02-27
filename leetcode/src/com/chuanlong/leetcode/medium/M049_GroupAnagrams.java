package com.chuanlong.leetcode.medium;

import java.util.*;

public class M049_GroupAnagrams {
    public static void main(String[] args) {
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++) {
            String str = strs[i];
            String sortedStr = sortString(str);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            } else {
                List<String> item = new ArrayList<>();
                item.add(str);
                map.put(sortedStr, item);
            }
        }
        return new ArrayList<>(map.values());
    }

    private String sortString(String str) {
        char[] chs = str.toCharArray();
//        Arrays.sort(chs);
        quickSort(chs, 0, chs.length-1);
        return new String(chs);
    }

    private void quickSort(char[] chs, int start, int end) {
        if (start >= end) {
            return;
        }

        char key = chs[start];
        int i = start, j = end;

        while(i<j) {
            while(i<j && chs[j]>=key) j--;
            chs[i] = chs[j];
            while(i<j && chs[i]<=key) i++;
            chs[j] = chs[i];
        }
        chs[i] = key;

        quickSort(chs, start, i-1);
        quickSort(chs, i+1, end);
    }

}
