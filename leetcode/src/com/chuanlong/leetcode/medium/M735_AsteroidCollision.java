package com.chuanlong.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M735_AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while(index < asteroids.length) {
            int aste = asteroids[index++];
            if(stack.size() == 0) {
                stack.push(aste);
                continue;
            }

            if(aste > 0) {
                stack.push(aste);
            } else {
                while(aste < 0 && stack.size() > 0 && stack.peek() > 0) {
                    if(stack.peek() > 0-aste) {
                        aste = 0;
                    } else if (stack.peek() == 0-aste) {
                        stack.pop();
                        aste = 0;
                    } else {
                        stack.pop();
                    }
                }
                if(aste != 0) stack.push(aste);
            }
        }
        int[] result = new int[stack.size()];
        for(int i=stack.size()-1; i>=0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    public int[] asteroidCollision2(int[] asteroids) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<asteroids.length; i++) list.add(asteroids[i]);
        List<Integer> result = collision(list);
        while(result.size() < list.size()) {
            list = result;
            result = collision(result);
        }
        int[] result1 = new int[result.size()];
        for(int i=0; i<result.size();i++) result1[i] = result.get(i);
        return result1;
    }

    private List<Integer> collision(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        int index=0;
        while(index<list.size()-1) {
            int xSpeed = list.get(index), ySpeed = list.get(index+1);
            if (xSpeed>0 && ySpeed<0) {
                if(xSpeed>0-ySpeed) result.add(xSpeed);
                else if(xSpeed<0-ySpeed) result.add(ySpeed);
                index = index+2;
            } else {
                result.add(xSpeed);
                index++;
            }
        }
        if(index<list.size()) result.add(list.get(index));
        return result;
    }
}
