package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M2336_Smallest_NumberInInfiniteSet {

    class SmallestInfiniteSet {
        private List<Integer> list;

        public SmallestInfiniteSet() {
            list = new ArrayList<>();
            list.add(1);
        }

        public int popSmallest() {
            int x = list.remove(0);
            if(list.size() == 0) {
                list.add(x+1);
            }
            return x;
        }

        public void addBack(int num) {
            int index = findFirstIndexLargerThan(list, num, 0, list.size()-1);
            if(index != -1) {
                list.add(index, num);
            }
        }

        private int findFirstIndexLargerThan(List<Integer> list, int value, int x, int y) {
            if(x > y) return -1;
            if(x == y) {
                if(list.get(x) <= value) return -1;
                else return x;
            }
            int mid = (x+y)/2;
            if(list.get(mid) == value) {
                return -1;
            } else if(list.get(mid) < value) {
                return findFirstIndexLargerThan(list, value, mid+1, y);
            } else {
                if(mid==x || (list.get(mid-1) < value)) {
                    return mid;
                } else {
                    return findFirstIndexLargerThan(list, value, x, mid-1);
                }
            }
        }
    }


}
