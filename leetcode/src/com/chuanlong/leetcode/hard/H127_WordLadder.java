package com.chuanlong.leetcode.hard;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class H127_WordLadder {

    public static void main(String[] args) {
        H127_WordLadder obj = new H127_WordLadder();

        System.out.println("Test1, expect:5, output:" + obj.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return 1;
        if(wordList.indexOf(endWord) == -1) return 0;
        return bfs(new HashSet<>(wordList), beginWord, endWord);
    }

    private int bfs(Set<String> unvisited, String beginWord, String endWord) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        unvisited.remove(beginWord);
        int depth = 0;
        while(queue.size() > 0) {
            depth++;
            for(int i = queue.size()-1; i>=0; i--) {
                String curWord = queue.poll();
                Set<String> visited = new HashSet<>();
                for(String nextWord: unvisited) {
                    if(isLadder(curWord, nextWord)) {
                        if(nextWord.equals(endWord)) return depth+1;
                        visited.add(nextWord);
                        queue.offer(nextWord);
                    }
                }
                unvisited.removeAll(visited);
            }
        }
        return 0;
    }



//    private int backtrack(Map<String, List<String>> bfsMap,
//                          Map<String, Integer> mem,
//                          Set<String> unvisited,
//                          String curWord, String endWord) {
//        if(curWord.equals(endWord)) return 1;
//        if(mem.containsKey(curWord)) return mem.get(curWord);
//        if(!bfsMap.containsKey(curWord)) return 0;
//
//        List<String> nextWords = bfsMap.get(curWord);
//        int cnt = 0;
//        unvisited.remove(curWord);
//        for(String nextWord : nextWords) {
//            if(unvisited.contains(nextWord)) {
//                cnt += backtrack(bfsMap, mem, unvisited, nextWord, endWord);
//            }
//        }
//        unvisited.add(curWord);
//
//        mem.put(curWord, cnt);
//        return cnt;
//    }

//    int shortest = 0;
//    private Map<String, List<String>> bfs(String beginWord, String endWord, List<String> wordList) {
//        Map<String, List<String>> bfsMap = new HashMap<>();
//
//        if(beginWord.equals(endWord)) {
//            shortest = 1;
//            List<String> sub = new ArrayList<>();
//            sub.add(endWord);
//            bfsMap.put(endWord, sub);
//        } else {
//            Queue<String> queue = new LinkedBlockingQueue<>();
//            Set<String> unvisited = new HashSet<>(wordList);
//            int depth = 0;
//            queue.add(beginWord);
//            unvisited.remove(beginWord);
//            while(queue.size() > 0) {
//                depth++;
//                List<String> visited = new ArrayList<>();
//                boolean flag = false;
//                for(int i=queue.size()-1; i>=0; i--) {
//                    String curWord = queue.poll();
//                    List<String> nextWords = new ArrayList<>();
//                    for(String nextWord: unvisited) {
//                        if(isLadder(curWord, nextWord)) {
//                            visited.add(nextWord);
//                            nextWords.add(nextWord);
//                            if(nextWord.equals(endWord)) {
//                                shortest = depth+1;
//                                flag = true;
//                            }
//                        }
//                    }
//                    if(nextWords.size() > 0) bfsMap.put(curWord, nextWords);
//                }
//                if(flag) break;
//                unvisited.removeAll(visited);
//                for(String visitedWord: visited) queue.offer(visitedWord);
//            }
//        }
//        return bfsMap;
//    }

    private boolean isLadder(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        int cnt = 0;
        for(int i=0; i<word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)) {
                if(cnt == 0) cnt = 1;
                else return false;
            }
        }
        if(cnt == 1) return true;
        else return false;
    }

}
