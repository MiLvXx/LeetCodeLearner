package com.xuxin.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int len  = temperatures.length;
        int[] ans = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prev = stack.pop();
                ans[prev] = i - prev;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        new DailyTemperatures().dailyTemperatures(new int[] { 55, 38, 53, 81, 61, 93, 97, 32, 43, 78 });
    }
}
