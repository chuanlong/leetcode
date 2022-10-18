package com.chuanlong.leetcode.medium;

public class M211_DesignAddAndSearchWordsDataStructure {
    class WordDictionary {

        class TrieNode {
            TrieNode[] children;
            String word;
            TrieNode(){
                this.children = new TrieNode[26];
                this.word = null;
            }
        }

        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            char[] chs = word.toCharArray();
            TrieNode node = root;
            for(char ch : chs) {
                if(node.children[ch-'a'] == null) {
                    node.children[ch-'a'] = new TrieNode();
                }
                node = node.children[ch-'a'];
            }
            node.word = word;
        }

        public boolean search(String word) {
            return search(root, word.toCharArray(), 0);
        }

        private boolean search(TrieNode node, char[] chs, int index) {
            if(node == null) return false;
            if(index >= chs.length) return node.word != null;
            if(chs[index] == '.') {
                for(TrieNode child : node.children) if(search(child, chs, index+1)) return true;
                return false;
            } else {
                return search(node.children[chs[index]-'a'], chs, index+1);
            }
        }
    }

}
