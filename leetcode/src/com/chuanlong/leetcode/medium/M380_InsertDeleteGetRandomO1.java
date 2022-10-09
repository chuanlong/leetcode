package com.chuanlong.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class M380_InsertDeleteGetRandomO1 {

    class RandomizedSet {

        private Random rand;
        private Map<Integer, Integer> map;
        private int[] array;
        private int size;

        public RandomizedSet() {
            this.rand = new Random();
            this.map = new HashMap<>();
            this.array = new int[200000];
            int size = 0;
        }

        public boolean insert(int val) {
            if(map.containsKey(val)) return false;
            int index = size++;
            array[index] = val;
            map.put(val, index);
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)) return false;
            int index = map.get(val);
            map.remove(val);
            if(index == size-1) {
                size--;
            } else {
                int newVal = array[--size];
                map.put(newVal, index);
                array[index] = newVal;
            }
            return true;
        }

        public int getRandom() {
            int randIndex = rand.nextInt(size);
            return array[randIndex];
        }
    }

}
