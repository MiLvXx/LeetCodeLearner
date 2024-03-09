package com.xuxin.solution;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int head = 0, res = 0;
        while (head < nums.length) {
            int sum = 0, tail = head;
            while (tail < nums.length) {
                sum += nums[tail];
                if (sum == k) {
                    res++;
                }
                tail++;
            }
            head++;
        }
        return res;
    }
}
