package com.chuanlong.leetcode.medium;

import java.util.*;

public class M981_TimeBasedKeyValueStore {



    class TimeMap {

        private Map<String, TreeMap<Integer, String>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if(!map.containsKey(key)) map.put(key, new TreeMap<>());
            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if(!map.containsKey(key)) return "";

            // TreeMap<Integer, String> set = map.get(key);
            // List<Integer> keys = new ArrayList<>(set.keySet());
            // int index = indexOf(keys, timestamp);
            // if(index == -1) return "";
            // else return set.get(keys.get(index));

            Integer floorKey = map.get(key).floorKey(timestamp);
            if(floorKey == null) return "";
            else return map.get(key).get(floorKey);
        }


        // private int indexOf(List<Integer> list, int value) {
        //     int s=0, e=list.size()-1;
        //     while(s<e) {
        //         int m = (s+e)/2;
        //         if(list.get(m) == value) return m;
        //         else if(list.get(m)<value) {
        //             if(list.get(m+1)>value) {
        //                 return m;
        //             } else {
        //                 s=m+1;
        //             }
        //         } else {
        //             // list.get(m) > value
        //             e=m;
        //         }
        //     }
        //     if(list.get(s) > value) return -1;
        //     else return s;
        // }

    }

    class TimeMap2 {

        private Map<String, TreeMap<Integer, String>> map;

        public TimeMap2() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if(!map.containsKey(key)) map.put(key, new TreeMap<>());
            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if(!map.containsKey(key)) return "";

            TreeMap<Integer, String> set = map.get(key);
            int index = indexOf(new ArrayList<>(set.keySet()), timestamp);
            return set.get(index);
        }


        private int indexOf(List<Integer> list, int value) {
            int s=0, e=list.size()-1;
            while(s<e) {
                int m = (s+e)/2;
                if(list.get(m) == value) return m;
                else if(list.get(m)<value) {
                    if(m+1<=e && list.get(m+1)>value) {
                        return m;
                    } else {
                        s=m+1;
                    }
                } else {
                    // list.get(m) > value
                    e=m;
                }
            }
            return s;
        }

    }

}
