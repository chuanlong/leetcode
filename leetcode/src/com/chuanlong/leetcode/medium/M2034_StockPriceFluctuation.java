package com.chuanlong.leetcode.medium;

import java.util.*;

public class M2034_StockPriceFluctuation {
    class StockPrice {

        private TreeMap<Integer, Integer> prices;
        private Map<Integer, Integer> map;
        private int cur;

        public StockPrice() {
            prices = new TreeMap<>();
            map = new HashMap<>();
            cur = -1;
        }

        public void update(int timestamp, int price) {
            if(cur < timestamp) cur = timestamp;
            if(map.containsKey(timestamp)){
                int oldPrice = map.get(timestamp);
                int cnt = prices.get(oldPrice);
                if(cnt == 1) {
                    prices.remove(oldPrice);
                } else {
                    prices.put(oldPrice, cnt-1);
                }
            }

            prices.put(price, prices.getOrDefault(price, 0)+1);

            map.put(timestamp, price);
        }

        public int current() {
            return map.get(cur);
        }

        public int maximum() {
            return prices.lastKey();
        }

        public int minimum() {
            return prices.firstKey();
        }
    }

}
