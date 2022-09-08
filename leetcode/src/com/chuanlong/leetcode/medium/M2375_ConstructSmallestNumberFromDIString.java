package com.chuanlong.leetcode.medium;

public class M2375_ConstructSmallestNumberFromDIString {
    public String smallestNumber(String pattern) {
        List<Integer> nums = new ArrayList<>();
        char[] chs = pattern.toCharArray();
        for(int i=1; i<=chs.length+1; i++) {
            nums.add(i);
        }

        StringBuilder sb = new StringBuilder();
        int countD = 0;
        for(int i=0; i<chs.length; i++) {
            if(chs[i] == 'I') {
                if(countD > 0) {
                    for(int j=countD; j>=0; j--) {
                        sb.append(nums.get(j));
                    }
                    nums = nums.subList(countD+1, nums.size());
                    countD = 0;
                } else {
                    sb.append(nums.remove(0));
                }
            } else {
                countD++;
            }
        }
        if(countD > 0) {
            for(int j=countD; j>=0; j--) {
                sb.append(nums.get(j));
            }
            nums = nums.subList(countD+1, nums.size());
            countD = 0;
        }
        if(nums.size() > 0) {
            sb.append(nums.remove(0));
        }
        return sb.toString();
    }
}
