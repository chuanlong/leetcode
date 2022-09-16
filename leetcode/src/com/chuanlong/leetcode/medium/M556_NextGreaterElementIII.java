package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class M556_NextGreaterElementIII {

    public static void main(String[] args) {
        M556_NextGreaterElementIII obj = new M556_NextGreaterElementIII();

        System.out.println("Test1, expect:21, output:" + obj.nextGreaterElement(12));
    }


    public int nextGreaterElement(int n) {
        List<Integer> list = new ArrayList<>();
        int m=n;
        while(m>0) {
            list.add(0, m%10);
            m=m/10;
        }

        int index = list.size()-2;
        while(index>=0) {
            if(list.get(index) < list.get(index+1)) break;
            index--;
        }

        if(index == -1) return -1;

        List<Integer> start = list.subList(0, index);
        List<Integer> end = adjust(list.subList(index, list.size()));
        long x = 0;
        for(int i=0; i<start.size(); i++) {
            x = x*10 + start.get(i);
        }
        for(int i=0; i<end.size(); i++) {
            x = x*10 + end.get(i);
        }
        if(x > Integer.MAX_VALUE) return -1;
        return (int) x;
    }

    private List<Integer> adjust(List<Integer> list) {
        int start = indexOf(list);
        int[] array = new int[list.size()-1];
        for(int i=0; i<start; i++) {
            array[i] = list.get(i);
        }
        for(int i=start+1; i<list.size(); i++) {
            array[i-1] = list.get(i);
        }
        Arrays.sort(array);

        List<Integer> result = new ArrayList<>();
        result.add(list.get(start));
        for(int i=0; i<array.length; i++) {
            result.add(array[i]);
        }
        return result;
    }

    private int indexOf(List<Integer> list) {
        int start=1, end = 1;
        for(; end<list.size(); end++) {
            if(list.get(end)>list.get(0)) {
                start = end;
                break;
            }
        }
        for(int i=end+1; i<list.size(); i++) {
            if(list.get(i) > list.get(0) && list.get(i) < list.get(start)) {
                start = i;
            }
        }
        return start;
    }

}
