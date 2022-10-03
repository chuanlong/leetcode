package com.chuanlong.leetcode.medium;

import javafx.util.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class M1152_AnalyzeUserWebsiteVisitPattern {

    public static void main(String[] args) {
        M1152_AnalyzeUserWebsiteVisitPattern obj = new M1152_AnalyzeUserWebsiteVisitPattern();

        System.out.println("Test1, expect:[home,about,career], output:" + obj.mostVisitedPattern(
                new String[]{"joe","joe","joe","james","james","james","james","mary","mary","mary"},
                new int[]{1,2,3,4,5,6,7,8,9,10},
                new String[]{"home","about","career","home","cart","maps","home","home","about","career"}
        ));

        System.out.println("Test2, expect:[y,y,loedo], output:" + obj.mostVisitedPattern(
                new String[]{"dowg","dowg","dowg"},
                new int[]{158931262,562600350,148438945},
                new String[]{"y","loedo","y"}
        ));


        System.out.println("Test3, expect:[oz,mryxsjc,wlarkzzqht], output:" + obj.mostVisitedPattern(
                new String[]{"zkiikgv","zkiikgv","zkiikgv","zkiikgv"},
                new int[]{436363475,710406388,386655081,797150921},
                new String[]{"wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"}
        ));

        System.out.println("Test4, expect:[hibympufi,hibympufi,yljmntrclw], output:" + obj.mostVisitedPattern(
                new String[]{"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"},
                new int[]{527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930},
                new String[]{"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"}
        ));

    }

    

    // TLE
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair<Integer, String>>> map = new HashMap<>();
        TreeMap<Pattern, Integer> patterns = new TreeMap<>(Pattern::compareTo);

        for(int i=0; i<username.length; i++) {
            if(!map.containsKey(username[i])) map.put(username[i], new ArrayList<>());
            map.get(username[i]).add(new Pair<>(timestamp[i], website[i]));
        }

        for(String key : map.keySet()) {
            List<Pair<Integer, String>> value = map.get(key);
            Collections.sort(value, Comparator.comparingInt(Pair::getKey));
            permutation(value, new ArrayList<>(), new ArrayList<>(), 0, patterns);
        }

        Pattern maxPattern = null;
        int max = Integer.MIN_VALUE;
        for(Pattern p1 : patterns.keySet()) {
            int cnt = patterns.get(p1);
            if(cnt > max) {
                max = cnt;
                maxPattern = p1;
            }
        }

        List<String> result = new ArrayList<>();
        if(maxPattern != null) result = Arrays.asList(maxPattern.patterns[0],maxPattern.patterns[1],maxPattern.patterns[2]);
        return result;
    }

    private void permutation(List<Pair<Integer, String>> list, List<Pattern> visited, List<String> pattern, int index, TreeMap<Pattern, Integer> patterns) {
        if(pattern.size() == 3) {
           Pattern p1 = new Pattern(pattern.get(0), pattern.get(1), pattern.get(2));
           if(!visited.contains(p1)) {
               int cnt = patterns.getOrDefault(p1, 0);
               patterns.put(p1, cnt+1);
               visited.add(p1);
           }
        }
        
        for(int i=index; i<list.size(); i++) {
            Pair<Integer, String> item = list.get(i);
            pattern.add(item.getValue());
            permutation(list, visited, pattern, i+1, patterns);
            pattern.remove(pattern.size()-1);
        }
    }

    class Pattern implements Comparable<Pattern> {
        public String[] patterns;
        public int type; // 1,2,3
        public Pattern(String s1, String s2, String s3) {
            patterns = new String[]{s1, s2, s3};
            type = getType();
        }

        private int getType() {
            if(!patterns[0].equals(patterns[1]) && !patterns[1].equals(patterns[2]) && !patterns[2].equals(patterns[0])) {
                return 1;
            } else if (patterns[0].equals(patterns[2]) && !patterns[0].equals(patterns[1])) {
                return 2;
            } else if(patterns[0].equals(patterns[1]) && patterns[1].equals(patterns[2])) {
                return 3;
            }
            return -1;
        }

        @Override
        public int compareTo(Pattern o) {
            if(patterns[0].equals(o.patterns[0])) {
                if(patterns[1].equals(o.patterns[1])) return patterns[2].compareTo(o.patterns[2]);
                else return patterns[1].compareTo(o.patterns[1]);
            }
            else return patterns[0].compareTo(o.patterns[0]);
        }

        @Override
        public boolean equals(Object o) {
            if(o instanceof Pattern && (compareTo((Pattern)o) == 0)) return true;
            return false;
        }

        @Override
        public int hashCode() {
            return (patterns[0]+patterns[1]+patterns[2]).hashCode();
        }
    }

}
