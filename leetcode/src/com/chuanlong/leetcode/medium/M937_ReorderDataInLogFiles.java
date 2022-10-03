package com.chuanlong.leetcode.medium;

import com.chuanlong.leetcode.util.Util;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;

public class M937_ReorderDataInLogFiles {

    public static void main(String[] args) {
        M937_ReorderDataInLogFiles obj = new M937_ReorderDataInLogFiles();

        System.out.println("Test1, expect:[\"let1 art can\",\"let3 art zero\",\"let2 own kit dig\",\"dig1 8 1 5 1\",\"dig2 3 6\"], output:"
                + Util.Array2String(obj.reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"})));

    }

    public String[] reorderLogFiles(String[] logs) {
        Pair<String, Integer>[] newArrays = new Pair[logs.length];
        for(int i=0; i<logs.length; i++) {
            newArrays[i] = new Pair<>(logs[i], i);
        }

        Arrays.sort(newArrays, (a, b) -> compareLog(a, b));
        String[] result = new String[newArrays.length];
        for(int i=0; i<newArrays.length; i++) {
            result[i] = newArrays[i].getKey();
        }
        return result;
    }

    // -1:log1<log2, 0:log1==log2, 1:log1>log2
    private int compareLog(Pair<String, Integer> pair1, Pair<String, Integer> pair2) {
        String log1 = pair1.getKey();
        String log2 = pair2.getKey();

        boolean isLetter1 = isLetterLog(log1);
        boolean isLetter2 = isLetterLog(log2);

        if(isLetter1 && !isLetter2) return -1;
        else if (!isLetter1 && isLetter2) return 1;
        else if (!isLetter1 && !isLetter2) {
            return pair1.getValue()-pair2.getValue();
        }

        // both letter
        String[] tokens1 = log1.split(" ");
        String[] tokens2 = log2.split(" ");
        String id1 = tokens1[0];
        String id2 = tokens2[0];
        String subLog1 = log1.substring(id1.length());
        String subLog2 = log2.substring(id2.length());
        if(subLog1.equals(subLog2)) return id1.compareTo(id2);
        return subLog1.compareTo(subLog2);
    }

    private boolean isLetterLog(String log) {
        String[] tokens = log.split(" ");
        char ch = tokens[1].charAt(0);
        if(ch-'a'>=0 && ch-'a'<26) return true;
        else return false;
    }
}
