package com.chuanlong.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class E804_UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        Map<String, Boolean> map = new HashMap<>();
        for(int i=0; i<words.length; i++) {
            char[] chs = words[i].toCharArray();
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<chs.length; j++) {
                sb.append(token[chs[j]-'a']);
            }
            map.put(sb.toString(), true);
        }
        return map.size();
    }


    private String[] token = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

}
