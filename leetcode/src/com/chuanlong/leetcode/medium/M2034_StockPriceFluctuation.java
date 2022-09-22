package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M2034_StockPriceFluctuation {
    class StockPrice {

        private List<Integer> list;
        private Map<Integer, Integer> map;
        private Integer cur;

        public StockPrice() {
            list = new ArrayList<>();
            map = new HashMap<>();
            cur = -1;
        }

        public void update(int timestamp, int price) {
            if(cur < timestamp) cur = timestamp;
            if(map.containsKey(timestamp)){
                int oldPrice = map.get(timestamp);
                list.remove(list.indexOf(oldPrice));
            }

            if(list.size() == 0 || price >= maximum()) {
                list.add(price);
            } else if (price <= minimum()) {
                list.add(0, price);
            } else {
                list.add(indexOfPrice(list, price, 0, list.size()-1), price);
            }


            map.put(timestamp, price);
            int x = 2;
        }

        public int current() {
            return map.get(cur);
        }

        public int maximum() {
            return list.get(list.size()-1);
        }

        public int minimum() {
            return list.get(0);
        }


        private int indexOfPrice(List<Integer> l, int newPrice, int s, int e) {
            if(s>=e) return s;

            int m = (s+e)/2;
            if(l.get(m) == newPrice) {
                return m;
            } else if(l.get(m) < newPrice) {
                return indexOfPrice(l, newPrice, m+1, e);
            } else {
                // newPrice < l.get(m);
                if(s==m || l.get(m-1) < newPrice) {
                    return m;
                } else {
                    return indexOfPrice(l, newPrice, s, m-1);
                }
            }
        }

    }

}
