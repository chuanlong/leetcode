package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M1352_ProductOfTheLastKNumbers {

    class ProductOfNumbers {

        private List<Integer> products;

        public ProductOfNumbers() {
            products = new ArrayList<>();
        }

        public void add(int num) {
            if(num == 0) {
                products.clear();
            } else {
                if(products.size() == 0) {
                    products.add(num);
                } else {
                    products.add(products.get(products.size()-1) * num);
                }
            }
        }

        public int getProduct(int k) {
            if(k > products.size()) return 0;
            if(k == products.size()) return products.get(products.size()-1);
            return products.get(products.size()-1) / products.get(products.size()-k-1);
        }
    }
    
}
