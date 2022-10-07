package com.chuanlong.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TestByteDance3 {


    /*
    Example 1:
    Input: asteroids = [5,10,-5]
    Output: [5,10]
    Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

    Example 2:
    Input: asteroids = [8,-8]
    Output: []
    Explanation: The 8 and -8 collide exploding each other.

    Example 3:
    Input: asteroids = [10,2,-5]
    Output: [10]
    Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

    Input: asteroids = [1,2,3,-6]
    output: [-6]
    */
    public static void main(String[] args) {
        TestByteDance3 obj = new TestByteDance3();

        System.out.println("Test1, expect:[-6], output:" + obj.move(Arrays.asList(1,2,3,-6)));
        System.out.println("Test2, expect:[-6], output:" + obj.move2(Arrays.asList(1,2,3,-6)));
        System.out.println("Test3, expect:[5,10], output:" + obj.move(Arrays.asList(5,10,-5)));
        System.out.println("Test4, expect:[5,10], output:" + obj.move2(Arrays.asList(5,10,-5)));

    }


    // [-1,2,3,-4]
    public List<Integer> move2(List<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            int aste = list.get(i);
            if (aste > 0) {
                stack.push(aste);
            } else {
                // aste < 0
                while (stack.size() > 0) {
                    int top = stack.peek();
                    if (top > 0) {
                        if (top > 0 - aste) {
                            aste = 0;
                            break;
                        } else if (top == 0 - aste) {
                            aste = 0;
                            stack.pop();
                            break;
                        } else {
                            // top < 0-aste
                            stack.pop();
                        }
                    } else {
                        // stack.push(aste);
                        break;
                    }
                }
                if (aste != 0) stack.push(aste);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (stack.size() > 0) {
            int aste = stack.pop();
            result.add(0, aste);
        }
        return result;
    }


    public List<Integer> move(List<Integer> list) {
        List<Integer> result = check(list);
        List<Integer> prev = list;
        while (result.size() < prev.size()) {
            prev = result;
            result = check(prev);
        }
        return result;
    }

    // [10, -5]
    private List<Integer> check(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        int index = 0;
        while (index + 1 < list.size()) {
            if (list.get(index) > 0 && list.get(index + 1) < 0) {
                int aste1 = list.get(index);
                int aste2 = 0 - list.get(index + 1);
                if (aste1 == aste2) {
                } else if (aste1 < aste2) {
                    result.add(list.get(index + 1));
                } else {
                    // astes1 > aste2
                    result.add(list.get(index));
                }
                index = index + 2;
            } else {
                result.add(list.get(index));
                index++;
            }
        }
        if (index < list.size()) result.add(list.get(index));
        return result;
    }


}
