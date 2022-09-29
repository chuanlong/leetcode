package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M658_FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = indexOfClosest(arr, x);
        int i,j;
        if(index == 0) {
            i=-1;
            j=1;
        } else if (index == arr.length) {
            i=arr.length-2;
            j=arr.length;
        } else {
            int start = compareClosest(arr[index-1], arr[index], x) <=0 ? index-1 : index;
            i=start-1;
            j=start+1;
        }
        while(j-i<k+1 && (i>=0 || j<arr.length)) {
            if(i==-1) j++;
            else if(j==arr.length) i--;
            else {
                if(compareClosest(arr[i], arr[j], x)<=0) i--;
                else j++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int c=i+1; c<j; c++) {
            list.add(arr[c]);
        }
        return list;
    }
    private int indexOfClosest(int[] arr, int x) {
        int s=0, e=arr.length-1;
        while(s<=e) {
            int m = (s+e)/2;
            if(arr[m] == x) return m;
            if(arr[m] < x) s=m+1;
            else e=m-1;
        }
        return s;
    }
    private int compareClosest(int a, int b, int x) {
        if(Math.abs(a-x) == Math.abs(b-x)) {
            if(a==b) return 0;
            else return a-b;
        }
        else return Math.abs(a-x) - Math.abs(b-x);
    }
}
