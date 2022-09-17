package com.chuanlong.leetcode.medium;

import java.util.*;

public class M1048_LongestStringChain {

    public static void main(String[] args) {
        M1048_LongestStringChain obj = new M1048_LongestStringChain();

        System.out.println("Test1, expect:4, output:" + obj.longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
        System.out.println("Test2, expect:8, output:" + obj.longestStrChain(new String[]{
                "qyssedya","pabouk","mjwdrbqwp","vylodpmwp","nfyqeowa","pu","paboukc","qssedya",
                "lopmw","nfyqowa","vlodpmw","mwdrqwp","opmw","qsda","neo","qyssedhyac","pmw",
                "lodpmw","mjwdrqwp","eo","nfqwa","pabuk","nfyqwa","qssdya","qsdya",
                "qyssedhya","pabu","nqwa","pabqoukc","pbu","mw","vlodpmwp","x","xr"}));


        System.out.println("Test11, expect:true, output:" + obj.isPredecessor("abc", "abac"));
        System.out.println("Test12, expect:false, output:" + obj.isPredecessor("cba", "bcad"));
    }

    public int longestStrChain(String[] words) {
        TreeMap<Integer, List<String>> map = new TreeMap<>((a, b) -> b-a);
        for(int i=0; i<words.length; i++) {
            if(!map.containsKey(words[i].length())) map.put(words[i].length(), new ArrayList<>());
            map.get(words[i].length()).add(words[i]);
        }

        Map<String, Integer> visited = new HashMap<>();
        int max = 1;
        for(int key : map.keySet()) {
            for(String s: map.get(key)) {
                max = Math.max(max, getChainLength(map, visited, s));
            }
        }
        return max;
    }

    private int getChainLength(TreeMap<Integer, List<String>> map, Map<String, Integer> visited, String s) {
        if(visited.containsKey(s)) return visited.get(s);

        if(!map.containsKey(s.length()+1)) {
            visited.put(s, 1);
            return 1;
        }

        int max = 1;
        for(String next : map.get(s.length()+1)) {
            if(isPredecessor(s, next)) max = Math.max(max, getChainLength(map, visited, next)+1);
        }
        visited.put(s, max);
        return max;
    }

    private boolean isPredecessor(String word1, String word2) {
        if(word1.length() + 1 != word2.length()) return false;
        int cnt = 0;
        for(int i=0; i<word1.length(); ) {
            if(word1.charAt(i) != word2.charAt(i+cnt)) {
                if(cnt == 0) cnt = 1;
                else return false;
            } else {
                i++;
            }
        }
        return true;
    }

}
