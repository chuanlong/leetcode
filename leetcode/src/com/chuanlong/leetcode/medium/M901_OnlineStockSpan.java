package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M901_OnlineStockSpan {
    class StockSpanner {

        List<Integer> prices;
        List<Integer> spans;
        int size;

        public StockSpanner() {
            prices = new ArrayList<>();
            spans = new ArrayList<>();
            size = 0;
        }

        public int next(int price) {
            if(size == 0) {
                spans.add(1);
                prices.add(price);
                size = 1;
                return 1;
            }

            spans.add(getSpan(price)+1);
            prices.add(price);
            return spans.get(size++);
        }

        private int getSpan(int price) {
            int index = size-1;
            while(index >= 0 && prices.get(index) <= price) {
                index = index - spans.get(index);
            }

            if(index < 0) return size;
            return size-index-1;
        }

    }
}
