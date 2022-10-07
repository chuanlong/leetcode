package com.chuanlong.leetcode.medium;

import java.util.Stack;

public class M394_DecodeString {

    public static void main(String[] args) {

        M394_DecodeString obj = new M394_DecodeString();
        String output = obj.decodeString3("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
        System.out.println("Output:\n" + output + "\nExpected:\n" + "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef");

        String output2 = obj.decodeString3("3[a2[c]]");
        System.out.println("Output2:\n" + output2 + "\nExpected:\n" + "accaccacc");

    }

    public String decodeString(String s) {
        char[] chs = s.toCharArray();
        String result = "";

        int num=0;
        for(int i=0; i<chs.length; i++) {
            char ch = chs[i];
            if (ch>='a' && ch<='z') {
                result = result + ch;
            } else if(ch>='0' && ch<='9') {
                num = num*10 + (ch-'0');
            } else if (ch == '[') {
                int j = indexOf(chs, i);
                result = result + getDuplicates(decodeString(s.substring(i+1, j)), num);
                num=0;
                i=j;
            }
        }
        return result;
    }

    private int indexOf(char[] chs, int left) {
        int cnt=0;
        int index = left;
        while(index<chs.length) {
            if(chs[index] == '[') cnt++;
            else if(chs[index] == ']') cnt--;
            if(cnt == 0) break;
            index++;
        }
        return index;
    }

    private String getDuplicates(String token, int num) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<num; i++) sb.append(token);
        return sb.toString();
    }

    public String decodeString3(String s) {
        if (!s.contains("[")) {
            return s;
        }
        String decodedString = "";
        char[] chs = s.toCharArray();
        String stringToken = "";
        String expressionToken = "";
        int count = 0;
        for(int i=0; i<chs.length; i++) {
            if (chs[i] >= 'a' && chs[i] <= 'z') {
                if (expressionToken.length() == 0) {
                    stringToken += chs[i];
                } else {
                    expressionToken += chs[i];
                }
            } else if (chs[i] >= '0' && chs[i] <= '9') {
                if (stringToken.length() != 0) {
                    decodedString += decodeToken(stringToken);
                    stringToken = "";
                }
                expressionToken += chs[i];
            } else if (chs[i] == '[') {
                count++;
                expressionToken += chs[i];
            } else if (chs[i] == ']') {
                count--;
                expressionToken+= chs[i];
                if (count == 0) {
                    decodedString += decodeToken(expressionToken);
                    expressionToken = "";
                }
            } else {
                // error
                break;
            }
        }
        if (stringToken.length()!=0) {
            decodedString += decodeToken(stringToken);
            stringToken="";
        }
        return decodedString;
    }

    public String decodeToken(String s) {
        if (!s.contains("[")) {
            return s;
        }
        int start = s.indexOf("[");
        int end = s.length()-1;
        int num = 0;
        try{
            num = Integer.parseInt(s.substring(0, start));
        }catch (Exception e){
            // error
        }
        String subString = decodeString3(s.substring(start+1, end));
        return repeatString(num, subString);
    }

    private String repeatString(int num, String s) {
        String repeatString = "";
        for(int i=0; i<num; i++) {
            repeatString += s;
        }
        return repeatString;
    }








    public String decodeString2(String s) {
        String decodedString = "";

        char[] chs = s.toCharArray();

        Stack<Integer> nums = new Stack<>();
        Stack<String> tokens = new Stack<>();

        int num = 0;
        String token = "";

        for(int i=0; i<chs.length; i++) {
            if (chs[i] >= 'a' && chs[i] <= 'z') {
                if (nums.empty()) {
                    decodedString += chs[i];
                } else {
                    token += chs[i];
                }
            } else if (chs[i] >= '0' && chs[i] <= '9') {
                if (token.length() != 0) {
                    if (tokens.empty()) {
                        tokens.push(token);
                    } else {
                        tokens.push(tokens.pop() + token);
                    }
                    token = "";
                }
                num = num*10 + (chs[i]-'0');
            } else if (chs[i] == '[') {
                nums.push(num);
                num = 0;
            } else if (chs[i] == ']') {
                if (token.length() != 0) {
                    if (nums.size() == 1) {
                        int n = nums.pop();
                        decodedString += repeatString2(n, token);
                    } else {
                        int n = nums.pop();
                        String repeatString = repeatString2(n, token);
                        if (tokens.empty()) {
                            tokens.push(repeatString);
                        } else {
                            tokens.push(tokens.pop()+repeatString);
                        }
                    }
                    token = "";
                } else {
                    if (nums.size() == 1) {
                        int n = nums.pop();
                        String t = tokens.pop();
                        decodedString += repeatString2(n, t);
                    } else {
                        int n = nums.pop();
                        String t = tokens.pop();
                        String repeatString = repeatString2(n, t);
                        if (tokens.empty()) {
                            tokens.push(repeatString);
                        } else {
                            tokens.push(tokens.pop()+repeatString);
                        }
                    }
                }
            } else {
                // error
                break;
            }
        }

        return decodedString;
    }

    private String repeatString2(int num, String s) {
        String repeatString = "";
        for(int i=0; i<num; i++) {
            repeatString += s;
        }
        return repeatString;
    }

}
