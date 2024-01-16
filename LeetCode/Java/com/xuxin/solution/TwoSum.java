package com.xuxin.solution;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length - 1;
        while (true) {
            if (numbers[head] + numbers[tail] > target) {
                tail--;
            } else if (numbers[head] + numbers[tail] < target) {
                head++;
            } else {
                return new int[] { head + 1, tail + 1 };
            }
        }
    }
}
