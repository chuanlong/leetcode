package com.chuanlong.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCollections {

    public static void main(String[] args) {
        TestCollections obj = new TestCollections();

        obj.test1();
        obj.test2();
    }

    public void test1() {
        int[] array = new int[]{1,3,5,7,9,11,13,15,17,19};

        System.out.println("Test1, expect:0, output:" + Arrays.binarySearch(array, 1));
        System.out.println("Test2, expect:-2, output:" + Arrays.binarySearch(array, 2));
        System.out.println("Test3, expect:-11, output:" + Arrays.binarySearch(array, 20));
        System.out.println("Test4, expect:-1, output:" + Arrays.binarySearch(array, -1));
    }

    public void test2() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,3,5,7,9,11,13,15,17,19));
        insert(list, 1);
        insert(list, 1);
        insert(list, 1);
        insert(list, 2);
        insert(list, 20);
        insert(list, -1);

        System.out.println("Test22, expect:[xxx], output:" + list);
    }

    private void insert(List<Integer> list, int value) {
        int index = Collections.binarySearch(list, value);
        if(index >= 0) list.add(index, value);
        else list.add(0-index-1, value);
    }

}
