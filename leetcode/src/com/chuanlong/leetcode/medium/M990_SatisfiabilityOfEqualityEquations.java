package com.chuanlong.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class M990_SatisfiabilityOfEqualityEquations {

    public boolean equationsPossible(String[] equations) {
        Map<Character, boolean[]> map = new HashMap<>();
        for(int i=0; i<equations.length; i++) {
            String str = equations[i];
            char ch1 = str.charAt(0);
            char ch2 = str.charAt(3);
            if(str.contains("==")) {
                if(map.containsKey(ch1) && map.containsKey(ch2)) {
                    boolean[] set1 = map.get(ch1);
                    boolean[] set2 = map.get(ch2);
                    for(int j=0; j<26; j++) {
                        if(set2[j]) {
                            set1[j] = true;
                            map.put(((char)('a'+j)), set1);
                        }
                    }
                    set1[ch1-'a'] = true;
                    set1[ch2-'a'] = true;
                    map.put(ch1, set1);
                    map.put(ch2, set1);
                } else {
                    boolean[] set = null;
                    if(map.containsKey(ch1)) set = map.get(ch1);
                    else if(map.containsKey(ch2)) set = map.get(ch2);
                    if(set == null) set = new boolean[26];
                    set[ch1-'a'] = true;
                    set[ch2-'a'] = true;
                    map.put(ch1, set);
                    map.put(ch2, set);
                }
            }
        }

        for(int i=0; i<equations.length; i++) {
            String str = equations[i];
            char ch1 = str.charAt(0);
            char ch2 = str.charAt(3);
            if(str.contains("!=")) {
                if(ch1 == ch2) return false;
                if(map.containsKey(ch1) && map.containsKey(ch2)) {
                    if(map.get(ch1) == map.get(ch2)) return false;
                }
            }

        }
        return true;
    }
}
