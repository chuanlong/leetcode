package com.chuanlong.leetcode.easy;

public class E2418_SortThePeople {
    public String[] sortPeople(String[] names, int[] heights) {
        sort(names, heights, 0, heights.length-1);
        return names;
    }

    // sort descending
    private void sort(String[] names, int[] heights, int s, int e) {
        if(s>=e) return;

        int key = heights[s];
        String name = names[s];
        int i=s, j=e;
        while(i<j) {
            while(i<j && heights[j] <= key) j--;
            if(i<j) {
                heights[i] = heights[j];
                names[i] = names[j];
                i++;
            }
            while(i<j && heights[i] >= key) i++;
            if(i<j) {
                heights[j] = heights[i];
                names[j] = names[i];
                j--;
            }
        }
        heights[i] = key;
        names[i] = name;
        sort(names, heights, s, i-1);
        sort(names, heights, i+1, e);
    }

}
