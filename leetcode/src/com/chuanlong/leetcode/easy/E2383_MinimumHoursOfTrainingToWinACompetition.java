package com.chuanlong.leetcode.easy;

public class E2383_MinimumHoursOfTrainingToWinACompetition {
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
}
