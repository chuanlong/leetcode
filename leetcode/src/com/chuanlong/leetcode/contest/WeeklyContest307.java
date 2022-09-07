package com.chuanlong.leetcode.contest;

// 28:04 minutes, 1 error
public class WeeklyContest307 {

    public static void main(String[] args) {
        WeeklyContest307 obj = new WeeklyContest307();

        System.out.println("Test1, expect:7449447, output:" + obj.largestPalindromic("444947137"));
    }


    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int trainedEnergy = 0;
        int sumEnergy = 0;
        for(int i=0; i<energy.length; i++) {
            sumEnergy += energy[i];
        }
        if(initialEnergy <= sumEnergy) {
            trainedEnergy = sumEnergy-initialEnergy+1;
        }

        int trainedExperience = 0;
        int currentExperience = initialExperience;
        for(int i=0; i<experience.length; i++) {
            if(currentExperience <= experience[i]) {
                trainedExperience += experience[i] - currentExperience + 1;
                currentExperience = experience[i] + 1;
            }
            currentExperience += experience[i];
        }

        return trainedEnergy + trainedExperience;
    }


    public String largestPalindromic(String num) {
        int[] count = new int[10];
        char[] chs = num.toCharArray();
        for(int i=0; i<chs.length; i++) {
            count[chs[i]-'0'] ++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=count.length-1; i>0; i--) {
            if(count[i] == 0) continue;
            int repeat = count[i] / 2;
            sb.append(getToken(i+"", repeat));
            count[i] = count[i] - 2*repeat;
        }

        // check no leading zeros
        if(sb.length() > 0) {
            int repeat = count[0] / 2;
            sb.append(getToken("0", repeat));
            count[0] = count[0] - 2*repeat;
        }

        // add one big digit in the middle
        String middle = "";
        for(int i=count.length-1; i>=0; i--) {
            if(count[i] >0 ){
                middle = i+"";
                break;
            }
        }

        return sb.toString() + middle + sb.reverse().toString();
    }

    private String getToken(String digit, int count) {
        String token = "";
        for(int i=0; i<count; i++) {
            token += digit;
        }
        return token;
    }
}
