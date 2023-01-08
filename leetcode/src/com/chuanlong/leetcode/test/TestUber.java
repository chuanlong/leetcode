package com.chuanlong.leetcode.test;

import java.util.*;


class Search {
    TrieNode root;
    List<Character> inputs;
    List<TrieNode> path;

    // Called once
    void init(Map<String, Integer> wordWithWeights) {
        root = new TrieNode();
        inputs = new ArrayList<>();
        path = new ArrayList<>();
        path.add(root);

        for (String key : wordWithWeights.keySet()) {
            int weight = wordWithWeights.get(key);
            char[] chs = key.toCharArray();
            TrieNode node = root;
            for(char ch : chs) {
                if (node.children[ch - 'a'] == null) node.children[ch - 'a'] = new TrieNode();
                node = node.children[ch - 'a'];
            }
            node.word = key;
            node.weight = weight;

            TrieNode node2 = root;
            for(char ch : chs) {
                node2.children[ch-'a'].treeSet.add(node);
                node2 = node2.children[ch-'a'];
            }
        }

    }

    // Called with every new character user presses. Should return an array of the top 10 suggested words.
    List<String> addChar(char c) {
        List<String> result = new ArrayList<>();
        inputs.add(c);
        TrieNode parent = path.get(path.size() - 1);
        TrieNode node = parent.children[c - 'a'];
        path.add(node);
        if (node == null) return result;

        List<TrieNode> temp = new ArrayList<>(node.treeSet);
        for (int i = 0; i < 10 && i < temp.size(); i++) {
            result.add(temp.get(i).word);
        }
        return result;
    }

    // Called when user chooses the word (current result and start again). Increment the weight.
    void choose(String word) {
        char[] chs = word.toCharArray();
        TrieNode node = path.get(path.size() - 1);
        for (int i = inputs.size(); i < chs.length; i++) {
            inputs.add(chs[i]);
            node = node.children[chs[i] - 'a'];
            path.add(node);
        }

        // update weight -> trigger TreeSet update order
        for(int i=1; i<path.size(); i++) {
            path.get(i).treeSet.remove(node);
        }
        node.weight = node.weight + 1;
        for(int i=1; i<path.size(); i++) {
            path.get(i).treeSet.add(node);
        }

        // reset
        inputs.clear();
        path.clear();
        path.add(root);
    }


}
class TrieNode {
    TrieNode[] children;
    TreeSet<TrieNode> treeSet;
    String word;
    int weight;

    public TrieNode() {
        children = new TrieNode[26];
        treeSet = new TreeSet<>((a, b) -> {
            if (a.weight == b.weight) return a.word.compareTo(b.word);
            else return b.weight - a.weight;
        });
        word = null;
        weight = 0;
    }
}


public class TestUber {

    public static void main(String[] args) {
        System.out.println("Hello, World");

        Search obj = new Search();
        Map<String, Integer> wordWithWeights = new HashMap<>();
        wordWithWeights.put("alex", 5);
        wordWithWeights.put("apple", 3);
        wordWithWeights.put("alarm", 2);
        wordWithWeights.put("bus", 1);

        obj.init(wordWithWeights);

        System.out.println("Test1, expect:[alex, apple, alarm], output:" + obj.addChar('a'));
        System.out.println("Test2, expect:[alex, alarm], output:" + obj.addChar('l'));
        obj.choose("alarm");
        System.out.println("Test3, expect:[alex, alarm, apple], output:" + obj.addChar('a'));


    }


}
