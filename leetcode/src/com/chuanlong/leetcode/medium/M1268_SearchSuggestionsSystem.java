package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M1268_SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        MyChar root = new MyChar('_', false);
        for(int i=0; i<products.length; i++) {
            String prod = products[i];
            MyChar current = root;
            for(int j=0; j<prod.length(); j++) {
                char ch = prod.charAt(j);
                current = current.add(ch, (j==prod.length()-1) ? true : false);
            }
        }

        List<List<String>> list = new ArrayList<>();
        String prefix = "";
        MyChar current = root;
        for(int i=0; i<searchWord.length(); i++) {
            char ch = searchWord.charAt(i);
            List<String> top3 = new ArrayList<>();
            if(current != null) {
                current = current.get(ch);
                if(current != null) getFirst3(prefix, current, top3);
                prefix = prefix + ch;
            }
            list.add(top3);
        }

        return list;
    }

    private void getFirst3(String prefix, MyChar myChar, List<String> top3) {
        if(top3.size() == 3) return;
        if(myChar.isLeaf) {
            top3.add(prefix+myChar.ch);
            if(top3.size() == 3) return;
        }

        for(int i=0; i<26; i++) {
            if(myChar.array[i] != null) getFirst3(prefix+myChar.ch, myChar.array[i], top3);
            if(top3.size() == 3) return;
        }
    }

    class MyChar {
        char ch;
        boolean isLeaf;
        MyChar[] array;

        public MyChar(char ch, boolean isLeaf) {
            this.ch = ch;
            this.isLeaf = isLeaf;
            this.array = new MyChar[26];
        }

        public MyChar add(char c, boolean isLeaf) {
            if(array[c-'a'] != null) {
                if(isLeaf) array[c-'a'].isLeaf = true;
            } else {
                array[c-'a'] = new MyChar(c, isLeaf);
            }
            return array[c-'a'];
        }

        public MyChar get(char c) {
            return array[c-'a'];
        }

    }
}
