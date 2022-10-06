package com.chuanlong.leetcode.medium;

import java.util.TreeSet;

public class M720_LongestWordInDictionary {

    public String longestWord(String[] words) {
        TreeSet<String> set = new TreeSet<>();
        for(int i=0; i<words.length; i++) set.add(words[i]);
        longest = "";
        dfs(set, "");
        return longest;
    }

    String longest = "";
    private void dfs(TreeSet<String> set, String prefix){
        if(prefix.length() > longest.length()) {
            longest = prefix;
        } else if (prefix.length() == longest.length() && prefix.compareTo(longest) < 0){
            longest = prefix;
        }

        for(int i=0; i<26; i++) {
            char ch = (char)('a'+i);
            if(set.contains(prefix+ch)) {
                dfs(set, prefix+ch);
            }
        }
    }

}
