package com.chuanlong.leetcode.hard;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class H126_WordLadderII {

    public static void main(String[] args) {
        H126_WordLadderII obj = new H126_WordLadderII();

        System.out.println("Test1, expect:[[hit,hot,dot,dog,cog],[hit,hot,lot,log,cog]], output:"
                + obj.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));

        System.out.println("Test2, expect:[[hit,hot,dot,dog,cog],[hit,hot,lot,log,cog]], output:"
                + obj.findLadders("hit", "cog", Arrays.asList("hot","cog","dot","dog","hit","lot","log")));


        System.out.println("Test3, expect:[[red,ted,tad,tax],[red,ted,tex,tax],[red,rex,tex,tax]], output:"
                + obj.findLadders("red", "tax", Arrays.asList("ted","tex","red","tax","tad","den","rex","pee")));


        System.out.println("Test4, expect:[], output:"
                + obj.findLadders("aaaaa", "ggggg", Arrays.asList("aaaaa","caaaa","cbaaa","daaaa","dbaaa",
                "eaaaa","ebaaa","faaaa","fbaaa","gaaaa","gbaaa","haaaa","hbaaa","iaaaa","ibaaa","jaaaa","jbaaa","kaaaa",
                "kbaaa","laaaa","lbaaa","maaaa","mbaaa","naaaa","nbaaa","oaaaa","obaaa","paaaa","pbaaa","bbaaa","bbcaa",
                "bbcba","bbdaa","bbdba","bbeaa","bbeba","bbfaa","bbfba","bbgaa","bbgba","bbhaa","bbhba","bbiaa","bbiba",
                "bbjaa","bbjba","bbkaa","bbkba","bblaa","bblba","bbmaa","bbmba","bbnaa","bbnba","bboaa","bboba","bbpaa",
                "bbpba","bbbba","abbba","acbba","dbbba","dcbba","ebbba","ecbba","fbbba","fcbba","gbbba","gcbba","hbbba",
                "hcbba","ibbba","icbba","jbbba","jcbba","kbbba","kcbba","lbbba","lcbba","mbbba","mcbba","nbbba","ncbba",
                "obbba","ocbba","pbbba","pcbba","ccbba","ccaba","ccaca","ccdba","ccdca","cceba","cceca","ccfba","ccfca",
                "ccgba","ccgca","cchba","cchca","cciba","ccica","ccjba","ccjca","cckba","cckca","cclba","cclca","ccmba",
                "ccmca","ccnba","ccnca","ccoba","ccoca","ccpba","ccpca","cccca","accca","adcca","bccca","bdcca","eccca",
                "edcca","fccca","fdcca","gccca","gdcca","hccca","hdcca","iccca","idcca","jccca","jdcca","kccca","kdcca",
                "lccca","ldcca","mccca","mdcca","nccca","ndcca","occca","odcca","pccca","pdcca","ddcca","ddaca","ddada",
                "ddbca","ddbda","ddeca","ddeda","ddfca","ddfda","ddgca","ddgda","ddhca","ddhda","ddica","ddida","ddjca",
                "ddjda","ddkca","ddkda","ddlca","ddlda","ddmca","ddmda","ddnca","ddnda","ddoca","ddoda","ddpca","ddpda",
                "dddda","addda","aedda","bddda","bedda","cddda","cedda","fddda","fedda","gddda","gedda","hddda","hedda",
                "iddda","iedda","jddda","jedda","kddda","kedda","lddda","ledda","mddda","medda","nddda","nedda","oddda",
                "oedda","pddda","pedda","eedda","eeada","eeaea","eebda","eebea","eecda","eecea","eefda","eefea","eegda","eegea","eehda","eehea","eeida","eeiea","eejda","eejea","eekda","eekea","eelda","eelea","eemda","eemea","eenda","eenea","eeoda","eeoea","eepda","eepea","eeeea","ggggg","agggg","ahggg","bgggg","bhggg","cgggg","chggg","dgggg","dhggg","egggg","ehggg","fgggg","fhggg","igggg","ihggg","jgggg","jhggg","kgggg","khggg","lgggg","lhggg","mgggg","mhggg","ngggg","nhggg","ogggg","ohggg","pgggg","phggg","hhggg","hhagg","hhahg","hhbgg","hhbhg","hhcgg","hhchg","hhdgg","hhdhg","hhegg","hhehg","hhfgg","hhfhg","hhigg","hhihg","hhjgg","hhjhg","hhkgg","hhkhg","hhlgg","hhlhg","hhmgg","hhmhg","hhngg","hhnhg","hhogg","hhohg","hhpgg","hhphg","hhhhg","ahhhg","aihhg","bhhhg","bihhg","chhhg","cihhg","dhhhg","dihhg","ehhhg","eihhg","fhhhg","fihhg","ghhhg","gihhg","jhhhg","jihhg","khhhg","kihhg","lhhhg","lihhg","mhhhg","mihhg","nhhhg","nihhg","ohhhg","oihhg","phhhg","pihhg","iihhg","iiahg","iiaig","iibhg","iibig","iichg","iicig","iidhg","iidig","iiehg","iieig","iifhg","iifig","iighg","iigig","iijhg","iijig","iikhg","iikig","iilhg","iilig","iimhg","iimig","iinhg","iinig","iiohg","iioig","iiphg","iipig","iiiig","aiiig","ajiig","biiig","bjiig","ciiig","cjiig","diiig","djiig","eiiig","ejiig","fiiig","fjiig","giiig","gjiig","hiiig","hjiig","kiiig","kjiig","liiig","ljiig","miiig","mjiig","niiig","njiig","oiiig","ojiig","piiig","pjiig","jjiig","jjaig","jjajg","jjbig","jjbjg","jjcig","jjcjg","jjdig","jjdjg","jjeig","jjejg","jjfig","jjfjg","jjgig","jjgjg","jjhig","jjhjg","jjkig","jjkjg","jjlig","jjljg","jjmig","jjmjg","jjnig","jjnjg","jjoig","jjojg","jjpig","jjpjg","jjjjg","ajjjg","akjjg","bjjjg","bkjjg","cjjjg","ckjjg","djjjg","dkjjg","ejjjg","ekjjg","fjjjg","fkjjg","gjjjg","gkjjg","hjjjg","hkjjg","ijjjg","ikjjg","ljjjg","lkjjg","mjjjg","mkjjg","njjjg","nkjjg","ojjjg","okjjg","pjjjg","pkjjg","kkjjg","kkajg","kkakg","kkbjg","kkbkg","kkcjg","kkckg","kkdjg","kkdkg","kkejg","kkekg","kkfjg","kkfkg","kkgjg","kkgkg","kkhjg","kkhkg","kkijg","kkikg","kkljg","kklkg","kkmjg","kkmkg","kknjg","kknkg","kkojg","kkokg","kkpjg","kkpkg","kkkkg","ggggx","gggxx","ggxxx","gxxxx","xxxxx","xxxxy","xxxyy","xxyyy","xyyyy","yyyyy","yyyyw","yyyww","yywww","ywwww","wwwww","wwvww","wvvww","vvvww","vvvwz","avvwz","aavwz","aaawz","aaaaz")));

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(wordList.indexOf(endWord) == -1) return new ArrayList<>();
        Map<String, List<String>> bfsMap = getBfsMap(beginWord, endWord, wordList);
        return backtrack(bfsMap, new HashMap<>(), new HashSet<>(), beginWord, endWord);
    }

    private List<List<String>> backtrack(Map<String, List<String>> bfsMap,
                           Map<String, List<List<String>>> mem,
                           Set<String> visited,
                           String curWord,
                           String endWord) {
        if(curWord.equals(endWord)) {
            List<List<String>> result = new ArrayList<>();
            List<String> path = new ArrayList<>();
            path.add(endWord);
            result.add(path);
            mem.put(endWord, result);
            return result;
        }
        if(!bfsMap.containsKey(curWord)) return new ArrayList<>();
        if(mem.containsKey(curWord)) return mem.get(curWord);

        List<List<String>> result = new ArrayList<>();
        List<String> nextWords = bfsMap.get(curWord);
        visited.add(curWord);
        for(String nextWord: nextWords) {
            if(!visited.contains(nextWord)) {
                List<List<String>> nextResult = backtrack(bfsMap, mem, visited, nextWord, endWord);
                for(List<String> sub: nextResult) {
                    List<String> newSub = copy(sub);
                    newSub.add(0, curWord);
                    result.add(newSub);
                }
            }
        }
        visited.remove(curWord);
        mem.put(curWord, result);
        return result;
    }

    private Map<String, List<String>> getBfsMap(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> bfsMap = new HashMap<>();
        Set<String> unvisited = new HashSet<>();
        unvisited.addAll(wordList);
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        unvisited.remove(beginWord);
        while(queue.size() > 0) {
            int size = queue.size();
            Set<String> visited = new HashSet<>();
            boolean flag = false;
            for(int i=0; i<size; i++) {
                String curWord = queue.poll();
                List<String> nextWords = new ArrayList<>();
                for(String nextWord: unvisited) {
                    if(isLadder(curWord, nextWord)) {
                        nextWords.add(nextWord);
                        visited.add(nextWord);
                        if(nextWord.equals(endWord)) flag = true;
                    }
                }
                bfsMap.put(curWord, nextWords);
            }
            if(flag) break;
            unvisited.removeAll(visited);
            for(String visitedWord: visited) queue.offer(visitedWord);
        }

        return bfsMap;
    }

    private boolean isLadder(String str1, String str2) {
        if(str1.length() != str2.length()) return false;
        int cnt=0;
        for(int i=0; i<str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                if(cnt==0) cnt=1;
                else return false;
            }
        }
        if(cnt==1) return true;
        else return false;
    }

    private List<String> copy(List<String> old) {
        List<String> newList =new ArrayList<>();
        newList.addAll(old);
        return newList;
    }




    // TLE
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<String> unVisited = new ArrayList<>();
//        unVisited.addAll(wordList);
//        List<String> list = new ArrayList<>();
//        min = Integer.MAX_VALUE;
//        result = new ArrayList<>();
//        dfs(list, unVisited, beginWord, endWord);
//        return result;
//    }
//
//    int min = Integer.MAX_VALUE;
//    List<List<String>> result = new ArrayList<>();
//    private void dfs(List<String> list, List<String> unvisited, String curWord, String endWord) {
//        if(list.size()>min) return;
//        if(curWord.equals(endWord)) {
//            if(list.size()+1 > min) {
//                return;
//            } else if(list.size()+1 < min) {
//                min = list.size()+1;
//                result.clear();
//            }
//            List<String> item = copy(list);
//            item.add(endWord);
//            result.add(item);
//            return;
//        }
//        if(unvisited.indexOf(endWord) == -1) return;
//
//        List<String> newUnvisited = copy(unvisited);
//        for(int i=0; i<unvisited.size(); i++) {
//            String newWord = unvisited.get(i);
//            if(isLadder(curWord, newWord)) {
//                newUnvisited.remove(i);
//                list.add(curWord);
//                dfs(list, newUnvisited, newWord, endWord);
//                list.remove(list.size()-1);
//                newUnvisited.add(i, newWord);
//            }
//        }
//    }
//
//    private List<String> copy(List<String> old) {
//        List<String> newList =new ArrayList<>();
//        newList.addAll(old);
//        return newList;
//    }
//
//
//    private boolean isLadder(String str1, String str2) {
//        if(str1.length() != str2.length()) return false;
//        int cnt=0;
//        for(int i=0; i<str1.length(); i++) {
//            if(str1.charAt(i) != str2.charAt(i)) {
//                if(cnt==0) cnt=1;
//                else return false;
//            }
//        }
//        if(cnt==1) return true;
//        else return false;
//    }



    // WA
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        Map<String, List<List<String>>> map = new HashMap<>();
//        List<String> unVisited = new ArrayList<>();
//        unVisited.addAll(wordList);
//        return dfs(map, unVisited, beginWord, endWord);
//    }
//
//
//     private List<List<String>> dfs(
//         Map<String, List<List<String>>> map,
//         List<String> unVisited,
//         String currentWord,
//         String endWord) {
//         if(map.containsKey(currentWord)) return map.get(currentWord);
//         List<List<String>> list = new ArrayList<>();
//         if(currentWord.equals(endWord)) {
//             List<String> path = new ArrayList<>();
//             path.add(endWord);
//             list.add(path);
//             map.put(currentWord, list);
//             return list;
//         }
//         if(unVisited.indexOf(endWord) == -1){
//             map.put(currentWord, list);
//             return list;
//         }
//
//         int min = Integer.MAX_VALUE;
//         List<String> unVisitedCopy = copy(unVisited);
//         for(int i=0; i<unVisited.size(); i++) {
//             String newWord = unVisited.get(i);
//             if(isLadder(currentWord, newWord)) {
//                 unVisitedCopy.remove(i);
//                 List<List<String>> subPaths = dfs(map, unVisitedCopy, newWord, endWord);
//                 for(List<String> subPath: subPaths) {
//                     if(subPath.size()+1 > min) {
//                         break;
//                     } else if (subPath.size()+1 < min) {
//                         min = subPath.size()+1;
//                         list.clear();
//                     }
//                     List<String> newSubPath = copy(subPath);
//                     newSubPath.add(0, currentWord);
//                     list.add(newSubPath);
//                 }
//                 unVisitedCopy.add(i, newWord);
//             }
//         }
//
//         map.put(currentWord, list);
//         return list;
//     }
//
//     private boolean isLadder(String str1, String str2) {
//        if(str1.length() != str2.length()) return false;
//        int cnt=0;
//        for(int i=0; i<str1.length(); i++) {
//            if(str1.charAt(i) != str2.charAt(i)) {
//                if(cnt==0) cnt=1;
//                else return false;
//            }
//        }
//        if(cnt==1) return true;
//        else return false;
//     }
//
//     private List<String> copy(List<String> old) {
//        List<String> newList =new ArrayList<>();
//        newList.addAll(old);
//        return newList;
//     }

}
