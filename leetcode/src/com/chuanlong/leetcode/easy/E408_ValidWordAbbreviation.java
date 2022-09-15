package com.chuanlong.leetcode.easy;

public class E408_ValidWordAbbreviation {

    public static void main(String[] args) {
        E408_ValidWordAbbreviation obj = new E408_ValidWordAbbreviation();

        System.out.println("Test1, expect:true, output:" + obj.validWordAbbreviation("substitution", "s10n"));
        System.out.println("Test2, expect:true, output:" + obj.validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println("Test3, expect:true, output:" + obj.validWordAbbreviation("internationalization", "i5a11o1"));
        System.out.println("Test4, expect:false, output:" + obj.validWordAbbreviation("hi", "2i"));
        System.out.println("Test4, expect:false, output:" + obj.validWordAbbreviation("ab", "a"));

    }

    public boolean validWordAbbreviation(String word, String abbr) {
        char[] chs = word.toCharArray();
        char[] chs2 = abbr.toCharArray();

        int token = 0;
        int index = 0;
        for(int i=0; i<chs2.length; i++) {
            if(chs2[i] >= '0' && chs2[i] <= '9') {
                if(chs2[i] == '0' && token == 0) return false;
                token = token*10+(chs2[i]-'0');
            } else if (chs2[i] >= 'a' && chs2[i] <= 'z') {
                if(token > 0) index = index+token;
                if(index>=chs.length || chs2[i] != chs[index]) return false;
                token = 0;
                index++;
            }
        }
        if(token > 0) index = index+token;
        if(index != chs.length) return false;
        return true;
    }

}
