package com.chuanlong.leetcode.medium;

import javafx.util.Pair;

import java.util.*;

public class M692_TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++) {
            int count = map.getOrDefault(words[i], 0);
            map.put(words[i], count+1);
        }

        TreeSet<Pair<Integer, String>> set = new TreeSet<Pair<Integer, String>>((a,b) ->{
            if(a.getKey() == b.getKey()) {
                return 0 - a.getValue().compareTo(b.getValue());
            } else {
                return a.getKey().compareTo(b.getKey());
            }
        });
        for(String key : map.keySet()) {
            if(set.size() < k) {
                set.add(new Pair<>(map.get(key), key));
            } else {
                Pair<Integer, String> min = set.first();
                if(map.get(key) > min.getKey() || (map.get(key)==min.getKey() && (key.compareTo(min.getValue()) < 0))) {
                    set.remove(min);
                    set.add(new Pair<>(map.get(key), key));
                }
            }
        }

        List<String> list = new ArrayList<>();
        for(Pair<Integer, String> pair : set) {
            list.add(0, pair.getValue());
        }
        return list;
    }

}
